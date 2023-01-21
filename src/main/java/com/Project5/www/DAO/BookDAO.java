package com.Project5.www.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.Project5.www.DTO.BookDTO;
import com.Project5.www.DTO.MemberDTO;
import com.Project5.www.FrontController.Command;

public class BookDAO{
		private static BookDAO boardDAO = new BookDAO();
		private final String RESOURCE_NAME = "jdbc/project";
		private DataSource dataSource;
		private final String databaseName="BookInfo";
		private final String INPUT_BOOKOK_SQL = "insert into BookInfo(bookImg,bookName,bookWriter,bookPublishing,bookPublisher,bookColum,bookField,infoBook,infoWriter,infoContents) value(?,?,?,?,?,?,?,?,?,?)";
		private final String SEARCH_BOOK_SQL ="select * from "+databaseName;
		private final String SEARCH_NUMBER_BOOK_SQL="select * from "+databaseName+" where bookNumber=?";
		
		private BookDAO() {
			Context context;
			try {
				context = new InitialContext();
				dataSource = (DataSource)context.lookup("java:comp/env/" + RESOURCE_NAME);
			} catch (NamingException e) {
				e.printStackTrace();
			}

	    }
	    public static BookDAO getMainDAO() {
	    	if(boardDAO ==null) {
	    		boardDAO = new BookDAO();
	    	}
	    	return boardDAO;
	    }

