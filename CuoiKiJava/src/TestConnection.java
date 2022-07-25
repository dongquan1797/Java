import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url = "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1035;databaseName=QuanLyNhanSu;useUnicode=true;characterEncoding=UTF-8";
		String user = "sa";
		String password = "sa";
		
		try {
			Class.forName(driver);
			Connection connect = DriverManager.getConnection(url, user, password);
			System.out.println("Su ca na");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
