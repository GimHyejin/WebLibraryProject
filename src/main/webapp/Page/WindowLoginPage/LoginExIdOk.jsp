<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!-- 기존아이가 없다. -->
	<div>
		<input type="text" id="id" name="id" value="${id}" readonly="readonly"> 
		<p>아이디 사용가능</p>
		
		<a href="#" onclick="idOk()">아이디 사용</a> <a href="LoginExId.jsp">아이디 변경</a>
	</div>
	<script type="text/javascript">
		function idOk(){
			
			window.opener.document.getElementById("id").value = document.getElementById("id").value;
			 self.close();
		}
	</script>
</body>
</html>