package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.customerconn;
import connection.dbconnection;
import model.Seller;

public class sellerdao {

	public static void insertseller(Seller s) {
		try {
			Connection conn = dbconnection.createConnection();
			String sql = "insert into seller_regs (yourname,email,phone,Passwords) values(?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getyourname());
			pst.setString(2, s.getemail());
			pst.setLong(3, s.getphone());
			pst.setString(4, s.getPasswords());
			pst.executeUpdate();
			System.out.println("data inserted");
		} 
		 catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Seller loginseller (Seller s) {
		Seller s1 = null;
		try {
			Connection conn = dbconnection.createConnection();
			String sql = "select * from seller_regs where email=? and Passwords=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, s.getemail());
			pst.setString(2, s.getPasswords());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				s1 = new Seller();
				s1.setID(rs.getInt("ID"));
				s1.setName(rs.getString("yourname"));
				s1.setemail(rs.getString("email"));
				s1.setPasswords(rs.getString("Passwords"));
				s1.setphone(rs.getLong("phone"));
				           }
			
		  } 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return s1;
		
	}
	public static void updateseller(Seller s) {
		try {
			Connection conn = dbconnection.createConnection();
			String sql="update seller_regs set yourname=?,phone=?, email=? where ID=?";
			PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, s.getyourname());
	        pst.setLong(2, s.getphone());
	        pst.setString(3, s.getemail());
	        pst.setInt(4, s.getID());
	        pst.executeUpdate();
			System.out.println("data updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updatepassword(String email ,String np ) {
		try {
			Connection conn = customerconn.createConnection();
			String sql = "update seller_regs set Passwords=? where email=? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, np);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("pass updated");
			}
		catch ( Exception e ) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkPassword(String email,String Passwords) {
		boolean flag = false;
		try {
			Connection conn = dbconnection.createConnection();
			String sql="select * from seller_regs where email=? and Passwords=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, Passwords);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean checkEmail(String email) {
		boolean flag = false;
		try {
			Connection conn = customerconn.createConnection();
			String sql="select * from seller_regs where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	 
}
