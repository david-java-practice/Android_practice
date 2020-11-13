package db.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QueryBean {
	Connection conn; // ¿¬°á °´Ã¼
	Statement stmt; // ÁúÀÇ °´Ã¼
	ResultSet rs;  // °á°ú °´Ã¼
	
	public QueryBean() {
		conn = null;
		stmt = null;
		rs = null;
	}
	public void getConnection() {
		try {
			conn = DBConnection.getConnection();
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			stmt = conn.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
		if (stmt != null) {
			try {
				stmt.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public ArrayList getNumberInfo(String num1) throws Exception	{
		StringBuffer sb = new StringBuffer();
		
		sb.append(" SELECT ");
		sb.append(" NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, WRITETIME");
		sb.append(" FROM ");
		sb.append(" LOTTERY_NUMBER ");
		
		rs = stmt.executeQuery(sb.toString());
		
		ArrayList res = new ArrayList();
		while (rs.next()) {
			res.add(rs.getString(1));
			res.add(rs.getString(2));
			res.add(rs.getString(3));
			res.add(rs.getString(4));
			res.add(rs.getString(5));
			res.add(rs.getString(6));
			res.add(rs.getString(7));
		}
		System.out.println(sb.toString());
		return res;
	}
	

	
	public int setNumberInfo(String num1, String num2, String num3, String num4, String num5, String num6, String writeTime) {
		int result = 0;
		
		StringBuffer sb = new StringBuffer();
		PreparedStatement pstmt = null;
		
		sb.append(" INSERT INTO ");
		sb.append(" LOTTERY_NUMBER (NUM1, NUM2, NUM3, NUM4, NUM5, NUM6, WRITETIME) ");
		sb.append(" VALUES ");
//		sb.append(" (?,?,?,?, sysdate)");
		sb.append(" ("+num1+", "+num2+", "+num3+", "+ num4+", "+ num5+","+ num6+", sysdate)");
		
		System.out.println(sb.toString());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.clearParameters();
//			pstmt.setString(1, id);
//			pstmt.setString(2,  name);
//			pstmt.setString(3, phone);
//			pstmt.setString(4, grade);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return result;
		
	}
	public int deleteNumberInfo(String num1) throws Exception {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" DELETE ");
		sb.append(" FROM ");
		sb.append(" LOTTERY_NUMBER ");
		sb.append(" WHERE ");
		sb.append(" NUM1 = ? ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.clearParameters();
			pstmt.setString(1,  num1);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
//	public int updateUserInfo(String id, String name, String phone, String grade) throws Exception {
//
//		StringBuffer sb = new StringBuffer();
//		PreparedStatement pstmt = null;
//		
//		int result = 0;
//
//		sb.append(" UPDATE "); 
//		sb.append("							USER_INFO_SAMPLE "); 
//		sb.append(" SET ");
//		sb.append("						U_NAME = ?,  U_PHONE=?,  U_GRADE=?,  WRITE_TIME=sysdate "); 
//		sb.append(" WHERE ");
//		sb.append("					U_ID = ? ");
//
//
//		System.out.println(sb.toString());
//		
//		pstmt = conn.prepareStatement(sb.toString());
//		pstmt.clearParameters();
//		pstmt.setString(1,  name);
//		pstmt.setString(2,  phone);
//		pstmt.setString(3,  grade);
//		pstmt.setString(4,  id);
//		
////		rs = stmt.executeQuery(sb.toString());
//		
//		result = pstmt.executeUpdate();
//		
//		return result;
//	}
	
}
