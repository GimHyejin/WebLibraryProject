<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginChangePw.css">
</head>
<body>
    <div id="MainSearch">
        <div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울도서관</p></div>
        <hr>
        <div><img src="../../Img/LoginImg/findIdBg.gif"><p>비밀번호 변경</p></div>
        
        
        <div></div>
        <div id="email_box">
            <form action="LoginChangePw.do" method="post"  onsubmit="check_pw()">
            	<input type="text" name="id" value="${id}" style="display: none" readonly="readonly">
                <ul>
                    <li>비밀번호</li>
                    <li class="name_text">
                        <input type="password" name="checkPw" id="pw" value="" minlength="10" maxlength="15" size="18" pattern="^(?=.*[A-Za-z])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,15}$"  placeholder="10~15자(영문 대소문자와 숫자로만 입력(영문 대소문자,특수문자 1개이상 포함))" title="10~15자의 영문 대소문자와 특수 문자 포함해야 합니다)." required="required">
                    </li>
                    <hr>
                    <li>비밀번호 확인</li>
                    <li class="name_text">
                   	 	<input type="password" name="checkPw2" id="pw2" value="" minlength="10" maxlength="15" size="18" pattern="^(?=.*[A-Za-z])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,15}$"  placeholder="10~15자(영문 대소문자와 숫자로만 입력(영문 대소문자,특수문자 1개이상 포함))" title="10~15자의 영문 대소문자와 특수 문자 포함해야 합니다)." required="required">
                    </li>
                    
                </ul>
                <br>
                <button type="submit">비밀번호 변경</button>
            </form>
        </div>

    </div>
    <script src="../../Js/LoginJs/LoginChangePwOk.js"></script>
    <script type="text/javascript"></script>
</body>
</html>