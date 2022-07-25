package Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.ThanNhan;
import utils.ConnectionManager;




public class XuLyThanNhan {
	private Connection con;
	public XuLyThanNhan(){
		
		con = ConnectionManager.getConnection();
	}
	//xay dung pthuc them than nhan vao csdl
	public boolean insert(ThanNhan tn){
		String sql = "insert into THANNHAN values(?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap cac tham so		
			pst.setString(1, tn.getMaThanNhan());
			pst.setString(2, tn.getMoiQuanHe());
			//chuyen java.util.Date to java.sql.Date
			Date dayMary = new Date(tn.getDateMary().getTime());
			pst.setDate(3, dayMary);
			pst.setInt(4, tn.getNhanVien().getMaNV());
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//pthuc cap nhap than nhan
	public boolean update(ThanNhan tn){
		String sql = "update THANNHAN set MOIQUANHE=?, DATEMARY=?, MANV=? where MATN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			
			pst.setString(1, tn.getMoiQuanHe());
			//chuyen java.util.Date to java.sql.Date
			Date dayMary = new Date(tn.getDateMary().getTime());
			pst.setDate(2, dayMary);
			pst.setInt(3, tn.getNhanVien().getMaNV());
			pst.setString(4, tn.getMaThanNhan());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//pthuc xoa than nhan
	public void delete(ThanNhan tn){
		String sql = "delete from THANNHAN where MATN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tn.getMaThanNhan());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
