package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import connection.customerconn;
import model.customermodel;

public class customerdao {

		public static void insertcustomer(customermodel c) {
			try {
				Connection conn = customerconn.createConnection();
				String sql="insert into customer_regs(yourname,phone,email,Passwords) values(?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, c.getYourname());
				pst.setLong(2, c.getPhone());
				pst.setString(3, c.getEmail());
				pst.setString(4, c.getPasswords());
				pst.executeUpdate();
				System.out.println("data inserted");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static customermodel logincustomer(customermodel c) {
			customermodel c1 = null;
			try {
				Connection conn = customerconn.createConnection();
				String sql = "select * from customer_regs where email=? and Passwords=?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, c.getEmail());
				pst.setString(2, c.getPasswords());
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					c1 = new customermodel();
					c1.setID(rs.getInt("ID"));
					c1.setEmail(rs.getString("email"));
					c1.setPasswords(rs.getString("Passwords"));
					c1.setPhone(rs.getLong("phone"));
					c1.setYourname(rs.getString("yourname"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return c1;
		}
		
		public static void updatecustomer(customermodel c) {
			try {
				Connection conn = customerconn.createConnection();
				String sql="update customer_regs set yourname=?,phone=?, email=? where ID=?";
				PreparedStatement pst = conn.prepareStatement(sql);
		        pst.setString(1, c.getYourname());
		        pst.setLong(2, c.getPhone());
		        pst.setString(3, c.getEmail());
		        pst.setInt(4, c.getID());
		        pst.executeUpdate();
				System.out.println("data updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static void updatepassword(String email ,String np ) {
			try {
				Connection conn = customerconn.createConnection();
				String sql = "update customer_regs set Passwords=? where email=? ";
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
				Connection conn = customerconn.createConnection();
				String sql="select * from customer_regs where email=? and Passwords=?";
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
				String sql="select * from customer_regs where email=?";
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
