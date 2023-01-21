<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/JoinBoxInput.css">
</head>
<body>
	<div id="inputBox">
        <div></div>
        <div><p>회원정보 수정</p></div>
        <hr>
        
        <div id="email_box">
            <form action="MemberModifyOk.do" method="post">
                <ul>
                    <li>아이디 (<span>*</span>)</li>
                    <li class="name_text">
                        <input type="text" id="id" name="id" value="${LoginInfo.id}" minlength="5" maxlength="10" size="12"  pattern="^(?=.*[a-zA-Z])[a-zA-Z0-9]{5,10}" placeholder="5~10자(영문 대소문자, 숫자)" title="5~10자의 영문 대소문자와 숫자로만 입력하세요." readonly="readonly" required="required">
                        <button type="button" onclick="Exid()">아이디 중복확인</button>
                    </li>
                </ul>
                
                <ul>
                    <li>성명</li>
                    <li class="name_text">
                    	<input type="text" style="display: none;" name="id2" value="${LoginInfo.id}">
                        <input type="text" name="name" value="${LoginInfo.name}" required="required">
                    </li>
                    <hr>
                    <li>생년월일</li>
                    <li>
                        <input type="text" name="birthday" value="${LoginInfo.birthday}" minlength="8" maxlength="8" pattern="[0-9]{8}" placeholder="년월일(20220808)" title="숫자로 8자리를 입력해주세요(예 20001211)"  required="required">
                    </li>
                    <hr>
                    <li>전화번호</li>
                    <li>
                        <input type="text" name="phone_last" value="${LoginInfo.phone_last}" class="margin_li" maxlength="8" pattern="[0-9]{8}"  placeholder="전화번호 뒷자리 8자리" title="전화번호 뒷자리를 입력하세요(예 23451321)(-표기 없음)" required="required">
                        <select name="phone_first"  required="required">
                            <option>010</option>
                            <option>011</option>
                            <option>016</option>
                            <option>017</option>
                            <option>018</option>
                            <option>019</option>
                            <option>02</option>
                            <option>032</option>
                            <option>033</option>
                            <option>041</option>
                            <option>043</option>
                            <option>051</option>
                            <option>052</option>
                            <option>053</option> 
                            <option>054</option>
                            <option>055</option>
                            <option>061</option>
                            <option>063</option>
                            <option>064</option>
                            <option>070</option>
                        </select>
                    </li>
                </ul>
                
                <ul>
                    <li>이메일</li>
                    <li class="text2">
                        <input type="text" name="email" value="${LoginInfo.email}" class="email_input" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder="이메일 형식(예: heee!@naver.com)" title="이메일 형식으로 입력하세요(예: heee!@naver.com)" required="required">
                    </li>
                    <hr>
                    <li>주민등록 번호</li>
                    <li class="text2">
                        <input type="text" name="resident_first" value="${LoginInfo.resident_first}" minlength="6" maxlength="6" pattern="[0-9]{6}" placeholder="주민번호 앞자리를 입력하세요" title="주민번호 앞자리를입력하세요(6글자 예:001024)" required="required">-<input type="text" name="resident_last" value="${LoginInfo.resident_last}" minlength="7" maxlength="7" pattern="[0-9]{7}" placeholder="주민번호 뒷자리를 입력하세요" title="주민번호 뒷자리를입력하세요(7글자 예:3101024)" required="required">
                    </li>
                    
                    
                    
                </ul>

                <ul id="adress">
                    <li>기본주소</li>
                    <li>
                    <input type="text" id="sample4_postcode" value="${LoginInfo.postCode}" placeholder="우편번호" name="postcode"  readonly>
					<input type="button" onclick="sample4_execDaumPostcode()"  value="우편번호 찾기"><br />
					<input type="text" id="sample4_roadAddress" value="${LoginInfo.roadAddress}" placeholder="도로명주소" name="roadAddress" >
					<input type="text" id="sample4_jibunAddress" value="${LoginInfo.jibunAddress}" placeholder="지번주소" name="jibunAddress" >
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" placeholder="상세주소"  value="${LoginInfo.detailAddress}"name="detailAddress">
					<input type="text" id="sample4_extraAddress" placeholder="참고항목" value="${LoginInfo.extraAddress}" name="extraAddress" ><br/>
                    </li>
                </ul>

                <br>
                <button type="submit">회원정보 수정완료</button>
            </form>
        

        </div>
        
    </div> 
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src= "../../Js/LoginJs/JoinBoxInput.js"></script>
</body>
</html>