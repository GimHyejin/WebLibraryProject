<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginPage.css">
</head>
<body>
    <div id="MainLogin_div">
        <div ><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울 도서관</p></div>
        <div>
            <form action="LoginOk.do" method="get">
                <input type="text" name="id" placeholder="아이디" required="required"><br>
                <input type="password" name="pw" placeholder="비밀번호" required="required"><br>
                <input type="submit" value="로그인">
            </form>
        </div>
        <div>
            <table>
                <tr>
                    <td>    </td>
                    <td>    </td>
                    <td><a href="MainSearchId.do">아이디 찾기</a></td>
                    <td><a href="LoginSearchPw.do">비밀번호 찾기</a></td>
                    <td><a href="LoginJoinCheck.do">회원가입</a></td>
                    <td> </td>
                </tr>
            </table>
        </div>
        
    </div>
</body>
</html>
</html>