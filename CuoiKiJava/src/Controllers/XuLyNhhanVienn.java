package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionManager;

public class XuLyNhhanVienn {
	Connection con = ConnectionManager.getConnection();
	
	//kt tai khoan
	public boolean kienTraTaiKhoan(String u, String pw) {
		String sql = "select * from nhanvien where manv=? and password=?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, u);
			pst.setString(2, pw);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				return true;
			} else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
