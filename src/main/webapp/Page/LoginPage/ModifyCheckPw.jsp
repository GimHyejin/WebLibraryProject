<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginCheckPw.css">
</head>
<body>
	<div id="MainSearch">
        <div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울 도서관</p></div>
        <hr>
        <div><img src="../../Img/LoginImg/findIdBg.gif"><p>비밀번호 확인</p></div>
        
        
        <div></div>
        <div id="email_box">
            <form action="ModifyCheckPwOk.do" method="post" onsubmit="return check_pw()">
                <input type="text" id="pw2" name="pw2" style="display: none" value="${LoginInfo.pw}" readonly="readonly">
                <ul>
                    <li>기존 비밀번호</li>
                    <li class="name_text">
                        <input type="password" id="pw" name="pw" value="">
                    </li>
                    
                </ul>
                <br>
                <button type="submit">비밀번호 변경</button>
            </form>
        </div>
    </div>
    <script type="text/javascript" src="../../Js/LoginJs/LoginChangePwOk.js"></script>
</body>
</html>