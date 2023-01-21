<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/BookALLCss/BookAll_Search.css">
</head>
<body>
	<jsp:include page="../MainPage/MenuBar.jsp"></jsp:include>
    <section>
        
    <div id="subject_section"><!--헤드 포함 전체 메뉴바-->
            <div class="section_title_top">
                <h4>전체 도서</h4>
            </div>
    <form action="BookAll_SearchOk.do" method="post">
        <div><!--전체 메뉴의 시작-->
            <div class="subject_check">
                <dl>
                    <dt>
                        <a> </a>
                        <a>총류</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="literature" value="문학" onclick="literatureMenu(this)"><a>문학</a></li>
                            <li><input type="checkbox" name="economy" value="경제/경영" onclick="economyMenu(this)"><a>경제/경영</a></li>
                            <li><input type="checkbox" name="journey" value="여행/지리" onclick="journeyMenu(this)"><a>여행/지리</a></li>
                            <li><input type="checkbox" name="computer" value="컴퓨터" onclick="computerMenu(this)"><a>컴퓨터</a></li>
                            <li><input type="checkbox" name="hobby" value="가정/취미/실용" onclick="hobbyMenu(this)"><a>가정/취미/실용</a></li>
                            <li><input type="checkbox" name="development" value="자기계발" onclick="developmentMenu(this)"><a>자기계발</a></li>
                            <li><input type="checkbox" name="medicine" value="의학/건강" onclick="dmedicineMenu(this)"><a>의학/건강</a></li>
                            <li><input type="checkbox" name="art" value="예술/다중문학" onclick="artMenu(this)"><a>예술/다중문학</a></li>
                            <li><input type="checkbox" name="employment" value="수험/자격증/취업" onclick="employmentMenu(this)"><a>수험/자격증/취업</a></li>
                            <li><input type="checkbox" name="child" value="어린이/유아" onclick="childMenu(this)" ><a>어린이/유아</a> <a class="plus" onclick="showBox(-1)"></a></li>
                        </ul>
                    </dd>
                </dl>
                <div id="showSubject" style="display: none;">
                <dl>
                    <dt>
                        <a>문학</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="literature_sub" value="시"><a>시</a></li>
                            <li><input type="checkbox" name="literature_sub" value="소설"><a>소설</a></li>
                            <li><input type="checkbox" name="literature_sub" value="수필"><a>수필</a></li>
                            <li><input type="checkbox" name="literature_sub" value="희곡"><a>희곡</a></li>
                        </ul>
                    </dd>
                </dl>
                
                <dl>
                    <dt>
                        <a>경제/경영</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="economy_sub" value="경제"><a>경제</a></li>
                            <li><input type="checkbox" name="economy_sub" value="경양"><a>경영</a></li>
                            <li><input type="checkbox" name="economy_sub" value="재태크/투자"><a>재태크/투자</a></li>
                            <li><input type="checkbox" name="economy_sub" value="마케팅/세일즈"><a>마케팅 세일즈</a></li>
                        </ul>
                    </dd>
                </dl>
                
                <dl>
                    <dt>
                        <a>여행/지리</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="journey_sub" value="국내여행"><a>국내 여행</a></li>
                            <li><input type="checkbox" name="journey_sub" value="유럽권여행"><a>유럽권 여행</a></li>
                            <li><input type="checkbox" name="journey_sub" value="아시아권여행"><a>아시아권 여행</a></li>
                            <li><input type="checkbox" name="journey_sub" value="북아프리카여행"><a>북아프리카 여행</a></li>
                            <li><input type="checkbox" name="journey_sub" value="남아프리카여행"><a>남아프리카 여행</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl >
                    <dt>
                        <a>컴퓨터</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="computer_sub" value="프로그래밍언어"><a>프로그래맹 언어</a></li>
                            <li><input type="checkbox" name="computer_sub" value="웹디자인/홈페이지"><a>웹 디자인/홈페이지</a></li>
                            <li><input type="checkbox" name="computer_sub" value="모바일프로그램"><a>모바일 프로그램</a></li>
                            <li><input type="checkbox" name="computer_sub" value="컴퓨터공학"><a>컴퓨터 공학</a></li>
                            <li><input type="checkbox" name="computer_sub" value="오피스"><a>오피스</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl >
                    <dt>
                        <a>가정/취미/실용</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="hobby_sub" value="가정"><a>가정</a></li>
                            <li><input type="checkbox" name="hobby_sub" value="요리"><a>요리</a></li>
                            <li><input type="checkbox" name="hobby_sub" value="취미/스포츠"><a>취미/스포츠</a></li>
                            <li><input type="checkbox" name="hobby_sub" value="역학"><a>역학</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl  >
                    <dt>
                       <a>자기 개발</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="development_sub" value="성공처세"><a>성공처세</a></li>
                            <li><input type="checkbox" name="development_sub" value="인생처세"><a>인생 처세</a></li>
                            <li><input type="checkbox" name="development_sub" value="능력개발"><a>능력 개발</a></li>
                            <li><input type="checkbox" name="development_sub" value="힐링"><a>힐링</a></li>
                            <li><input type="checkbox" name="development_sub" value="대상별"><a>대상별</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl >
                    <dt>
                        <a>의학/건강</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="medicine_sub" value="의학"><a>의학</a></li>
                            <li><input type="checkbox" name="medicine_sub" value="질병치료와예방"><a>질병치료와 예방</a></li>
                            <li><input type="checkbox" name="medicine_sub" value="건강정보"><a>건강 정보</a></li>
                            <li><input type="checkbox" name="medicine_sub" value="건강운동"><a>건강 운동</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl >
                    <dt>
                        <a>예술/다중문학</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="art_sub" value="예술이론/디자인"><a>예술이론/디자인</a></li>
                            <li><input type="checkbox" name="art_sub" value="건축"><a>건축</a></li>
                            <li><input type="checkbox" name="art_sub" value="무용"><a>무용</a></li>
                            <li><input type="checkbox" name="art_sub" value="사진"><a>사진</a></li>
                            <li><input type="checkbox" name="art_sub" value="음악"><a>음악</a></li>
                            <li><input type="checkbox" name="art_sub" value="연극/영화/대중문학"><a>연극/영화/대중문학</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl >
                    <dt>
                        <a>수험서/자격증/취업</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="employment_sub" value="공무원수험서"><a>공무원 수험서</a></li>
                            <li><input type="checkbox" name="employment_sub" value="국가고시"><a>국가 고시</a></li>
                            <li><input type="checkbox" name="employment_sub" value="기타수험서"><a>기타 수험서</a></li>
                            <li><input type="checkbox" name="employment_sub" value="창업/취업/은퇴"><a>창업/취업/은퇴</a></li>
                            <li><input type="checkbox" name="employment_sub" value="진학/유학"><a>진학/유학</a></li>
                        </ul>
                    </dd>
                </dl>
                <dl>
                    <dt>
                        <a>어린이/유아</a>
                    </dt>
                    <dd>
                        <ul>
                            <li><input type="checkbox" name="child_sub" value="동요/동시"><a>동요/동시</a></li>
                            <li><input type="checkbox" name="child_sub" value="문학/고전"><a>문학/고전</a></li>
                            <li><input type="checkbox" name="child_sub" value="그림책"><a>그림책</a></li>
                            <li><input type="checkbox" name="child_sub" value="어린이만화"><a>어린이 만화</a></li>
                        </ul>
                    </dd>
                </dl>
                
               
            </div> <!--서브 메뉴바 -->
            <input type="submit" class="check_submit" value="검색">
        </div><!-- 전체 메뉴바-->

    </form>
    
    <a href="#" onclick="input_book()"   id="input_book" class="check_submit">도서 등록</a> 
    <form action="BookTitle_SearchOk.do" method="post">
        <div class="Search_middle">
            <ul>
                <li>
                    <span class="Search_select">
                        <select name="select">
                            <option value="bookName">제목</option>
                            <option value="bookWriter">저자</option>
                            <option value="bookPublisher">출판사</option>
                        </select>
                    </span>
                </li>
                <li>
                    <span class="reSearch">
                        <input type="text" name="Search_contents" placeholder="검색내 검색" required>
                        
                        <input type="submit">
                    </span>
                </li>
            </ul>
        </div><!-- 검색어 메뉴바-->
    </form>
    </div>

    <div id="book_img">
        <ul>
			<c:forEach var="bookInfo" items="${bookInfo}">
            <li><!--li에서 반복-->
                <div>
                    <a class="bookInfo_a" href="BooksInfo.do?bookNumber=${bookInfo.bookNumber}">
                        <img src="${bookInfo.bookImg}" class="bookInfo_img">
                        <div class="bookInfo_text">
                            <p>
                                ${bookInfo.infoBook}
                            </p>
                        </div>
                    </a>
                </div>
                <div class="btn_bookInfo">
                    <div>
						<input type="text" style="display: none" id="borrowBookNumber" name="bookNumber" value="${bookInfo.bookNumber}">
		                <input type="text" style="display: none" id="borrowBookName" name="bookName" value="${bookInfo.bookName}">
		                <input type="text" style="display: none" id="borrowBookColum" name="bookColum" value="${bookInfo.bookColum}">
                        <button class="btn_buy" onclick="borrowBookOk(${LoginInfo==null ? 0 : 1})">대출</button>
                        <button class="btn_choice">추천</button>
                        <button class="btn_sub">
                            <span id="book_info">
                                <span>대출 현황<span>0</span></span>
                                <span>추천 현황<span> 0 </span></span>
                            </span>
                        </button>
                    </div>
                </div>
                <p id="bookTitle">${bookInfo.bookName}</p>
            </li>
			</c:forEach>
        </ul>
        <br>
        <div class="flooter_div">
            <div>
                <button id="goFirst" class="pgBtn prev goFirst"> << </button>
                <button id="first" class="pgBtn prev goFirst"> < </button>
                
                    <a class="pg on">1</a>
                    <a class="pg on">2</a>
                    <a class="pg on">3</a>
                    <a class="pg on">4</a>
                    <a class="pg on">5</a>
                <button id="goFirst" class="pgBtn prev goFirst"> > </button>
                <button id="goLast" class="pgBtn prev goFirst"> >> </button>

            </div>
        </div>
    </div>   
    </section>
    <jsp:include page="../MainPage/MainFooter.jsp"></jsp:include>
    <script src="../../Js/BookALLJs/BookAll_Search.js"></script>
</body>
</html>