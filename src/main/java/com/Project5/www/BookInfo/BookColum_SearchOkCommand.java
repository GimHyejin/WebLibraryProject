package com.Project5.www.BookInfo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.BookDAO;
import com.Project5.www.DTO.BookDTO;
import com.Project5.www.FrontController.Command;


public class BookColum_SearchOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BookDAO bookdao = BookDAO.getMainDAO();
		
		int columCount =0;
		String[] colums = new String[8]; //칼럼의 갯수
		ArrayList<String> columName = new ArrayList<>(); //칼럼의 이

		
		if(request.getParameterValues("literature_sub") != null) {
			
			colums = request.getParameterValues("literature_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
			
		}
		if(request.getParameterValues("economy_sub") != null) {
			
			colums = request.getParameterValues("economy_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("journey_sub") != null) {
		
			
			colums = request.getParameterValues("journey_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("computer_sub") != null) {
			
			colums = request.getParameterValues("computer_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("hobby_sub") != null) {
			
			colums = request.getParameterValues("hobby_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("development_sub") != null) {
			
			colums = request.getParameterValues("development_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("medicine_sub") != null) {
	
			colums = request.getParameterValues("medicine_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("art_sub") != null) {
		
			colums = request.getParameterValues("art_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("employment_sub") != null) {
	
			colums = request.getParameterValues("employment_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		if(request.getParameterValues("child_sub") != null) {
			
			colums = request.getParameterValues("child_sub");
			for(int i=0;i<colums.length;i++) {
				columName.add(colums[i]);
				columCount++;
			}
		}
		
		if(columCount == 0) {
			request.setAttribute("error1", 1);
		}
		else {
			System.out.println("칼럼수"+columCount);
			request.setAttribute("bookInfo", bookdao.BookAllSearchOk(columName,columCount));
		}
		
	}

}
