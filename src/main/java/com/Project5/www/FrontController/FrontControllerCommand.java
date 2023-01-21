package com.Project5.www.FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.classfmt.ComponentInfoWithAnnotation;

import com.Project5.www.BookBorrowCommand.BookBorrowCommand;
import com.Project5.www.BookBorrowCommand.BookBorrowInputCommand;
import com.Project5.www.BookBorrowCommand.BookBorrowOkCommand;
import com.Project5.www.BookBorrowCommand.BookPersonalInfoCommand;
import com.Project5.www.BookBorrowCommand.BookPersonalOkCommand;
import com.Project5.www.BookBorrowCommand.BookReturnCommand;
import com.Project5.www.BookInfo.BookALL_SearchOkCommand;
import com.Project5.www.BookInfo.BookColum_SearchOkCommand;
import com.Project5.www.BookInfo.BookName_SearchOkCommand;
import com.Project5.www.BookInfo.BookNumber_SearchOkCommand;
import com.Project5.www.BookInfo.BookTitle_SearchCommand;
import com.Project5.www.LoginCommand.BoxInputOkCommand;
import com.Project5.www.LoginCommand.LoginChangePwCommand;
import com.Project5.www.LoginCommand.LoginCheckPwCommand;
import com.Project5.www.LoginCommand.LoginOkCommand;
import com.Project5.www.LoginCommand.LoginSearchEmailCommand;
import com.Project5.www.LoginCommand.LoginSearchPhoneCommand;
import com.Project5.www.LoginCommand.MemberModifyCommand;
import com.Project5.www.WinodowCommand.LoginExIdOkCommand;
import com.Project5.www.WinodowCommand.WindowInput_BookOkCommand;



/**
 * Servlet implementation class FrontControllerCommand
 */
