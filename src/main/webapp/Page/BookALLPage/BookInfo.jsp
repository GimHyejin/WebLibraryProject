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
<link rel="stylesheet" href="../../Css/BookALLCss/BookInfo.css">
</head>
<body>
    <jsp:include page="../MainPage/MenuBar.jsp"></jsp:include>
    <section>
        <div class="section">
            <form action="#" method="post"> 
                <div class="section_title">
                    <p>도서 상세정보</p>
                </div>
            </form>
        </div>
            <div id="section_middle">
                <div id="section_book_img">
                    <img src="${bookInfo.bookImg}">
                </div>
                <div id="section_book_info">
                    <h3>${bookInfo.bookName}</h3>
                    <ul>
                        <li>
                            <p>작가</p>
                            <p>${bookInfo.bookWriter}</p>
                        </li>
                        <li>
                            <p>도서 분류</p>
                            <p>${bookInfo.bookField} > ${bookInfo.bookColum}</p>
                        </li>
                        <li>
                            <p>출판사</p>
                            <p>${bookInfo.bookPublisher}</p>
                        </li>
                        <li>
                            <p>출판일</p>
                            <p>${bookInfo.bookPublishing}</p>
                        </li>
                        <li>
                            <p>추천수</p>
                            <p>0</p>
                        </li>
                        <li>
                        		<input type="text" style="display: none" id="borrowBookNumber" name="bookNumber" value="${bookInfo.bookNumber}">
                        		<input type="text" style="display: none" id="borrowBookName" name="bookName" value="${bookInfo.bookName}">
                        		<input type="text" style="display: none" id="borrowBookColum" name="bookColum" value="${bookInfo.bookColum}">
                        		<button onclick="borrowBookOk(${LoginInfo==null ? 0 : 1})">대출</button>
                        		
                            <button></button>
                            <button onclick="borrowBookOk(1)"></button>
                            <div>
                                <p class="icon_left" >0</p>
                                <p class="icon_right">0</p>
                                <span> </span>
                                <span> </span>
                                <span> </span>
                                <span> </span>
                                <span> </span>
                            </div>
                        </li>
                    </ul>
                </div>
                
            </div>
            
            <br>
            <div class="section_contents">
                <div>
                    <ul id="section_ul">
                        <li><a onclick="menubar(1)">책소개</a></li>
                        <li><a onclick="menubar(2)">작가 소개</a></li>
                        <li onclick="menubar(3)"><a>목차</a></li>
                    </ul>
                </div>
                <div id="section_contents_menu1">
                    <div class="section_bookTitle">
                        <b>책소개</b>
                    </div>
                    <div class="section_bookInfo">
                        <p>
							${bookInfo.infoBook}
                          
                        </p>
                    </div>
                   
                    <div>
                        <div class="section_bookTitle">
                            <form action="" method="get">
                                <b>북리뷰<span>전체 0개의 리뷰가 등록되어 있습니다.</span></b>
                                <button>글 쓰기</button>
                                <button>더 보기</button>
                            </form>
                        </div>
                        <div id="input_review" style="display:none;">
                        	<div class="section_bookInfo_user">
                                		<p><input type="text"><p>
                                		<div><span> </span><span> </span><span> </span><span> </span><span> </span></div>
                            </div>
                            <div class="section_bookInfo_contents">
                                <p><textarea rows="" cols=""></textarea></p>
                            </div>
                        </div>
                        <div class="section_bookReview">
                            <ul>
                                <li>
                        
                                	<div class="section_bookInfo_user">
                                		<p>cookie</p><p>2022-08-12</p>
                                		<div><span> </span><span> </span><span> </span><span> </span><span> </span></div>
                                	</div>
                                	<div class="section_bookInfo_contents">
                                		<p>봄날에 읽기 좋은 시인것 같아요
										</p>
                                	</div>
                                 </li>
                                <li>
                        
                                	<div class="section_bookInfo_user">
                                		<p>cookie</p><p>2022-08-12</p>
                                		<div><span> </span><span> </span><span> </span><span> </span><span> </span></div>
                                	</div>
                                	<div class="section_bookInfo_contents">
                                		<p>마음을 울리는 시인것 같아요</p>
                                	</div>
                                 </li>
                                <!--  
                                <div class="noData3">
                                    <p>등록된 리뷰가 없습니다.</p>
                                </div>
                                -->
                            </ul>
                        </div>
                    </div>
                </div>

                <div id="section_contents_menu2">
                    <div class="section_bookTitle">
                        <b>작가 소개</b>
                    </div>
                    <div class="section_bookInfo">
                        <p>

                            ${bookInfo.infoWriter}
                        </p>
                    </div>
                   
                </div>

                <div id="section_contents_menu3">
                    <div class="section_bookTitle">
                        <b>목차</b>
                    </div>
                    <div class="section_bookInfo">
                        <p>

                            ${bookInfo.infoContents}
                        </p>
                    </div>
                   
                </div>
            </div>
        
    </section>
     <jsp:include page="../MainPage/MainFooter.jsp"></jsp:include>
    
    <script src="../../Js/BookALLJs/BookInfo.js"></script>
</body>
</html>