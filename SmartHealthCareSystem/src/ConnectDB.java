import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;


public class ConnectDB {
	private static String url = "jdbc:mysql://localhost:3306/shs";
	private static String username = "root";
	private static String password = "";
	private static Connection con;
		
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				con = DriverManager.getConnection(url, username, password);	
			} catch(Exception e) {
				System.out.println(e);
			}
		} catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return con;
	}
}
