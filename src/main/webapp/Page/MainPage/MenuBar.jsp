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
<link rel="stylesheet" href="../../Css/MainCss/MenuBar.css">
</head>
<body>
    <header>
        <nav>
            <div>
                <a href="#">서울 도서관</a>
                <p> </p>
                <a href="MainPage.do">HOME</a>
                <c:choose>
                	<c:when test="${LoginInfo eq null}">
		                <a href="MainLogin.do">로그인</a>
		                <a href="LoginJoinCheck.do">회원가입</a>
                	</c:when>
                	<c:when test="${LoginInfo ne null }">
                		<a href="LogOut.do" class="logOut">로그아웃</a>
                		<a href="MemberInfo.do">나의 정보</a>
                	</c:when>
                </c:choose>
            </div>
        </nav>
        <p>  </p>
        <div id="middle_header">
            <p>  </p>
            <form action="unifiedSearch.do" method="get">
                <div>
                    <label for="Integrated_Search">
                            <input type="radio" id="Integrated_Search" value="Intergrated_Search" name="head_search">
                            <p>통합 검색</p>
                        
                    </label>
                    <label for="Book_Search">
                            <input type="radio" id="Book_Search" value="Book_Search" name="head_search">
                            <p>도서 검색</p>
                       
                    </label>
                    <input type="text" name="search" id="search_book_name" />
                    <button type="submit" value="검색" style="background-image:url('../../Img/MainImg/search.gif'); "></button>
                    
                    
                </div>
            </form>
            
        </div>
            <!--메뉴바-->
            <div id="header_menu">
                <ul >
                    <li><a href="#" onclick="myMenu(1,-1)">도서검색</a></li>
                  <!--   <li><a href="#" onclick="myMenu(2,-1)">프로그램</a></li> -->
                    <li><a href="#" onclick="myMenu(3,-1)">열린마당</a></li>
                    <li><a href="#" onclick="myMenu(4,-1)">마이페이지</a></li>
                </ul>
            </div>
            <div class="header_now_menu">
               <ul id="header_literature">
                    <ul><li><div style="background-image: url('../../Img/MainImg/menu01.gif');">
                        <p>도서검색</p>
                    </div></li></ul>
                    <ul class="header_now_menu_font"> 
                        <li  class="header_now_menu_font"><a href="#"  class="header_now_menu_font">문학</a></li>
                        <li><a href="Sub_BookPage.do?title=문학&check=0&colum=시">시</a></li>
                        <li><a href="Sub_BookPage.do?title=문학&check=1&colum=희곡">희곡</a></li>
                        <li><a href="Sub_BookPage.do?title=문학&check=2&colum=소설">소설</a></li>
                        <li><a href="Sub_BookPage.do?title=문학&check=3&colum=수필">수필</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <hr>
                        <li  class="header_now_menu_font"><a href="#"  class="header_now_menu_font">자기개발</a></li>
                        <li><a href="#">성공처세</a></li>
                        <li><a href="#">인생처세</a></li>
                        <li><a href="#">능력개발</a></li>
                        <li><a href="#">힐링</a></li>
                        <li><a href="#">대상별</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">경제/경영</a></li>
                        <li><a href="#">경제</a></li>
                        <li><a href="#">경영</a></li>
                        <li><a href="#">재태크/투자</a></li>
                        <li><a href="#">마케팅/세일즈</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <hr>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">의학/건강</a></li>
                        <li><a href="#">의학</a></li>
                        <li><a href="#">질병치료와예방</a></li>
                        <li><a href="#">건강정보</a></li>
                        <li><a href="#">건강운동</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">여행/지리</a></li>
                        <li><a href="#">국내여행</a></li>
                        <li><a href="#">유럽권여행</a></li>
                        <li><a href="#">아시아권여행</a></li>
                        <li><a href="#">북아프리카권여행</a></li>
                        <li><a href="#">남아프리카권여행</a></li>
                        <li><a href="#"></a></li>
                        <hr>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">예술/다중문학</a></li>
                        <li><a href="#">예술이론/디자인</a></li>
                        <li><a href="#">건축</a></li>
                        <li><a href="#">무용</a></li>
                        <li><a href="#">사진</a></li>
                        <li><a href="#">음악</a></li>
                        <li><a href="#">연극/영화/대중문학</a></li>
                        
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">컴퓨터</a></li>
                        <li><a href="#">프로그래밍언어</a></li>
                        <li><a href="#">웹디자인/홈페이지</a></li>
                        <li><a href="#">모바일프로그래밍</a></li>
                        <li><a href="#">컴퓨터공학</a></li>
                        <li><a href="#">오피스</a></li>
                        <li><a href="#"></a></li>
                        <hr>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">수험서/자격증/취업</a></li>
                        <li><a href="#">공무원수험서</a></li>
                        <li><a href="#">국가고시</a></li>
                        <li><a href="#">기타수험서</a></li>
                        <li><a href="#">창업/취업/은퇴</a></li>
                        <li><a href="#">진학/유학</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">가정/취미/실용</a></li>
                        <li><a href="#">가정</a></li>
                        <li><a href="#">요리</a></li>
                        <li><a href="#">취미/스포츠</a></li>
                        <li><a href="#">역학</a></li>
                        <li><a href="#"></a></li>
                        <li><a href="#"></a></li>
                        <hr>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">어린이/유아</a></li>
                        <li><a href="#">동요/동시</a></li>
                        <li><a href="#">문학/고전</a></li>
                        <li><a href="#">그림책</a></li>
                        <li><a href="#">어린이만화</a></li>
                    </ul>
                </ul>

                <ul id="header_Non_literature">
                
                    <ul><li><div style="background-image: url('../../Img/MainImg/menu01.gif');">
                        <p>비 문학</p>
                    </div></li></ul>
                    <ul class="header_now_menu_font"> 
                        <li  class="header_now_menu_font"><a href="#"  class="header_now_menu_font">추천 도서</a></li>
                        <li><a href="#" >추천 도서</a></li>
                        <li><a href="#" >추천 도서</a></li>
                        <li><a href="#" >추천 도서</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">공포</a></li>
                        <li><a href="#">공포</a></li>
                        <li><a href="#">공포</a></li>
                        <li><a href="#">공포</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">로맨스</a></li>
                        <li><a href="#">로맨스</a></li>
                        <li><a href="#">로맨스</a></li>
                        <li><a href="#">로맨스</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">무협</a></li>
                        <li><a href="#">무협</a></li>
                        <li><a href="#">무협</a></li>
                        <li><a href="#">무협</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">판타지</a></li>
                        <li><a href="#">판타지</a></li>
                        <li><a href="#">판타지</a></li>
                        <li><a href="#">판타지</a></li>
                    </ul>
                </ul>
               
                <ul id="header_program">
                    <ul><li><div style="background-image: url('../../Img/MainImg/menu03.gif');">
                        <p>열린 마당</p>
                    </div></li></ul>
                    <ul class="header_now_menu_font"> 
                    	<!-- 관리자 등록/이용자는 입력 불가-->
                        <li  class="header_now_menu_font"><a href="#"  class="header_now_menu_font">이용안내</a></li>
                        <li><a href="#">도서 검색</a></li>
                        <li><a href="#">마이페이지 이용</a></li>
                        <li><a href="#">프로그램 확인</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">추천도서 확인</a></li>
                        <li><a href="#">공지 사항</a></li>
                        <li><a href="#">자주 하는 질문</a></li>
                        <li><a href="#">이달의 도서</a></li>
                        <li><a href="#">추천도서 확인</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">이용자 커뮤니티</a></li>
                        <li><a href="#">책의 서평</a></li>
                        <li><a href="#">자유 게시판</a></li>
                        <li><a href="#">문의 사항</a></li>
                        <li><a href="#">바라다</a></li>
                    </ul>
                    
                    
                </ul>
                
                <ul id="header_my_page">
                    <ul><li><div style="background-image: url('../../Img/MainImg/menu04.gif');">
                        <p>마이 페이지</p>
                    </div></li></ul>
                    <ul class="header_now_menu_font"> 
                        <li  class="header_now_menu_font"><a href="#"  class="header_now_menu_font">로그인</a></li>
                        <li><a href="#" >회원가입</a></li>
                        <li><a href="#" >아이디 찾기</a></li>
                        <li><a href="#" >비밀번호 찾기</a></li>
                        <li><a href="#" >회원정보 수정</a></li>
                        <li><a href="#" >회원탈퇴</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">나의 글</a></li>
                        <li><a href="#">책의 서평글</a></li>
                        <li><a href="#">자유 게시판글</a></li>
                        <li><a href="#">문의 사항 글</a></li>
                        <li><a href="#">바라다 글</a></li>
                    </ul>
                    <ul>
                        <li class="header_now_menu_font"><a href="#" class="header_now_menu_font">나의 도서관</a></li>
                        <li><a href="#">일반 예약</a></li>
                        <li><a href="#">대출/연체</a></li>
                        <li><a href="#">기존 대출/예약 내역</a></li>
                        <li><a href="#"> </a></li> <!-- 희망 도서/자원봉사등 -->
                    </ul>
                    
                </ul>
            </div>
    </header>
    <script src="../../Js/MainJs/MenuBar.js"></script>
</body>
</html>