package com.Project5.www.WinodowCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;



public class LoginExIdOkCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		
		MemberDAO dao = MemberDAO.getMainDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		if(dao.ExIdOk(dto)) {
			request.setAttribute("Exid", 1); //기존 아이디가 있다
			
		}else {
			//기존아이디가 없다.
			request.setAttribute("id", id);
		}
		
	
	}

}
