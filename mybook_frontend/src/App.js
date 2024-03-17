/* eslint-disable */

import React, { useState } from 'react';
import logo from './logo.svg';
import axios from 'axios';
import './App.css';


function App() {
    addEventListener('click', ()=>{
        함수
    })

    let [따봉, 따봉변경] = useState(0);
    

    var [a,b] = [10, 100];

    let [글제목, 글제목변경] = useState('데이터 저장 하는 법 State 변경을 위해');
    let [글제목2, 글제목변경2] = useState(['State 저장하세요', 'array 저장가능', '키움 망함']);

    function 제목바꾸기(){
        var newArray = [...글제목2];
        newArray[0] = '변경할게요';
        글제목변경2(newArray);
    }

    let posts = '신림 맛집 어디야';
    let st = {color : 'blue', fontSize : '30px'}
    function 함수(){
        return 100
    }

    return (
        <div className="App">
            <div className="black-nav">
                <div>개발 Blog</div>
            </div>
            데이터 바인딩이 쉽다
            <h4>{ posts } 중괄호를 써서 쉽게</h4>
            { 함수() } 
            딥카피하세요!!!
            따봉변경(변경할데이터)
            함수도 쉽게 중괄호에 넣어서 사용가능
            여러분이 상상하는 모든 곳에 중괄호 사용 가능 클래스네임에도 중괄호 사용 가능
            eslint는 문법 워닝 체크하는 것 /* eslint-disable */ 적으면 체크 안함
            <div style={ {color : 'blue', fontSize : '30px'} }>스타일 중괄호 안에</div>이렇게 이미지도 가능함
            <div style={ st }>스타일 중괄호 안에</div>이렇게 이미지도 가능함
            <hr/>
            <div className='list'>
                <h3>{ 글제목2[0] } <span onClick={ ()=>{console.log(1)} }>☎</span> 0 </h3>
                <p>3월 13일 발행</p>
                <hr/>
            </div>
            <div className='list'>
                <h3>{ 글제목2[1] } <span onClick={ ()=>{ 따봉변경(따봉 + 1) } }>☎</span> { 따봉 } </h3>
                <p>3월 13일 발행</p>
                <hr/>
            </div>
            <div className='list'>
                <h3>{ 글제목2[2] }</h3>
                <p>3월 13일 발행</p>
                <hr/>
            </div>
            <hr/>
            <button onClick={ 제목바꾸기 }>버튼</button>
        </div>
    );
}

export default App;
