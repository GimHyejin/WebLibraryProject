<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="../../Css/LoginCss/LogInSearchIdPwInfo.css">
<title>Insert title here</title>
</head>
<body>
    <div id="MainSearch">
        <div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울 도서관</p></div>
        <hr>
        <div><img src="../../Img/LoginImg/findIdBg.gif"><p>아이디 찾기</p></div>
        
        
        <div></div>
        <div id="email_box">
            <p>현재 가입된 아이디의 정보는 ${id} </p>
        </div>

    </div>
    
</body>
</html>