package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1035;databaseName=QuanLyNhanSu;useUnicode=true;characterEncoding=UTF-8";
	private static String user = "sa";
	private static String password = "sa";
	
	//khoi tao ban dau
	private static Connection connect = null;
	
	private static void makeConnection(){
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if(connect==null){
			makeConnection();
		}
		return connect;
	}

}
