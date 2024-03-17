import React, { useState } from 'react';
import axios from 'axios';

// form-data axios로 file 전송하기
export default function Multipart(){
    const [file, setFile] = useState()

    function handleFile(event) {
        //input 의 변화를 감지 파일 셋팅
        setFile(event.target.files[0])
        console.log(event.target.files[0])
    }
    function handleUpload(){
        const formData = new FormData()
        formData.append('file', file)
        fetch(
            'http://localhost:8080/api/fileUpload',
            {
                method: "POST",
                body: formData
            }
        ).then((reponse) => reponse.json()).then(
            (result) => {
                console.log('success', result)
            }
        ).catch(error => {
            console.error("Error:", error)
        })
    }

    return(
        <div>
            <h1>file upload 하겠습니다</h1>
            <form onSubmit={ handleUpload }>
                <input type='file' name='file' onChange={ handleFile } />
                <button>파일올림</button>
            </form>
        </div>
    );
}


