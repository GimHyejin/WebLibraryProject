<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%	
	// request.getSession().getServletContext().getRealPath("/");
	//String path = application.getRealPath("windowSub_BookImg");
	String path = application.getRealPath("Img\\BookImg");
	System.out.println(path);
	//String path = "C:\\work\\web\\FileUploadTest2\\src\\main\\webapp\\image"; 

	int size = 1024 * 1024 * 10; //10M - 최대 사이즈
	String file = "";
	String oriFile = "";
	
	try{
		MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		System.out.println("이름 " + name);
		
		Enumeration<String> files = multi.getFileNames();		// 폼 요소 중 input 태그 속성이 file로 된 파라미터의 이름들을 반환
														// upload 된 파일이 없으면 비어있는 Enumeration을 반환
		while(files.hasMoreElements())
		{
			String str = files.nextElement();
			file = multi.getFilesystemName(str);			// 사용자가 지정해서 서버에 실제로 업로드된 파일명 반환
															// 파일명이 중복되는 경우 변경된 파일명 반환
			oriFile = multi.getOriginalFileName(str);		// 사용자가 업로드한 실제 파일명을 반환.
															// 이때의 파일명은 파일 중복을 고려한 파일명 변경 전의 이름을 말한다.
			System.out.println("저장된 경로 " + path + " 저장된 이름 " + file + " 원본이름 " + oriFile);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
<%
		String bookImgSrc = "../../Img/BookImg/"+file; 
		System.out.println(bookImgSrc);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input  type="hidden" id="hiddenBookImg" value="<%=bookImgSrc%>">
	<script type="text/javascript">
		window.opener.document.getElementById("bookImg").value = document.getElementById("hiddenBookImg").value;
		window.opener.document.getElementById("input_bookImg").src = document.getElementById("hiddenBookImg").value;
		self.close();
	</script>
</body>
</html>