<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/LoginCss/JoinBoxInput.css">
</head>
<body>
    <div id="inputBox">
        <div></div>
        <div><p>회원가입</p></div>
        <hr>
        
        <div id="email_box">
            <form action="BoxInputOk.do" method="post">
                <ul>
                    <li>아이디 (<span>*</span>)</li>
                    <li class="name_text">
                        <input type="text" id="id" name="id" value=" " minlength="5" maxlength="10" size="12"  pattern="^(?=.*[a-zA-Z])[a-zA-Z0-9]{5,10}" placeholder="5~10자(영문 대소문자, 숫자)" title="5~10자의 영문 대소문자와 숫자로만 입력하세요." readonly="readonly" required="required">
                        <button type="button" onclick="Exid()">아이디 중복확인</button>
                    </li>
                    <hr>
                    <li>비밀번호 (<span>*</span>)</li>
                    <li>
                        <input type="password" id="pw" name="pw" value="" minlength="10" maxlength="15" size="18" pattern="^(?=.*[A-Za-z])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,15}$"  placeholder="10~15자(영문 대소문자와 숫자로만 입력(영문 대소문자,특수문자 1개이상 포함))" title="10~15자의 영문 대소문자와 특수 문자 포함해야 합니다)." onkeyup="check_pw()" required="required">
                    </li>

                    <hr>
                    <li class="pw_class"  style="width: auto;">비밀번호 확인(<span>*</span>)</li>
                    <li >
                        <input type="password" id="pw2" name="pw2" value="" class="pw_class2" minlength="10" maxlength="15" size="18"  pattern="^(?=.*[A-Za-z])(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{10,15}$" onkeyup="check_pw()" required="required">
                    	<p id="pw_check_msg"> </p>
                    </li>
                </ul>
                
                <ul>
                    <li>성명</li>
                    <li class="name_text">
                        <input type="text" name="name" required="required">
                    </li>
                    <hr>
                    <li>생년월일</li>
                    <li>
                        <input type="text" name="birthday" minlength="8" maxlength="8" pattern="[0-9]{8}" placeholder="년월일(20220808)" title="숫자로 8자리를 입력해주세요(예 20001211)"  required="required">
                    </li>
                    <hr>
                    <li>전화번호</li>
                    <li>
                        <input type="text" name="phone_last" class="margin_li" maxlength="8" pattern="[0-9]{8}"  placeholder="전화번호 뒷자리 8자리" title="전화번호 뒷자리를 입력하세요(예 23451321)(-표기 없음)" required="required">
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
                    </li>
                </ul>
                
                <ul>
                    <li>이메일</li>
                    <li class="text2">
                        <input type="text" name="email" class="email_input" pattern="[A-Za-z0-9_]+[A-Za-z0-9]*[@]{1}[A-Za-z0-9]+[A-Za-z0-9]*[.]{1}[A-Za-z]{1,3}" placeholder="이메일 형식(예: heee!@naver.com)" title="이메일 형식으로 입력하세요(예: heee!@naver.com)" required="required">
                    </li>
                    <hr>
                    <li>주민등록 번호</li>
                    <li class="text2">
                        <input type="text" name="resident_first" minlength="6" maxlength="6" pattern="[0-9]{6}" placeholder="주민번호 앞자리를 입력하세요" title="주민번호 앞자리를입력하세요(6글자 예:001024)" required="required">-<input type="text" name="resident_last" minlength="7" maxlength="7" pattern="[0-9]{7}" placeholder="주민번호 뒷자리를 입력하세요" title="주민번호 뒷자리를입력하세요(7글자 예:3101024)" required="required">
                    </li>
                </ul>

                <ul id="adress">
                    <li>기본주소</li>
                    <li>
                    <input type="text" id="sample4_postcode" placeholder="우편번호" name="postcode"  readonly>
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br />
					<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="roadAddress" >
					<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="jibunAddress" >
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="detailAddress">
					<input type="text" id="sample4_extraAddress" placeholder="참고항목" name="extraAddress" ><br/>
                    </li>
                </ul>

                <br>
                <button type="submit">가입완료</button>
            </form>
        

        </div>
        
    </div> 
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src= "../../Js/LoginJs/JoinBoxInput.js"></script>
</body>
</html>