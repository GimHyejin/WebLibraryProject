package com.Project5.www.LoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;




public class LoginSearchPhoneCommand implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String name = request.getParameter("phone_name");
		String birthday = request.getParameter("phone_birthday");
		String first_phone = request.getParameter("phone_first");
		String last_phone = request.getParameter("phone_last");
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = MemberDAO.getMainDAO();
		
		dto.setName(name);
		dto.setBirthday(birthday);
		dto.setPhone_first(first_phone);
		dto.setPhone_last(last_phone);
		
		System.out.println("전화번호 존재"+dao.SearchPhone(dto));
		
		if(dao.SearchPhone(dto)) {
			session.setAttribute("id", dto.getId());
		}else {
			request.setAttribute("error", 1);
		}
	
	
	}

}