	    private Connection getConnection() {
			Connection conn = null;
			try {
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
	    private void close(ResultSet rs,PreparedStatement pstmt, Connection conn) {
	    	try {
				if(rs!= null)	rs.close();
				if(pstmt != null)	pstmt.close();
				if(conn != null)	conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    private void close(PreparedStatement pstmt, Connection conn) {
	    	try {
	    		if(pstmt != null)	pstmt.close();
	    		if(conn != null)	conn.close();
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    	}
	    }
	    
	    /*전체 도서 확인하기*/
	    public ArrayList<BookDTO> BookAll(){
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	ArrayList<BookDTO> bookList = new ArrayList<>();
	    	
	    	try {
				pstmt = conn.prepareStatement(SEARCH_BOOK_SQL);
				//"select * from "+databaseName;
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BookDTO dto = new BookDTO();
					dto.setBookNumber(rs.getInt("bookNumber"));
					dto.setBookColum(rs.getString("bookColum"));
					dto.setBookField(rs.getString("bookField"));
					dto.setBookName(rs.getString("bookName"));
					dto.setBookWriter(rs.getString("bookWriter"));
					dto.setBookPublisher(rs.getString("bookPublishing"));
					dto.setBookPublishing(rs.getString("bookPublisher"));
					dto.setBookImg(rs.getString("bookImg"));
					dto.setBookTime(rs.getString("bookTime"));
					dto.setInfoBook(rs.getString("infoBook"));
					dto.setInfoWriter(rs.getString("infoWriter"));
					dto.setInfoContents(rs.getString("infoContents"));
					bookList.add(dto);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt, conn);
				return bookList;
			}
	    }
	    
	    /*모든 도서 확인하기*/
	    public ArrayList<BookDTO> BookAllSearchOk(ArrayList<String> colum ,int columCount) {
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	
	    	ArrayList<BookDTO> bookList = new ArrayList<>();
	    	
	    	//allSearch_sql "select * from BookInfo ";
	    	String allSearch_sql ="select * from BookInfo ";
	    	//조건 칼럼의 갯수
	    	allSearch_sql += " where bookColum='"+colum.get(0) +"'";
	    	
	    	//System.out.println(allSearch_sql);
	    	for(int i=1;i<columCount;i++) {
	    		allSearch_sql += " or bookColum='"+colum.get(i) +"'";
	    	}
	    	System.out.println(allSearch_sql);
	    	
	    	try {
				pstmt = conn.prepareStatement(allSearch_sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BookDTO bdto = new BookDTO();
					bdto.setBookNumber(rs.getInt("bookNumber"));
					bdto.setBookTime(rs.getString("bookTime"));
					bdto.setBookImg(rs.getString("bookImg"));
					
					bdto.setBookName(rs.getString("bookName"));
					bdto.setBookWriter(rs.getString("bookWriter"));
					bdto.setBookPublishing(rs.getString("bookPublishing"));
					bdto.setBookPublisher(rs.getString("bookPublisher"));
					
					bdto.setBookColum(rs.getString("bookColum"));
					bdto.setBookField(rs.getString("bookField"));
					bdto.setInfoBook(rs.getString("infoBook"));
					bdto.setInfoWriter(rs.getString("infoWriter"));
					bdto.setInfoContents(rs.getString("infoContents"));
				
					bookList.add(bdto);
				
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt, conn);
			}
	    	return bookList;
	    }
	    /*도서 등록*/
	    public boolean windowInput_BookOk(BookDTO dto) {
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	boolean flage = false;
	    	
	    	try {
				pstmt = conn.prepareStatement(INPUT_BOOKOK_SQL);
				//"insert into BookInfo(bookImg,bookName,bookWriter,bookPublishing,bookPublisher,bookColum,bookField,infoBook,infoWriter,infoContents) value(?,?,?,?,?,?,?,?,?,?)";
				pstmt.setString(1,dto.getBookImg());
				pstmt.setString(2,dto.getBookName());
				pstmt.setString(3,dto.getBookWriter());
				pstmt.setString(4,dto.getBookPublishing());
				pstmt.setString(5,dto.getBookPublisher());
				pstmt.setString(6,dto.getBookColum());
				pstmt.setString(7,dto.getBookField());
				pstmt.setString(8,dto.getInfoBook());
				pstmt.setString(9,dto.getInfoWriter());
				pstmt.setString(10,dto.getInfoContents());
				
				int result = pstmt.executeUpdate();
			
				if(result>0) {
					flage = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt, conn);
				return flage;
			}
	    }
	    /*책의 제목으로 값 찾기*/
	    public ArrayList<BookDTO> BookName_SearchOk(String bookName) {
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	    	String SEARCH_BOOKNAME_SQL = "select * from "+databaseName+" where bookName ";
	    	boolean flage=false;
	    	try {
	    		SEARCH_BOOKNAME_SQL +=" like '%"+bookName+"%'";
	    		pstmt = conn.prepareStatement(SEARCH_BOOKNAME_SQL);
				//"select * from "+databaseName+" where bookName ";
				//pstmt.setString(1, bookName);
				System.out.println(SEARCH_BOOKNAME_SQL);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BookDTO dto = new BookDTO();
					dto.setBookNumber(rs.getInt("bookNumber"));
					
					dto.setBookImg(rs.getString("bookImg"));
					dto.setBookName(rs.getString("bookName"));
					dto.setBookWriter(rs.getString("bookWriter"));
					dto.setBookPublisher(rs.getString("bookPublisher"));
					dto.setBookPublishing(rs.getString("bookPublishing"));
					
					dto.setBookColum(rs.getString("bookColum"));
					dto.setBookField(rs.getString("bookField"));
					
					dto.setInfoBook(rs.getString("infoBook"));
					dto.setInfoWriter(rs.getString("infoWriter"));
					dto.setInfoContents(rs.getString("infoContents"));
					booklist.add(dto);
					
				}
			
	    	} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, pstmt, conn);
				return booklist;
			}
	    }
	    /*도서(제목/내용/저자)*/
	    public ArrayList<BookDTO> BookTitle_SearchOk(String select,String Search_contents) {
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	
	    	ArrayList<BookDTO> booklist = new ArrayList<BookDTO>();
	    	String BookTitle_Search_Sql = "select * from "+databaseName+" where "+select+" like '%"+Search_contents+"%'";
	    	try {
				pstmt = conn.prepareStatement(BookTitle_Search_Sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					BookDTO dto = new BookDTO();
					dto.setBookNumber(rs.getInt("bookNumber"));
					dto.setBookImg(rs.getString("bookImg"));
					dto.setBookName(rs.getString("bookName"));
					dto.setBookWriter(rs.getString("bookWriter"));
					dto.setBookPublisher(rs.getString("bookPublisher"));
					dto.setBookPublishing(rs.getString("bookPublishing"));
					dto.setBookField(rs.getString("bookField"));
					dto.setBookColum(rs.getString("bookColum"));
					dto.setInfoBook(rs.getString("infoBook"));
					dto.setInfoWriter(rs.getString("infoWriter"));;
					dto.setInfoContents(rs.getString("infoContents"));
					booklist.add(dto);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				close(rs, pstmt, conn);
				return booklist;
			}
	    }
	    public BookDTO BookNumber_SearchOk(BookDTO dto){
	    	Connection conn = getConnection();
	    	PreparedStatement pstmt = null;
	    	ResultSet rs = null;
	    	
	    	
	    	try {
				pstmt = conn.prepareStatement(SEARCH_NUMBER_BOOK_SQL);
				//"select * from "+databaseName+" where bookNumber=?";
				pstmt.setInt(1,dto.getBookNumber());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					dto.setBookNumber(rs.getInt("bookNumber"));
					dto.setBookImg(rs.getString("bookImg"));
					dto.setBookName(rs.getString("bookName"));
					dto.setBookWriter(rs.getString("bookWriter"));
					dto.setBookPublishing(rs.getString("bookPublishing"));
					dto.setBookPublisher(rs.getString("bookPublisher"));
					dto.setBookColum(rs.getString("bookColum"));
					dto.setBookField(rs.getString("bookField"));
					dto.setInfoBook(rs.getString("infoBook"));
					dto.setInfoWriter(rs.getString("infoWriter"));
					dto.setInfoContents(rs.getString("infoContents"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs, pstmt, conn);
			}
	    	return dto;
	    }
	}


