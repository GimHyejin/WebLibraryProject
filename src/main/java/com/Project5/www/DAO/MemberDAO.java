package com.Project5.www.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.Project5.www.DTO.MemberDTO;



public class MemberDAO {
	
	private static MemberDAO boardDAO = new MemberDAO();
	private final String RESOURCE_NAME = "jdbc/project";
	private final String TABLE_NAME = "member";
	private DataSource dataSource;
	
	private final String LOGINOK_SQL = "select * from "+TABLE_NAME;
	private final String SEARCH_PHONE_SQL ="select * from "+TABLE_NAME+" where name=? and birthday=? and phone_first=? and phone_last=?";
	private final String SEARCH_EMAIL_SQL ="select * from "+TABLE_NAME+" where name=? and email=? and birthday=?";
	private final String CHECK_PW_SQL = "select * from  "+TABLE_NAME+" where id=? and pw=?";
	private final String CHAGE_PW_SQL ="update "+TABLE_NAME+" set pw=? where id=?";
	private final String INPUTOK_SQL = "insert into "+TABLE_NAME+"(id,pw,name,birthday,phone_first,phone_last,email,resident_first,resident_last,postCode,roadAddress,jibunAddress,detailAddress,extraAddress) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String EXID_SQL ="select * from "+TABLE_NAME+" where id=?";
	private final String UPDATE_SQL ="update "+TABLE_NAME+" set id=?,name=?, birthday=?,phone_first=?,phone_last=?,email=?,resident_first=?,resident_last=?,postCode=?,roadAddress=?,jibunAddress=?,detailAddress=?,extraAddress=? where id=?";
			
	
	private MemberDAO() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/" + RESOURCE_NAME);
		} catch (NamingException e) {
			e.printStackTrace();
		}

    }
    public static MemberDAO getMainDAO() {
    	if(boardDAO ==null) {
    		boardDAO = new MemberDAO();
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
    //로그인
    public boolean LoginOk(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean result = false;
    	
    	try {
    		pstmt = conn.prepareStatement(LOGINOK_SQL); //"select * from "+TABLE_NAME;
    		rs = pstmt.executeQuery();
    		while(rs.next()) {
    			if(rs.getString("id").equals(dto.getId()) && rs.getString("pw").equals(dto.getPw())) {
    				
    				dto.setName(rs.getString("name"));
    				dto.setBirthday(rs.getString("birthday"));
    				
    				dto.setPhone_first(rs.getString("phone_first"));
    				dto.setPhone_last(rs.getString("phone_last"));
    				
    				dto.setEmail(rs.getString("email"));
    				dto.setResident_first(rs.getString("resident_first"));
    				dto.setResident_last(rs.getString("resident_last"));
    				
    				dto.setPostCode(rs.getInt("postCode"));
    				dto.setRoadAddress(rs.getString("roadAddress"));
    				dto.setJibunAddress(rs.getString("jibunAddress"));
    				dto.setDetailAddress(rs.getString("detailAddress"));
    				dto.setExtraAddress(rs.getString("extraAddress"));
    	
    				result = true;
    				break;
    			}
    		}
    		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs,pstmt, conn);
		}
    	return result;
    }
    //로그인 전화번호 찾기
    public boolean SearchPhone(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(SEARCH_PHONE_SQL); 
			//"select * from "+TABLE_NAME+" where name=? and birthday=? and phone_first=? and phone_last=?";
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirthday());
			pstmt.setString(3, dto.getPhone_first());
			pstmt.setString(4, dto.getPhone_last());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				flage = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
		}
    	return flage;
    	
    }
    /*로그인 이메일 찾기*/
    public boolean SearchEmail(MemberDTO dto) { //아이디 찾기 (이메일)
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(SEARCH_EMAIL_SQL);
			//"select * from "+TABLE_NAME+" where name=? and email=? and birthday=?";
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3,dto.getBirthday());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				flage = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return flage;
    }
    
    /* 패스워드  */
    
    public boolean CheckPw(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	boolean flage = false;
    	try {
			pstmt =  conn.prepareStatement(CHECK_PW_SQL);
			
			// "select * from  "+TABLE_NAME+" where id=? and pw=?";
			pstmt.setString(1,dto.getId());
			pstmt.setString(2,dto.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				flage = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return flage;
		}
    }
    //비밀번호 변경
    public boolean ChangPw(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage = false;
    	
    	try {
			pstmt = conn.prepareStatement(CHAGE_PW_SQL);
			//"update "+TABLE_NAME+" set pw=? where id=?";
			pstmt.setString(1,dto.getPw());
			pstmt.setString(2,dto.getId());
			int result = pstmt.executeUpdate();
			if(result>0) {
				flage=true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(pstmt, conn);
			return flage;
		}
    }
	//회원가입 
    public boolean boxInputOk(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	boolean flage=false;
    	int result = 0;
    	try {
			pstmt = conn.prepareStatement(INPUTOK_SQL);
//"insert into "+TABLE_NAME+"(id,pw,name,birthday,phone_first,phone_last,email,resident_first,resident_last,postCode,roadAddress,jibunAddress,detailAddress,extraAddress) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3,dto.getName());
			pstmt.setString(4, dto.getBirthday());
			pstmt.setString(5, dto.getPhone_first());
			pstmt.setString(6, dto.getPhone_last());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getResident_first());
			pstmt.setString(9, dto.getResident_last());
			pstmt.setInt(10,dto.getPostCode());
			pstmt.setString(11, dto.getRoadAddress());
			pstmt.setString(12, dto.getJibunAddress());
			pstmt.setString(13, dto.getDetailAddress());
			pstmt.setString(14, dto.getExtraAddress());
			result = pstmt.executeUpdate();
			
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
    //회원가입 기존아이디 확인
    public boolean ExIdOk(MemberDTO dto) {
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	boolean result = false;
    	try {
			pstmt = conn.prepareStatement(EXID_SQL); //"select * from "+TABLE_NAME;
			pstmt.setString(1,dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) { //기존 아이디가 있다
				result =true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rs, pstmt, conn);
			return result;
		}
    }
    // 회원정보 수정
    public boolean MemberModifyOk(MemberDTO dto,String id2) {
    	
    	Connection conn = getConnection();
    	PreparedStatement pstmt = null;
    	int result = 0;
    	boolean flage=false;
    	try {
			pstmt = conn.prepareStatement(UPDATE_SQL);
//"update "+TABLE_NAME+" set id=?,name=?, birthday=?,phone_first=?,phone_last=?,email=?,resident_first=?,resident_last=?,postCode=?,roadAdress=?,jibunAdress=?,detailAdress=?,extraAdress=? where id=?";
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getBirthday());
			pstmt.setString(4, dto.getPhone_first());
			pstmt.setString(5, dto.getPhone_last());
			pstmt.setString(6,dto.getEmail());
			pstmt.setString(7, dto.getResident_first());
			pstmt.setString(8,dto.getResident_last());
			pstmt.setInt(9, dto.getPostCode());
			pstmt.setString(10, dto.getRoadAddress());
			pstmt.setString(11, dto.getJibunAddress());
			pstmt.setString(12, dto.getDetailAddress());
			pstmt.setString(13, dto.getExtraAddress());
			pstmt.setString(14, id2);
			result = pstmt.executeUpdate();
			if(result>0) {
				flage=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt, conn);
			return flage;
		}
    }
}
