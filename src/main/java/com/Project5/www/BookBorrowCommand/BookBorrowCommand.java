package com.Project5.www.BookBorrowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.BookBorrowDAO;
import com.Project5.www.DTO.BookBorrowDTO;
import com.Project5.www.FrontController.Command;

public class BookBorrowCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookBorrowDTO borrowDto = new BookBorrowDTO();
		BookBorrowDAO borrowDao = BookBorrowDAO.getMainDAO();
		
		String id = request.getParameter("id");
		String bookName = request.getParameter("bookName");
		String bookColum = request.getParameter("bookColum");
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		
		
		borrowDto.setId(id);
		borrowDto.setBookName(bookName);
		borrowDto.setBookColum(bookColum);
		borrowDto.setBookNumber(bookNumber);
		
		if(borrowDao.bookBorrow(borrowDto)) { //도서테이블의 값이 존재한다.
			if(borrowDao.bookBorrowPersonalInfo(borrowDto)) { //자신이 도서를 빌렸다. 
				request.setAttribute("errorMyBook",1);
				//request.setAttribute("borrow_id",id);
			}else {
				request.setAttribute("borrowDto",borrowDto);
				//request.setAttribute("borrow_id",id);
			}
		}else { 
			//도서 테이블의 값이 존재하지 않는다.
			borrowDao.bookBorrowInput(borrowDto);
			borrowDao.bookBorrowInput2(borrowDto);
			request.setAttribute("borrowDto",borrowDto);
		}
	
	}

}
