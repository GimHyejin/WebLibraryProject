package com.Project5.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.Project5.www.DTO.BookBorrowDTO;
import com.Project5.www.DTO.BookDTO;


public class BookBorrowDAO {
	private static BookBorrowDAO boardDAO = null;
	private final String RESOURCE_NAME = "jdbc/project";
	private final String BorrowOri_NAME = "bookOrganization";
	private final String BorrowPersonal_NAME = "bookPersonal";
	private final String Member_Name = "member";
	
	private final String BorrowOri_sql = "select * from "+BorrowOri_NAME+" where bookNumber=?";
	private final String BorrowOriInput_sql = "insert into "+BorrowOri_NAME+"(bookNumber,bookName,bookColum) value(?,?,?)";
	
	//private final String BorrowExisting_sql ="select * from "+BorrowOri_NAME+" where id=? and pw=? and bookName=? and bookColum=?";
	
	private final String BorrowOkMember_sql ="select * from "+BorrowPersonal_NAME+" where id=? and bookOverdue=true";
	private final String BorrowCount_sql = "select count(*) as bookNum from "+BorrowPersonal_NAME+" where id=? and bookSubmit =false";
	private final String BookBorrowPersonal_sql = "select * from "+BorrowPersonal_NAME+" where id=? and bookNumber=? and bookSubmit=false";

	private final String BookPersonal_sql = "select * from bookpersonal p inner join bookOrganization o on p.bookNumber = o.bookNumber where id=? and bookSubmit=false";
	private final String BookPersonalHistory_sql = "select * from bookpersonal p inner join bookOrganization o on p.bookNumber = o.bookNumber where id=? and bookSubmit=true";
	private final String BorrowInputPersonal_sql = "insert into "+BorrowPersonal_NAME+"(id,bookNumber) value(?,?)";
	
	private final String BorrowInputOri_sql = "update "+BorrowOri_NAME+" set bookBorrow=true, countBorrow=? where bookNumber=? ";
	private final String BookReturn_sql ="update "+BorrowPersonal_NAME+" set bookSubmit=true where id=? and bookNumber=?";
	private final String BookOriReturn_sql ="update "+BorrowOri_NAME+" set bookBorrow=false where bookNumber=?";
	private DataSource dataSource;
	
