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
<div id="bookp_div">
	<table>
		<caption>도서 대출/연체</caption>
		<tr><th>분류</th><th>책의 이름</th><th>도서 상태여부</th><th>대출일</th><th>반납 예정일</th></tr>
		<c:forEach var="book" items="${personalBook}">
			<tr><td>${book.bookColum}</td><td>${book.bookName}</td>
			<td><c:choose><c:when test="${!book.bookOverdue}">대출</c:when><c:otherwise>연체</c:otherwise></c:choose></td>
			<td>${book.startTime}</td><td>${book.stopTime}</td>
			<td><a href="BookReturn.do?bookNumber=${book.bookNumber}&id=${LoginInfo.id}">반납</a></td></tr>
		</c:forEach>
	</table>
	<hr>
	<table>
		<caption>지난 도서 기록</caption>
		<tr><th>분류</th><th>책의 이름</th><th>도서 상태여부</th><th>대출일</th><th>반납 예정일</th></tr>
		<c:choose>
			<c:when test="${personalBookHistory == null }"> <tr><td colspan="5">도서 대출/연체 기록이 없습니다.</td></tr></c:when>
			<c:otherwise>
				<c:forEach var="bookHistory" items="${personalBookHistory}">
					<tr><td>${bookHistory.bookColum}</td><td>${bookHistory.bookName}</td>
					<td><c:choose><c:when test="${!bookHistory.bookSubmit}">반납</c:when><c:otherwise></c:otherwise></c:choose></td>
					<td>${bookHistory.startTime}</td><td>${bookHistory.stopTime}</td></tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	
</div>

</body>
</html>