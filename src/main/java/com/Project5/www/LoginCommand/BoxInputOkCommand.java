package com.Project5.www.LoginCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Project5.www.DAO.MemberDAO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;


public class BoxInputOkCommand implements Command {


	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = MemberDAO.getMainDAO();
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		
		dto.setName(request.getParameter("name"));
		dto.setBirthday(request.getParameter("birthday"));
		dto.setPhone_first(request.getParameter("phone_first"));
		dto.setPhone_last(request.getParameter("phone_last"));
		
		dto.setEmail(request.getParameter("email"));
		dto.setResident_first(request.getParameter("resident_first"));
		dto.setResident_last(request.getParameter("resident_last"));
		
		dto.setPostCode(Integer.parseInt(request.getParameter("postcode")));
		dto.setRoadAddress(request.getParameter("roadAddress"));
		dto.setJibunAddress(request.getParameter("jibunAddress"));
		dto.setDetailAddress(request.getParameter("detailAddress"));
		dto.setExtraAddress(request.getParameter("extraAddress"));
		
		if(!dao.boxInputOk(dto)) {
			request.setAttribute("errorCode",1);
		}
	}
	
}
