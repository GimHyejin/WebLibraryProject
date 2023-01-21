package com.Project5.www.BookBorrowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.BookBorrowDAO;
import com.Project5.www.DTO.BookBorrowDTO;
import com.Project5.www.FrontController.Command;


public class BookBorrowOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		
		BookBorrowDTO bdto = new BookBorrowDTO();
		BookBorrowDAO bdao = BookBorrowDAO.getMainDAO();
		
		bdto.setId(id);
		bdto.setBookNumber(bookNumber);
		
		if(bdao.BorrowPersonalCheck(bdto)) {//개인 연체 여부 true: 연체 false: 대출
			//빌릴수 없음
			request.setAttribute("errorCode1", 1);
			
		}else { 
			System.out.println("빌린도서 수 다섯권이상"+bdao.BorrowCount(bdto));
			if(bdao.BorrowCount(bdto)>=5){
				request.setAttribute("errorCode2", 2);
			}
		}
		
		
		
		
	}

}
