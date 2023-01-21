<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginCheckPw.css">
</head>
<body>
<div id="MainSearch">
        <div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울도서관</p></div>
        <hr>
        <div><img src="../../Img/LoginImg/findIdBg.gif"><p>비밀번호 확인</p></div>
        
        
        <div></div>
        <div id="email_box">
            <form action="LoginCheckPw.do" method="post">
                	<input type="text" name="id" value="${id}" style="display: none" readonly="readonly">
                <ul>
                    <li>기존 비밀번호</li>
                    <li class="name_text">
                        <input type="password" name="pw">
                    </li>
                    
                </ul>
                <br>
                <button type="submit">비밀번호 변경</button>
            </form>
        </div>

    </div>

</body>
</html>