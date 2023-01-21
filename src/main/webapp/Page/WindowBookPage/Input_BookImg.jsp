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

<form action="Input_BookImgOk.jsp" method="post" enctype="multipart/form-data">
	 	<fieldset>
			<legend>도서 이미지 업로드</legend>
			
			<!-- 파일 미리보기 필요 -->
			<img src="${bookimgsrc}" style="display:none" id="input_bookImg" value="${bookimgsrc}" style="width:200px;height: 300px;">
<!--  --	<p>작성자 : <input type="text" name="userName"></p>  -->
			
			<p>파일명 : <input type="file" name="file"></p>
			<p><input type="submit" value="upload"></p>	 	
	 	</fieldset>
	 </form>
</body>
</html>