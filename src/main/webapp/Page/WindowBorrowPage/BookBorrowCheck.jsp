<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../Css/WindowCss/BookBorrowCss.css">
</head>
<body>
    <div id="bookBorrow_div">
        <table>
            <tr class="borrow_th">
                <th>분류</th><th>책의 이름</th><th>대출여부</th><th>대기수</th><th>대출/예약</th>
            </tr>
            
           	
            <tr class="borrow_td">
                <td>${borrowDto.bookColum} </td> <td class="bookname"> ${borrowDto.bookName} </td>
                <td><c:choose><c:when test="${!borrowDto.bookBorrow}">대출 가능</c:when><c:otherwise>대출 불가능</c:otherwise> </c:choose></td>
                <td> 0 </td>
                <td><c:choose><c:when test="${!borrowDto.bookBorrow}"><a href="BookBorrowOk.do?id=${LoginInfo.id}&bookNumber=${borrowDto.bookNumber}">대출</a></c:when><c:otherwise><a href="#">예약</a></c:otherwise></c:choose></td>
                
            </tr>
        </table>
    </div>
    
</body>
</html>