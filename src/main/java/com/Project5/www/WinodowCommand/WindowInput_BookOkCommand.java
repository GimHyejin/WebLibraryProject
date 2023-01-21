package com.Project5.www.WinodowCommand;

import java.awt.print.Book;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.BookDAO;
import com.Project5.www.DTO.BookDTO;
import com.Project5.www.FrontController.Command;


public class WindowInput_BookOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookImg = request.getParameter("bookImg");
		
		String bookName = request.getParameter("bookName");
		String bookWriter = request.getParameter("bookWriter");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookPublishing = request.getParameter("bookPublishing");
		
		String bookColum = request.getParameter("bookColum");
		String bookField = request.getParameter("bookField");
		
		
		String infoBook = request.getParameter("infoBook");
		String infoWrtier = request.getParameter("infoWrtier");
		String infoContents = request.getParameter("infoContents");
		
		BookDTO dto = new BookDTO();
		BookDAO dao = BookDAO.getMainDAO();
		
		dto.setBookImg(bookImg);
		dto.setBookName(bookName);
		dto.setBookWriter(bookWriter);
		dto.setBookPublisher(bookPublisher);
		dto.setBookPublishing(bookPublishing);
		
		dto.setBookColum(bookColum);
		dto.setBookField(bookField);
		
		dto.setInfoBook(infoBook);
		dto.setInfoWriter(infoWrtier);
		dto.setInfoContents(infoContents);
		
		
		
		if(!dao.windowInput_BookOk(dto)) {
			request.setAttribute("errorCode", "1");
		}
	}

}
