<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="../../Css/WindowBookCss/Input_Book.css">
</head>
<body>
<form action="Input_BookOk.do" method="post" onsubmit="return checkColum()">
    <section>
        <div class="section_div">
                <div class="section_title">
                    <p>도서 등록</p>
                </div>
        </div>
        <input type="text" id="bookImg" name="bookImg" style="display: none" value="">
        <div id="section_middle">
                <div id="input_div">
                    <img src="../../Img/BookImg/noImg2.PNG" id="input_bookImg" name="bookImg" >
                </div>
                <div id="section_book_info">
                    <ul>
                        <li>
                            <p>책 제목</p>
                            <p><input type="text" name="bookName" required></p>
                        </li>
                        <li>
                            <p>작가</p>
                            <p><input type="text" name="bookWriter" required></p>
                        </li>
                        <li>
                            <p>출판사</p>
                            <p><input type="text" name="bookPublisher" required></p>
                        </li>
                        <li>
                            <p>출판일</p>
                            <p><input type="text" name="bookPublishing" required></p>
                        </li>
                        <li style="margin-top:20px ;">
                        	<button type="button" id="input_bookImg_btn" onclick="input_bookImgSrc()">도서 이미지</button>
                        	
                            <input type="submit" value="도서등록">
                        </li>
                        <li>
                        </li>
                    </ul>
                </div>
                
            <div>
            	<select name="bookField" id="bookField_div" onchange="showValue(this)">
        			<option value="분류">분류</option>
        			<option value="문학">문학</option><option value="자기계발">자기계발</option><option value="경제/경영">경제/경영</option><option value="의학/건강">의학/건강</option>
        			<option value="여행/지리">여행/지리</option><option value="예술/다중문학">예술/다중문학</option><option value="컴퓨터">컴퓨터</option><option value="수험서/자격증/취업">수험서/자격증/취업</option>
        			<option value="가정/취미/실용">가정/취미/실용</option><option value="어린이/유아">어린이/유아</option>
    			</select>
   			
    			<div id="boardColum_div">

   				</div>
          </div>
      </div>
            
            <br>
            <div class="section_contents">
                <div>
                    <ul id="section_ul">
                        <li onclick="menubar(1)" id="btn1"  class="checked">책 소개</li>
                        <li onclick="menubar(2)" id="btn2" class="unchecked">작가 소개</li>
                        <li onclick="menubar(3)" id="btn3" class="unchecked">목차</li>
                    </ul>
                </div>
                <div id="section_contents_menu1">
                    <div class="section_bookTitle">
                        <b>책 소개</b>
                    </div>
                    <div class="section_bookInfo">
                        <textarea placeholder="내용을 입력해 주세요." style="resize: none" name="infoBook"></textarea>
                    </div>
                   
                </div>

                <div id="section_contents_menu2">
                    <div class="section_bookTitle">
                        <b>작가 소개</b>
                    </div>
                    <div class="section_bookInfo">
                        <textarea placeholder="내용을 입력해 주세요." style="resize: none" name="infoWrtier" ></textarea>
                    </div>
                   
                </div>

                <div id="section_contents_menu3">
                    <div class="section_bookTitle">
                        <b>목차</b>
                    </div>
                    <div class="section_bookInfo">
                        <textarea placeholder="내용을 입력해 주세요." style="resize: none" name="infoContents"></textarea>
                    </div>
                   
                </div>
            </div>
        
    </section>
</form>   
    <script src="../../Js/WindowJs/Input_Book.js"></script>
</body>
</html>