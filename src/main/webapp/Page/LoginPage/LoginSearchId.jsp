<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Bruce">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/LoginSearchIdPw.css">
</head>
<body>
    <div id="MainSearch">
        <div><a href="MainPage.do"><img src="../../Img/LoginImg/goMain.gif"></a></div>
        <div><p>서울 도서관</p></div>
        <hr>
        <div><img src="../../Img/LoginImg/findIdBg.gif"><p>아이디 찾기</p></div>
        
        <ul class="radioBox">
            <li><p>아이디를 찾으실 방법을 선택해 주세요</p></li>
        </ul>
       
        <div> 
            <ul>
                <li id="eamil_box_id">
                    <input type="radio" name="check" id="email_check" checked onclick="checkBox(1)" >
                    <label for="email_check">이메일</label>
                </li>
                <li id="check_box_id">
                    <input type="radio" name="check" id="phone_check" onclick="checkBox(2)">
                    <label for="phone_check">연락처</label>
                </li>
            
            </ul>
        </div>
        <br>

        <div id="box_form">
            <form action="LoginSearchIdPhone.do" method="post">
                <ul>
                    <li>전화번호</li>
                    <li>
                        <select name="phone_first" required="required">
                            <option>선택</option>
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
                        <input type="text" name="phone_last" maxlength="8" pattern="[0-9]{8}"  placeholder="전화번호 뒷자리 8자리" title="전화번호 뒷자리를 입력하세요(예 23451321)(-표기 없음)" required="required">
                    </li>
                </ul>
                
                <ul>
                    <li>성명</li>
                    <li class="name_text">
                        <input type="text" name="phone_name" required="required">
                    </li>
                    <hr>
                    <li>생년월일</li>
                    <li>
                        <input type="text" name="phone_birthday" minlength="8" maxlength="8" pattern="[0-9]{8}" placeholder="년월일(20220808)" title="숫자로 8자리를 입력해주세요(예 20001211)" required="required">
                    </li>
                </ul>
                <br>
                <button type="submit">아이디 찾기</button>

            </form>
	        	
	       
        </div>
        <div id="email_box">
            <form action="LoginSearchIdEmail.do" method="post">

                <ul>
                    <li>이메일</li>
                    <li class="text2">
                        <input type="text" name="email" class="email" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder="이메일 형식(예: heee!@naver.com)" title="이메일 형식으로 입력하세요(예: heee!@naver.com)" required="required">
                    </li>
                </ul>
                
                <ul>
                    <li>성명</li>
                    <li class="name_text">
                        <input type="text" name="email_name" required="required">
                    </li>
                    <hr>
                    <li>생년월일</li>
                    <li>
                        <input type="text" name="email_birthday" minlength="8" maxlength="8" pattern="[0-9]{8}" placeholder="년월일(20220808)" title="숫자로 8자리를 입력해주세요(예 20001211)" required="required">
                    </li>
                </ul>
                <br>
                <button type="submit">아이디 찾기</button>
            </form>
        </div>
			<p><c:if test="${errorMsg == 1 }">
		        		<span>현재 가입된 정보가 없습니다.</span>
		    </c:if> </p>
    </div>
    <script src="../../Js/LoginJs/LoginIdPwSearch.js"></script>
</body>
</html>