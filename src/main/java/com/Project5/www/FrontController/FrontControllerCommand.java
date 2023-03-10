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
		
		
		/*???????????????*/
		if(CommandName.equals("/Page/MainPage/MainPage.do")) { //?????????????????? ??????
			viewPage="../MainPage/MainPage.jsp";
		}
		
		/*?????????*/
		else if(CommandName.equals("/Page/MainPage/MainLogin.do")) { //????????? ????????????(?????????)
			viewPage = "../LoginPage/LoginPage.jsp";
		}else if(CommandName.equals("/Page/MainPage/LoginOk.do")) { //?????????
			
			command = new LoginOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("LoginOkError") == null) { 
				viewPage = "MainPage.do";
			}else {
				request.removeAttribute("LoginOkError"); //???????????? ???????????? ??????
				request.setAttribute("errorcode",1);
				viewPage= "MainPage.do";
			}
			
		}
		/*????????????*/
		else if(CommandName.equals("/Page/MainPage/LogOut.do")) {
			session.removeAttribute("LoginInfo");
			viewPage = "MainPage.do";
		}
		
		/*????????????*/
		else if(CommandName.equals("/Page/MainPage/LoginJoinCheck.do")) { // ????????????
			viewPage = "../LoginPage/LoginJoinCheck.jsp";
		}else if(CommandName.equals("/Page/MainPage/JoinCheckBoxError.do")) { // ????????? ??????
			viewPage = "../LoginPage/JoinCheckBoxError.jsp";
		}
		
		else if(CommandName.equals("/Page/MainPage/LoginJoinCheckOk.do")) { //???????????? ??????
			viewPage = "../LoginPage/JoinBoxInput.jsp";
		}else if(CommandName.equals("/Page/MainPage/BoxInputOk.do")) { //???????????? ?????? ??????
			command = new BoxInputOkCommand();
			command.excute(request, response);
			if(request.getAttribute("errorCode")==null) {
				viewPage = "../LoginPage/JoinBoxInputOk.jsp";
			}else {
				viewPage = "../LoginPage/JoinBoxInputError.jsp";
			}
		}
		/*????????? ??????*/
		else if(CommandName.equals("/Page/WindowLoginPage/LoginExIdOk.do")) {
			command = new LoginExIdOkCommand();
			command.excute(request, response);
			if(request.getAttribute("Exid") == null) { 
				viewPage = "LoginExIdOk.jsp"; //??????????????????  ??????.
			}else {
				viewPage = "LoginExIdError.jsp"; //?????????????????? ??????.
			}
		}
		
		/*????????? id ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchId.do")) {
			viewPage="../LoginPage/LoginSearchId.jsp";
		}
		/*????????? id phone ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchIdPhone.do")) {
			command = new LoginSearchPhoneCommand();
			command.excute(request, response);
			
			if(session.getAttribute("id") == null) {
				viewPage = "../LoginPage/LoginSearchId.jsp"; //??????  ??????
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LogInSearchIdInfo.jsp"; //?????? ??????
			}
		}
		/*????????? id email ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchIdEmail.do")) { //???????????? ????????? ??????
			command = new LoginSearchEmailCommand();
			command.excute(request, response);
			if(session.getAttribute("id") == null) {
				viewPage="../LoginPage/LoginSearchId.jsp";
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LogInSearchIdInfo.jsp";
				
			}
		}
		/*????????? pw ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchPw.do")) {
			viewPage="../LoginPage/LoginSearchPw.jsp";
		}
		
		/*????????? pw phone?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginSearchPwPhone.do")) {
			command = new LoginSearchPhoneCommand();
			command.excute(request, response);
			
			if(session.getAttribute("id") == null) {
				viewPage = "../LoginPage/LogInSearchPw.jsp"; //?????? ??????
				request.setAttribute("errorMsg", 1);
			}else {
				viewPage = "../LoginPage/LoginCheckPw.jsp"; //??????  ??????
			}
		}
		/*????????? pw email?????? ??????*/
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
		
		/*????????? change pw ?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/LoginCheckPw.do")){
			command = new LoginCheckPwCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorMessage") == null) {
				viewPage = "../LoginPage/LoginChangePwOk.jsp";
			}else {
				viewPage = "../LoginPage/LoginCheckPw.jsp";
			}
		}
		/*????????? ???????????? ??????*/
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
		/*??????????????? ???????????? ??????*/
		else if(CommandName.equals("/Page/MainPage/MainChangePw.do")){
			viewPage ="../LoginPage/LoginChangePwOk.jsp";
			session.setAttribute("id",request.getParameter("id"));
		}
		/*?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/MemberInfo.do")){
			viewPage="../LoginPage/LoginMemberInfo.jsp";
		}
		/*?????? ????????????*/
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
		
		/*?????? ?????? ??????*/
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
		/*?????? ?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/BookAll_Search.do")) {
			command = new BookALL_SearchOkCommand();
			command.excute(request, response);
			viewPage = "../BookALLPage/BookAll_Search.jsp";
		}
		/*?????? ?????? ?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/BookName_Search.do")) {
			command = new BookName_SearchOkCommand();
			command.excute(request, response);
			viewPage="../BookALLPage/BookAll_Search.jsp";
		}
		/* ?????? ?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/BookAll_SearchOk.do")) {
			command = new BookColum_SearchOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("error1") == null) {
				viewPage ="../BookALLPage/BookAll_Search.jsp";
			}else {
				viewPage = "../BookALLPage/BookAllError.jsp";
			}
			
		}
		/*?????? (??????/??????/??????)*/
		else if(CommandName.equals("/Page/MainPage/BookTitle_SearchOk.do")) {
			command = new BookTitle_SearchCommand();
			command.excute(request, response);
			viewPage="../BookALLPage/BookAll_Search.jsp";
			
		}
		/*?????? ?????? */
		else if(CommandName.equals("/Page/WindowBookPage/Input_BookOk.do")) {
			command = new WindowInput_BookOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorCode") == null) {
				viewPage ="../WindowBookPage/inputBookOk.jsp";
			}else {
				viewPage ="../WindowBookPage/inputBookError.jsp";
			}
		}
		
		/*????????? ?????? ??????*/
		else if(CommandName.equals("/Page/MainPage/BooksInfo.do")){
			command = new BookNumber_SearchOkCommand();
			command.excute(request, response);
			viewPage = "../BookALLPage/BookInfo.jsp";
		}
		
		/*????????? ?????? ??????*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookBorrow.do")) {
			command = new BookBorrowCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorMyBook") != null) { //????????? ????????? ????????????
				viewPage = "../WindowBorrowPage/BookBorrowError_myBook.jsp";
				System.out.println(request.getAttribute("borrow_id")); //?????? ?????? ??????
			}else {
				viewPage = "../WindowBorrowPage/BookBorrowCheck.jsp";
			}
		}
		
		/*?????? ??????*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookBorrowOk.do")) {
			command = new BookBorrowOkCommand();
			command.excute(request, response);
			
			if(request.getAttribute("errorCode1") != null) { //?????? ??????
				viewPage = "../WindowBorrowPage/BookBorrowError.jsp";
			}else if(request.getAttribute("errorCode2") != null) { //?????? ????????? 5?????????
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
		
		/*?????? ?????? ?????? ??????*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookPersonal.do")) {
			command = new BookPersonalOkCommand();
			command.excute(request, response);
			viewPage = "../WindowBorrowPage/BookPersonal.jsp";
			
		}
		
		/*?????????????????? ?????? ?????? ??????*/
		else if(CommandName.equals("/Page/WindowBorrowPage/BookPersonalInfo.do")) {
			command = new BookPersonalInfoCommand();
			command.excute(request, response);
			viewPage = "../WindowBorrowPage/BookPersonalInfoOk.jsp";
			
		}
		/*?????????????????? ?????? ?????? */
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