@WebServlet("*.do")
public class FrontControllerCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String CommandName = request.getServletPath();
		
		Command command = null;
		String viewPage=null;
		boolean flag=false;
		
		
		/*메인페이지*/
		if(CommandName.equals("/Page/MainPage/MainPage.do")) { //메인메뉴바로 이동
			viewPage="../MainPage/MainPage.jsp";
		}
		
		/*로그인*/
		else if(CommandName.equals("/Page/MainPage/MainLogin.do")) { //로그인 화면으로(메뉴바)
			viewPage = "../LoginPage/LoginPage.jsp";
		}else if(CommandName.equals("/Page/MainPage/LoginOk.do")) { //로그인
			
			command = new LoginOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("LoginOkError") == null) { 
				viewPage = "MainPage.do";
			}else {
				request.removeAttribute("LoginOkError"); //아이디와 비밀번호 없음
				request.setAttribute("errorcode",1);
				viewPage= "MainPage.do";
			}
			
		}
		/*로그아웃*/
		else if(CommandName.equals("/Page/MainPage/LogOut.do")) {
			session.removeAttribute("LoginInfo");
			viewPage = "MainPage.do";
		}
		
		/*회원가입*/
		else if(CommandName.equals("/Page/MainPage/LoginJoinCheck.do")) { // 회원가입
			viewPage = "../LoginPage/LoginJoinCheck.jsp";
		}else if(CommandName.equals("/Page/MainPage/JoinCheckBoxError.do")) { // 비동의 버튼
			viewPage = "../LoginPage/JoinCheckBoxError.jsp";
		}
		
		else if(CommandName.equals("/Page/MainPage/LoginJoinCheckOk.do")) { //회원가입 입력
			viewPage = "../LoginPage/JoinBoxInput.jsp";
		}else if(CommandName.equals("/Page/MainPage/BoxInputOk.do")) { //회원가입 정보 입력
			command = new BoxInputOkCommand();
			command.excute(request, response);
			if(request.getAttribute("errorCode")==null) {
				viewPage = "../LoginPage/JoinBoxInputOk.jsp";
			}else {
				viewPage = "../LoginPage/JoinBoxInputError.jsp";
			}
		}
		/*아이디 확인*/
		else if(CommandName.equals("/Page/WindowLoginPage/LoginExIdOk.do")) {
			command = new LoginExIdOkCommand();
			command.excute(request, response);
			if(request.getAttribute("Exid") == null) { 
				viewPage = "LoginExIdOk.jsp"; //기존아이디가  없다.
			}else {
				viewPage = "LoginExIdError.jsp"; //기존아이디가 있다.
			}
		}
		
		/*로그인 id 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchId.do")) {
			viewPage="../LoginPage/LoginSearchId.jsp";
		}
		/*로그인 id phone 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchIdPhone.do")) {
			command = new LoginSearchPhoneCommand();
			command.excute(request, response);
			
			if(session.getAttribute("id") == null) {
				viewPage = "../LoginPage/LoginSearchId.jsp"; //정보  없음
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LogInSearchIdInfo.jsp"; //정보 있음
			}
		}
		/*로그인 id email 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchIdEmail.do")) { //이메일로 아이디 찾기
			command = new LoginSearchEmailCommand();
			command.excute(request, response);
			if(session.getAttribute("id") == null) {
				viewPage="../LoginPage/LoginSearchId.jsp";
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LogInSearchIdInfo.jsp";
				
			}
		}
		/*로그인 pw 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchPw.do")) {
			viewPage="../LoginPage/LoginSearchPw.jsp";
		}
		
		/*로그인 pw phone으로 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchPwPhone.do")) {
			command = new LoginSearchPhoneCommand();
			command.excute(request, response);
			
			if(session.getAttribute("id") == null) {
				viewPage = "../LoginPage/LogInSearchPw.jsp"; //정보 있음
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LoginCheckPw.jsp"; //정보  없음
			}
		}
		/*로그인 pw email으로 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchPwEmail.do")){
			command = new LoginSearchEmailCommand();
			command.excute(request, response);
			
			if(session.getAttribute("id") == null) {
				viewPage = "../LoginPage/LogInSearchPw.jsp";
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage="../LoginPage/LoginCheckPw.jsp";
				
			}
		}
		
		/*로그인 change pw 으로 찾기*/
		else if(CommandName.equals("/Page/MainPage/LoginCheckPw.do")){
			command = new LoginCheckPwCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorMessage") == null) {
				viewPage = "../LoginPage/LoginChangePwOk.jsp";
			}else {
				viewPage = "../LoginPage/LoginCheckPw.jsp";
			}
		}
		/*로그인 비밀번호 변경*/
		else if(CommandName.equals("/Page/MainPage/LoginChangePw.do")){
			command = new LoginChangePwCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorMessage") == null) {
				viewPage ="../MainPage/MainPage.do";
				session.removeAttribute("id");
			}else {
				viewPage ="../LoginPage/LoginChangePwOk.jsp";
			}
			
		}
		/*메인페이지 비밀번호 변경*/
		else if(CommandName.equals("/Page/MainPage/MainChangePw.do")){
			viewPage ="../LoginPage/LoginChangePwOk.jsp";
			session.setAttribute("id",request.getParameter("id"));
		}
		/*나의 정보*/
		else if(CommandName.equals("/Page/MainPage/MemberInfo.do")){
			viewPage="../LoginPage/LoginMemberInfo.jsp";
		}
		/*회원 정보수정*/
		else if(CommandName.equals("/Page/MainPage/MemberModify.do")){
			viewPage="../LoginPage/ModifyCheckPw.jsp";
		}else if(CommandName.equals("/Page/MainPage/ModifyCheckPwOk.do")){
			viewPage="../LoginPage/MemberModify.jsp";
		}else if(CommandName.equals("/Page/MainPage/MemberModifyOk.do")){
			command = new MemberModifyCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorCode")==null) {
				session.removeAttribute("LoginInfo");
				viewPage="../MainPage/MainPage.do";
			}else {
				viewPage="../LoginPage/MemberModifyError.jsp";
			}
			
		}
		
		/*도서 전체 검색*/
		else if(CommandName.equals("/Page/MainPage/unifiedSearch.do")) {
			if(request.getParameter("head_search") == null) {
				viewPage ="../BookALLPage/unifiedSearch.jsp";
			}else if(request.getParameter("head_search").equals("Book_Search")) {
				if(request.getParameter("search").equals("")) {
					viewPage="BookAll_Search.do";
				}else {
					viewPage="BookName_Search.do";
				}
			}else if(request.getParameter("head_search").equals("Integrated_Search")) {
				
			}
		}
		/*모든 도서 보기*/
		else if(CommandName.equals("/Page/MainPage/BookAll_Search.do")) {
			command = new BookALL_SearchOkCommand();
			command.excute(request, response);
			viewPage = "../BookALLPage/BookAll_Search.jsp";
		}
		/*모든 도서 제목 찾기*/
		else if(CommandName.equals("/Page/MainPage/BookName_Search.do")) {
			command = new BookName_SearchOkCommand();
			command.excute(request, response);
			viewPage="../BookALLPage/BookAll_Search.jsp";
		}
		/* 도서 항목 검색*/
		else if(CommandName.equals("/Page/MainPage/BookAll_SearchOk.do")) {
			command = new BookColum_SearchOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("error1") == null) {
				viewPage ="../BookALLPage/BookAll_Search.jsp";
			}else {
				viewPage = "../BookALLPage/BookAllError.jsp";
			}
			
		}
		/*도서 (제목/내용/저자)*/
		else if(CommandName.equals("/Page/MainPage/BookTitle_SearchOk.do")) {
			command = new BookTitle_SearchCommand();
			command.excute(request, response);
			viewPage="../BookALLPage/BookAll_Search.jsp";
			
		}
		/*도서 등록 */
		else if(CommandName.equals("/Page/WindowBookPage/Input_BookOk.do")) {
			command = new WindowInput_BookOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorCode") == null) {
				viewPage ="../WindowBookPage/inputBookOk.jsp";
			}else {
				viewPage ="../WindowBookPage/inputBookError.jsp";
			}
		}
		
		/*도서의 정보 확인*/
		else if(CommandName.equals("/Page/MainPage/BooksInfo.do")){
			command = new BookNumber_SearchOkCommand();
			command.excute(request, response);
			viewPage = "../BookALLPage/BookInfo.jsp";
		}
		
		/*도서의 대출 여부*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookBorrow.do")) {
			command = new BookBorrowCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorMyBook") != null) { //자신이 도서를 빌린경우
				viewPage = "../WindowBorrowPage/BookBorrowError_myBook.jsp";
				System.out.println(request.getAttribute("borrow_id")); //도서 확인 가능
			}else {
				viewPage = "../WindowBorrowPage/BookBorrowCheck.jsp";
			}
		}
		
		/*도서 대출*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookBorrowOk.do")) {
			command = new BookBorrowOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorCode1") != null) { //연체 회원
				viewPage = "../WindowBorrowPage/BookBorrowError.jsp";
			}else if(request.getAttribute("errorCode2") != null) { //빌린 도서수 5권이상
				viewPage="../WindowBorrowPage/BookBorrowError.jsp";
			}else {
				command = new BookBorrowInputCommand();
				command.excute(request, response);
				if(request.getAttribute("errorCode3") != null) {
					viewPage = "../WindowBorrowPage/BookBorrowError2.jsp";
				}else {
					viewPage = "../WindowBorrowPage/BookBorrowOk.jsp";
				}
			}
		}
		
		/*도서 대출 내역 확인*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookPersonal.do")) {
			command = new BookPersonalOkCommand();
			command.excute(request, response);
			viewPage = "../WindowBorrowPage/BookPersonal.jsp";
			
		}
		
		/*메인화면에서 도서 대출 확인*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookPersonalInfo.do")) {
			command = new BookPersonalInfoCommand();
			command.excute(request, response);
			viewPage = "../WindowBorrowPage/BookPersonalInfoOk.jsp";
			
		}
		/*메인화면에서 도서 반납 */
		else if(CommandName.equals("/Page/WindowBorrowPage/BookReturn.do")){
			command = new BookReturnCommand();
			command.excute(request, response);
			viewPage = "../WindowBorrowPage/BookPersonalInfo.do";
		}
		
		/*
		if(!flag) {
			response.sendRedirect(viewPage);
		}else 
		*/
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
	}
	
	
}