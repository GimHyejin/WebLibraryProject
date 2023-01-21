package com.Project5.www.LoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;

public class LoginSearchEmailCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String email_name = request.getParameter("email_name");
		String email_birthday = request.getParameter("email_birthday");
		
		MemberDTO dto = new MemberDTO();
		MemberDAO  dao = MemberDAO.getMainDAO();
		
		dto.setEmail(email);
		dto.setName(email_name);
		dto.setBirthday(email_birthday);
		
		if(dao.SearchEmail(dto)) { //이름 나이 생일이 있음
			session.setAttribute("id", dto.getId());
		}else {
			request.setAttribute("errorMsg", 1);
		}
		
	
	}

}
