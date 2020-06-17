<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        nav {
            width: 100%;
            height: 30px;
            background-color: rgb(90, 90, 87);
            padding-left: 20px;


        }

        nav>div {
            float: left;
            padding-left: 100px;
            line-height: 30px;
        }

        #sub {
            position: absolute;
            width: 100px;
            height: 100px;
            background: rgb(90, 90, 87);
            top: 0px;
            left: 100px;
            transition: 2s;
            opacity: 0;
        }

        #cu {
            position: relative;
        }

        #cu:hover #sub {
            border: grey;
            transform: translatey(30px);
            opacity: 1;

        }

        
    </style>
</head>
<body>

    <nav>
        <div>교육센터소개 </div>
        <div>교육센터연혁 </div>
        <div id="cu">교육과정
            <div id="sub">
                <ul>자바</ul>
                <ul>웹퍼블리셔</ul>
                <ul>네트워크</ul>
            </div>

        </div>
    </nav>
</body>
</html>