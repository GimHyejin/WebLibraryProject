<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginMemberInfo.css">
</head>
<body>
	<div id="inputBox">
		<div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div>
        	<img src="../../Img/LoginImg/findIdBg.gif"><p>회원정보</p></div>
        
            <ul style="margin-top: 5px;">
                <li>아이디</li>
                <li>
                    <input type="text" name="id" value="${LoginInfo.id}" placeholder="아이디" readonly>
                </li>
                <hr>
                <li>이름</li>
                <li class="name_text">
                   <input type="text" name="name" value="${LoginInfo.name}" placeholder="이름" readonly="readonly">
                </li>
                <hr>
                <li>생일</li>
                <li>
                     <input type="text" name="birthday" value="${LoginInfo.birthday}" placeholder="생일" readonly="readonly">
                </li>
            </ul>
            
            <ul>
                <li>전화번호</li>
                <li>
                    <input type="text" name="phone" placeholder="전화번호" value="${LoginInfo.phone_first}-${LoginInfo.phone_last}"  readonly="readonly">
                </li>
                <hr>
                <li>이메일</li>
                 <li class="text2">
                     <input type="text" name="eamail"  class="email_input" placeholder="이메일" value="${LoginInfo.email}"  readonly="readonly">
                 </li>
            </ul>

                <ul id="adress">
                    <li>우편번호</li>
                    <li>
                        <input type="text" id="sample4_postcode" placeholder="우편번호" value="${LoginInfo.postCode}" name="postcode"  readonly="readonly">
                    </li>
                    <hr>
                    <li>도로명 주소</li>
                    <li>
                        <input type="text" id="sample4_roadAddress"  placeholder="도로명주소" value="${LoginInfo.roadAddress}"  name="roadAddress"  readonly="readonly">
                    </li>
                    <hr>
                    <li>지번 주소</li>
                    <li>
                        <input type="text" id="sample4_jibunAddress" placeholder="지번주소" value="${LoginInfo.jibunAddress}" name="jibunAddress"  readonly="readonly">
                    </li>
                    <hr>
                    <li>상세 주소</li>
                    <li>
                        <input type="text" id="sample4_detailAddress" placeholder="상세주소" value="${LoginInfo.detailAddress}" name="detailAddress"  readonly="readonly">
                    </li>
                    <hr>
                    <li>참고 항목</li>
                    <li>
                        <input type="text" id="sample4_extraAddress" placeholder="참고항목" value="${LoginInfo.extraAddress}"  name="extraAddress"  readonly="readonly"><br/>
                    </li>
                        
                </ul>
                <br>
        </div>
        
    </div> 
    
</body>
</html>