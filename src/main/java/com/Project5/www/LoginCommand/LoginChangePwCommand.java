package com.Project5.www.LoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;

public class LoginChangePwCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberDAO dao = MemberDAO.getMainDAO();
		MemberDTO dto = new MemberDTO();
		
		dto.setId((String)session.getAttribute("id"));
		dto.setPw(request.getParameter("checkPw"));
		
		System.out.println("비밀번호 변경:"+dao.ChangPw(dto));
		if(dao.ChangPw(dto)) {
			
		}else {
			request.setAttribute("errorMessage",1);
		}
	}

}
