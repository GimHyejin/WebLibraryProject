package com.Project5.www.BookInfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.BookDAO;
import com.Project5.www.DTO.BookDTO;
import com.Project5.www.FrontController.Command;

public class BookTitle_SearchCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO dao = BookDAO.getMainDAO();
		BookDTO dto =new BookDTO();
		
		String select = request.getParameter("select");
		System.out.println(select);
		String Search_contents = request.getParameter("Search_contents");
		
		dao.BookTitle_SearchOk(select, Search_contents);
		request.setAttribute("bookInfo",dao.BookTitle_SearchOk(select, Search_contents));
	
	}

}
