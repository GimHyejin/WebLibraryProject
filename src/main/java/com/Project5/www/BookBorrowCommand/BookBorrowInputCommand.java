package com.Project5.www.BookBorrowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.BookBorrowDAO;
import com.Project5.www.DTO.BookBorrowDTO;
import com.Project5.www.FrontController.Command;



public class BookBorrowInputCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		
		BookBorrowDTO bdto = new BookBorrowDTO();
		BookBorrowDAO bdao = BookBorrowDAO.getMainDAO();
		
		bdto.setId(id);
		bdto.setBookNumber(bookNumber);
		
		if(!bdao.BookBorrowPersonal(bdto)) { //개인 도서 삽입 !true: 삽입 성공 !false:삽입실패
			request.setAttribute("errorCode3", 1);
		}
		
		
		else if(!bdao.BookBorrowOrganization(bdto)) {
			System.out.println("책의 대출에서 오류 발생:BookBorrowInputCommand");
		}
	}
	
}
