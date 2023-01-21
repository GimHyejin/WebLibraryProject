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
<link rel="stylesheet" href="../../Css/MainCss/MainPage.css">
</head>
<body onload="rotate()">

<jsp:include page="MenuBar.jsp"></jsp:include>
<section id="section">
        <div style="background-image: url('../../Img/MainImg/banner_bg.jpg');">
            <div class="library_section">
                <ul>
                    <li><img src="../../Img/MainImg/backgound.jpg" id="slide_top"></li>
                </ul>
            </div>
            
         <div>
           		
           	<c:choose>
           		<c:when test="${LoginInfo eq null}">
                <div>
                    <form action="LoginOk.do"  method="get">
                        <fieldset>
                            <legend>로그인</legend>
                            <input type="checkbox" id="saveIdBtn">
                            <label for="saveIdBtn">아이디 저장</label><br>
                            <input type="text" name="id" maxlength="20" placeholder="아이디" required="required">
                            <input type="submit" value="" id="logOut" style="background-image: url('../../Img/MainImg/lookLogin.jpg');">
                            <input type="password" name="pw" maxlength="20"  placeholder="비밀번호" required="required"><br>
                            <div>
                                <a href="LoginSearchId.do">아이디 찾기</a>
                                <a href="LoginSearchPw.do">비밀번호 찾기</a>
                                <a href="LoginJoinCheck.do">회원가입</a>
                            </div>
                            <div>
                            </div>
                        </fieldset>
                    </form>
                </div>
           		</c:when>
           		<c:when test="${LoginInfo ne null }">
                <div>
                    <form action="LogOut.do" method="get">
                        <fieldset>
                            <legend>방문을 환영합니다.</legend>
                            <input type="submit" value="로그아웃" id="logIn">
                            <p>${LoginInfo.id}  님 </p><br>
                            <p>이메일주소 </p>
                            <input type="text" style="display: none" id="myId" value="${LoginInfo.id}">

                            <div>
                                <a href="MainChangePw.do?id=${LoginInfo.id}">비밀번호 변경</a>
                                <a href="MemberInfo.do">나의 정보</a>
                                <a href="MemberModify.do">회원 정보 수정</a>
                            </div>
                            <div>
                                <a href="#" onclick="bookBorrowInfo()">대출/연체</a>
                                <a href="#">좋아요 도서</a>
                                <a href="#">나의 추천도서</a>
                            </div>
                        </fieldset>
                    </form>
                </div>
           		</c:when>
           	</c:choose>
          </div>
        </div>
        
        <article id="announcements">
            <div class="announcements_left">

                <p>공지 사항</p>
                <hr>
                
                <div>
                    <table>
                        <tr>
                            <th>분류</th>
                            <th id="announcements_id">제목</th>
                            <th>작성일</th>
                        </tr>
                       
                        <tr>
                            <td>1</td>
                            <td>새로운 html 페이지 가 완성되었습니다.</td>
                            <td> 2022-07-11</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>새로운 html 페이지 가 완성되었습니다.</td>
                            <td> 2022-07-11</td>
                        
                    </table>
                </div>
            </div>
            
            <div class="announcements_right">

                <p>문의 사항</p>
                <hr>
                
                <div>
                    <table>
                        <tr>
                            <th>분류</th>
                            <th id="announcements_id">제목</th>
                            <th>작성일</th>
                        </tr>
                       
                        <tr>
                            <td>1</td>
                            <td>새로운 html 페이지 가 완성되었습니다.</td>
                            <td> 2022-07-11</td>
                        </tr>
                        
                        <tr>
                            <td>1</td>
                            <td>새로운 html 페이지 가 완성되었습니다.</td>
                            <td> 2022-07-11</td>
                        </tr>
                    </table>
                </div>
            </div>
        </article>
        <br>
            <article class="bookOfMonth_article">
                <p>신규 도서</p>
                <hr>
                <div class="slidebox">
                    <input type="radio" name="slide" id="slide01" checked>
                    <input type="radio" name="slide" id="slide02">
                    <input type="radio" name="slide" id="slide03">
                    <ul class="slidelist">
                        <li class="slideitem">
                            <a>
                                <label for="slide03" class="prev" style="background-image: url('../../Img/MainImg/Arrow_Left.png');"></label>
                                <img src="../../Img/MainImg/Book1_1.jpg">
                                <img src="../../Img/MainImg/Book1_2.jpg">
                                <img src="../../Img/MainImg/Book1_3.jpg">
                                <img src="../../Img/MainImg/Book1_3.jpg">
                                <img src="../../Img/MainImg/Book1_3.jpg">
                                <label for="slide02" class="next" style="background-image: url('../../Img/MainImg/Arrow_Right.png');"></label>
                            </a>
                        </li>
                        <li class="slideitem">
                            <a>
                                <label for="slide01" class="prev" style="background-image: url('../../Img/MainImg/Arrow_Left.png');"></label>
                                <img src="../../Img/MainImg/Book2_1.jpg">
                                <img src="../../Img/MainImg/Book2_2.jpg">
                                <img src="../../Img/MainImg/Book2_3.jpg">
                                <img src="../../Img/MainImg/Book2_3.jpg">
                                <img src="../../Img/MainImg/Book2_3.jpg">
                                <label for="slide03" class="next" style="background-image: url('../../Img/MainImg/Arrow_Right.png');"></label>
                            </a>
                        </li>
                        <li class="slideitem">
                            <a>
                                <label for="slide02" class="prev" style="background-image: url('../../Img/MainImg/Arrow_Left.png');"></label>
                                <img src="../../Img/MainImg/Book3_1.jpg">
                                <img src="../../Img/MainImg/Book3_2.jpg">
                                <img src="../../Img/MainImg/Book3_3.jpg">
                                <img src="../../Img/MainImg/Book3_3.jpg">
                                <img src="../../Img/MainImg/Book3_3.jpg">
                                <label for="slide01" class="next" style="background-image: url('../../Img/MainImg/Arrow_Right.png');"></label>
                            </a>
                        </li>
                    </ul>
                </div>
            </article>
    </section>
    <jsp:include page="MainFooter.jsp"></jsp:include>
	<script src="../../Js/MainJs/MainPage.js"></script>
</body>
</html>