	private BookBorrowDAO() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}

    }
    public static BookBorrowDAO getMainDAO() {
    	if(boardDAO ==null) {
    		boardDAO = new BookBorrowDAO();
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
    public boolean bookBorrowPersonalInfo(BookBorrowDTO bdto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean result = false;
    	
    	try {
    		pstmt = conn.prepareStatement(BookBorrowPersonal_sql);
			//"select * from "+BorrowPersonal_NAME+" where id=? and bookNumber=? and bookSubmit=false;
			pstmt.setString(1, bdto.getId());
			pstmt.setInt(2, bdto.getBookNumber());
			System.out.println(BookBorrowPersonal_sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			close(rs, pstmt, conn);
			return result;
		}
    	
    }
    public boolean bookBorrow(BookBorrowDTO bdto) {
    	
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean result = false;
    
    	
    	try {
			pstmt = conn.prepareStatement(BorrowOri_sql);
			//"select * from "+BorrowOri_NAME+" where bookNumber=?";
			pstmt.setInt(1,bdto.getBookNumber());
			System.out.println("책 검색:"+BorrowOri_sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bdto.setBookNumber(rs.getInt("bookNumber"));
				bdto.setBookName(rs.getString("bookName"));
				bdto.setBookColum(rs.getString("bookColum"));
				bdto.setBookBorrow(rs.getBoolean("bookBorrow"));
				bdto.setCountBorrow(rs.getInt("countBorrow"));
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
		}
    	return result;
    	
    }
    public void bookBorrowInput(BookBorrowDTO bdto) {	
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;

    	try {
			pstmt = conn.prepareStatement(BorrowOriInput_sql);
			//"insert into "+BorrowOri_NAME+"(bookNumber,bookName,boardColum) values(?,?,?)"";
			pstmt.setInt(1,bdto.getBookNumber());
			pstmt.setString(2,bdto.getBookName());
			pstmt.setString(3, bdto.getBookColum());
			
			int result = pstmt.executeUpdate();
			
			if(result>0) {
				System.out.println("도서 bookOrganization 삽입완료");
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
		}
    	
    }
    public void bookBorrowInput2(BookBorrowDTO bdto) {	
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;

    	try {
			pstmt = conn.prepareStatement(BorrowOri_sql);
			//""select * from "+BorrowOri_NAME+" where bookNumber=?";;
			pstmt.setInt(1,bdto.getBookNumber());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("도서 bookOrganization 삽입완료");
				bdto.setBookBorrow(rs.getBoolean("bookBorrow"));
				bdto.setCountBorrow(rs.getInt("countBorrow"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
		}
    	
    }
    public boolean BorrowPersonalCheck(BookBorrowDTO bdto) { //현재 아이디가 연체 되어있는지
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(BorrowOkMember_sql);
			//""select * from "+BorrowPersonal_NAME+" where id=? and bookOverdue=true";
			pstmt.setString(1,bdto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flage=true; //도서연체
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return flage;
    }
    
    
    public int BorrowCount(BookBorrowDTO bdto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int result = 0;
    	try {
			pstmt = conn.prepareStatement(BorrowCount_sql); //현재 빌린책의 갯수
			
			// "select count(*) as bookNum from "+BorrowPersonal_NAME+" where id=? and bookSumit =false"
			pstmt.setString(1,bdto.getId());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("bookNum");
			}else {
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return result;
		}
    }
    
    public ArrayList<BookBorrowDTO> BooksPersonal(String id) {  //개인 책 확인
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ArrayList<BookBorrowDTO> list = new ArrayList<>();
    	
    	try {
			pstmt = conn.prepareStatement(BookPersonal_sql);
			//select * from bookpersonal p inner join bookOrganization o on p.bookNumber = o.bookNumber where p.id=? and p.bookSubmit=false;
			pstmt.setString(1,id);
			System.out.println(id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookBorrowDTO bdto = new BookBorrowDTO();
				bdto.setBookNumber(rs.getInt("bookNumber"));
				bdto.setBookName(rs.getString("bookName"));
				bdto.setBookColum(rs.getString("bookColum"));
				bdto.setBookOverdue(rs.getBoolean("bookOverdue"));
				bdto.setBookSubmit(rs.getBoolean("bookSubmit"));
				bdto.setStartTime(rs.getString("startTime"));
				bdto.setStopTime(rs.getString("stopTime"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return list;
		}
    }
    public ArrayList<BookBorrowDTO> BooksPersonalHistory(String id) {  //개인 책 확인
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	ArrayList<BookBorrowDTO> list = new ArrayList<>();
    	
    	try {
			pstmt = conn.prepareStatement(BookPersonalHistory_sql);
			//"select * from bookpersonal p inner join bookOrganization o on p.bookNumber = o.bookNumber where id=? and bookSubmit=true";
			pstmt.setString(1,id);
			System.out.println(id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BookBorrowDTO bdto = new BookBorrowDTO();
				bdto.setBookNumber(rs.getInt("bookNumber"));
				bdto.setBookName(rs.getString("bookName"));
				bdto.setBookColum(rs.getString("bookColum"));
				bdto.setBookOverdue(rs.getBoolean("bookOverdue"));
				bdto.setBookSubmit(rs.getBoolean("bookSubmit"));
				bdto.setStartTime(rs.getString("startTime"));
				bdto.setStopTime(rs.getString("stopTime"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return list;
		}
    }
    public boolean BookBorrowPersonal(BookBorrowDTO bdto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage = false;
    	try {
			pstmt = conn.prepareStatement(BorrowInputPersonal_sql);
			// "insert into "+BorrowPersonal_NAME+"(id,bookNumber) value(?,?)";
			pstmt.setString(1, bdto.getId());
			pstmt.setInt(2, bdto.getBookNumber());
			
			int result = pstmt.executeUpdate();
			if(result >0) {
				flage = true;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt, conn);
			return flage;
		}
    }
    public boolean BookBorrowOrganization(BookBorrowDTO bdto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(BorrowInputOri_sql);
			//""update "+BorrowOri_NAME+" set bookBorrow=true, countBorrow=? where bookNumber=? ";
			pstmt.setInt(1, CountBorrow(bdto));
			pstmt.setInt(2, bdto.getBookNumber());
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				flage = true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    	return flage;
    }
    private int CountBorrow(BookBorrowDTO bdto) {	//도서 빌린 횟수
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	int result = 0;
    	try {
			pstmt = conn.prepareStatement(BorrowOri_sql);
			//"select * from "+BorrowOri_NAME+" where bookNumber=?
			pstmt.setInt(1, bdto.getBookNumber());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("countBorrow");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return result;
		}
    	
    }
    public boolean bookReturn(BookBorrowDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage = false;
    	try {
			pstmt = conn.prepareStatement(BookReturn_sql);
//"update "+BookBorrowPersonal_sql+" set bookSubmit=true where id=? and bookNumber=?";
			pstmt.setString(1,dto.getId());
			pstmt.setInt(2,dto.getBookNumber());
			System.out.println(BookReturn_sql);
			
			int result = pstmt.executeUpdate();
			if(result>0) {
				System.out.println("대출 반납 완료");
				flage = true;
			}
    	
    	} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt, conn);
			return flage;
		}
    }
    public boolean bookOriReturn(BookBorrowDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(BookOriReturn_sql);
			//"update "+BorrowOri_NAME+" set bookBorrow=false where bookNumber=?";
			pstmt.setInt(1,dto.getBookNumber());
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
}
