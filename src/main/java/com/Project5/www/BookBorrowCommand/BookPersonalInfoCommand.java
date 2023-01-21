package com.Project5.www.BookBorrowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.BookBorrowDAO;
import com.Project5.www.FrontController.Command;

public class BookPersonalInfoCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =  request.getParameter("id");
		System.out.println("아이디:"+id);
		
		BookBorrowDAO bdao = BookBorrowDAO.getMainDAO();
		request.setAttribute("personalBook", bdao.BooksPersonal(id));
		
		request.setAttribute("personalBookHistory", bdao.BooksPersonalHistory(id));
	
	}

}
