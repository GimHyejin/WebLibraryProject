package com.Project5.www.BookInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.BookDAO;
import com.Project5.www.DTO.BookDTO;
import com.Project5.www.FrontController.Command;

public class BookNumber_SearchOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDTO dto = new BookDTO();
		BookDAO dao = BookDAO.getMainDAO();
		
		int bookNumber = Integer.parseInt(request.getParameter("bookNumber"));
		dto.setBookNumber(bookNumber);
		request.setAttribute("bookInfo",dao.BookNumber_SearchOk(dto));
			
	}

}
