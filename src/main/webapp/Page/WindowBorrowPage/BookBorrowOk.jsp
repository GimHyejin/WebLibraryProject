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
	<p>도서 대출 완료</p>
	<a href="BookPersonal.do?id=${LoginInfo.id}">대출한 도서 확인</a>
	<a href="#" onclick="goMain()">닫기</a>
	
	
	<script type="text/javascript">
		
		function goMain(){
			opener.location.reload();
			window.close();
		}
	
	</script>
</body>
</html>