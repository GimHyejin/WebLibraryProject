<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bookp_div table{
		border:1px solid black;
		border-collapse: 0;
	}
</style>
</head>
<body>
<div id="bookp_div">
	<table>
		<tr><th>분류</th><th>책의 이름</th><th>도서 상태여부</th><th>대출일</th><th>반납 예정일</th></tr>
		<c:forEach var="book" items="${personalBook}">
			<tr><td>${book.bookColum}</td><td>${book.bookName}</td>
			<td><c:choose><c:when test="${!book.bookOverdue}">대출</c:when><c:otherwise>연체</c:otherwise></c:choose></td>
			<td>${book.startTime}</td><td>${book.stopTime}</td></tr>
		</c:forEach>
	</table>
	
</div>
</body>
</html>