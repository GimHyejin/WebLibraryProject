<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="LoginExIdOk.do" method="get" onsubmit="Exid()">
		
			<input type="text" id="id" value="" name="id" minlength="5" maxlength="10" size="12"  pattern="^(?=.*[a-zA-Z])[a-zA-Z0-9]{5,10}" placeholder="5~10자(영문 대소문자, 숫자)" title="5~10자의 영문 대소문자와 숫자로만 입력하세요.(영문자 포함)"  required="required">
		    <button>아이디 중복확인</button>
		</form>
	
    
    <script src= "../../Js/WindowJs/LoginExId.js"></script>
</body>
</html>