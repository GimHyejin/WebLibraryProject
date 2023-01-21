package com.Project5.www.LoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;

public class LoginCheckPwCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = MemberDAO.getMainDAO();
		
		dto.setId((String)session.getAttribute("id"));
		dto.setPw(request.getParameter("pw"));
		
		if(dao.CheckPw(dto)) {
			request.setAttribute("id", dto.getId());
			request.setAttribute("pw",dto.getPw());
		}else {
			request.setAttribute("errorMessage",1);
		}
	
	}
}
