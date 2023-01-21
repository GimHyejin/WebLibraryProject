package com.Project5.www.LoginCommand;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;


public class LoginOkCommand implements Command{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = MemberDAO.getMainDAO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		
		if(dao.LoginOk(dto)) {
			
			session.setAttribute("LoginInfo",dto);
		}else {
			
			System.out.println("login 오류 발생 값이 없음");
			request.setAttribute("LoginOkError", 1);
		}
		
	}
	

}
