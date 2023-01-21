<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${errorCode1 eq 1}">
		<p>연체된 도서가 있습니다. 가까운 시일내에 반납 부탁드립니다.</p>
	</c:if>
	<c:if test="${errorCode2 eq 2}">
		<p>도서의 수가 5권이 넘습니다.</p>
	</c:if>
	<input type="text" id="id" style="display: none" value="${LoginInfo.id}">
	
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