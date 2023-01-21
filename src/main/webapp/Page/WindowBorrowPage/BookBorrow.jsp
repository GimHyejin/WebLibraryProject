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
	<form action="BookBorrow.do">
		<input type="text" style="display: none" id="borrowBookNumber" name="bookNumber" value="" readonly="readonly">
		<input type="text"  id="borrowBookName" name="bookName" value="" readonly="readonly">
	    <input type="text"  id="borrowBookColum" name="bookColum" value="" readonly="readonly">
	    <input type="text" style="display: none" name = "id" value="${LoginInfo.id}">
		<input type="submit" value="검색">
	</form>
    
</body>
<script type="text/javascript">

	document.getElementById("borrowBookNumber").value= window.opener.document.getElementById("borrowBookNumber").value;
	document.getElementById("borrowBookName").value= window.opener.document.getElementById("borrowBookName").value;
	document.getElementById("borrowBookColum").value= window.opener.document.getElementById("borrowBookColum").value;
	
</script>

</html>