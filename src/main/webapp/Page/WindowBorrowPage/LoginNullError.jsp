<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/WindowBorrowCss/LoginNullCss.css">
</head>
<body>
	<div id="LoginError">
		<div class="alert_title">
			<div>
				<p>알림</p>
				<div class="alert_img"><img src="../../Img/WindowBorrowImg/popup_close.png"></div> 
				</div>
		</div>
		<div class="text_box2">
			로그인 후 이용이 가능합니다.
		</div>
		<div class="check_btn">
			<button onclick="goMain()">메인 페이지로 이동</button>
		</div>
	</div>
	<script type="text/javascript">
		function goMain(){
			window.opener.document.location.href="../MainPage/MainPage.do";
            self.close();
		}
		
	</script>
</body>
</html>