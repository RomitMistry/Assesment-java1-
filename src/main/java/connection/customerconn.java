package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class customerconn {

		public static Connection createConnection() {
			Connection conn = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoe_shoppingdata","root","");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
		}
}
