package com.Project5.www.BookBorrowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.BookBorrowDAO;
import com.Project5.www.DTO.BookBorrowDTO;
import com.Project5.www.FrontController.Command;

public class BookReturnCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		String id = request.getParameter("id");
		
		BookBorrowDTO dto = new BookBorrowDTO();
		dto.setBookNumber(bookNumber);
		dto.setId(id);
		
		BookBorrowDAO dao = BookBorrowDAO.getMainDAO();
		
		if(dao.bookReturn(dto)) {
			dao.bookOriReturn(dto);
		}
		
	
	}

}
