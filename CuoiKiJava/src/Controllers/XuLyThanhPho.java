package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import Models.DuAn;
import Models.KyNang;
import Models.ThanhPho;
import utils.ConnectionManager;


public class XuLyThanhPho {
private Connection con;
	
	public XuLyThanhPho(){
		con = ConnectionManager.getConnection();
	}
	//xay dung phuong thuc truy van tat ca cac thanh pho
	public ArrayList<ThanhPho> findAll(){
		ArrayList<ThanhPho> dstp = new ArrayList<>();
		String sql = "select * from THANHPHO";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				ThanhPho tp = new ThanhPho(rs.getString("MATP"), rs.getString("TENTP"), rs.getString("TIEUBANG"), rs.getInt("DANSO"));
				dstp.add(tp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
			//e.printStackTrace();
		}
		return dstp;
	}
	//tim ds du an thuoc thanh pho da biet
	public ArrayList<DuAn> findDuAnByID(String id){
		ArrayList<DuAn> ds = new ArrayList<>();
		String sql = "select * from DUAN where MATP=" + id; //id cua tp
		try {
			Statement stm = con.createStatement();
			ResultSet rs =stm.executeQuery(sql);
			while(rs.next()){
				ThanhPho tp = new ThanhPho();
				KyNang kn = new KyNang();
				tp.setMaTP(rs.getString("MATP"));
				kn.setMaKyNang(rs.getString("MAKN"));
				DuAn da = new DuAn(rs.getString("MADUAN"), rs.getString("TENDUAN"), rs.getInt("KINHPHI"), tp, kn);
				ds.add(da);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return null;
		} 
		return ds;
	}
	//them 1 thanh pho
	public boolean insert(ThanhPho tp) {
		String sql = "insert into THANHPHO(MATP, TENTP, TIEUBANG, DANSO) values (?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap tham so
			pst.setString(1, tp.getMaTP());
			pst.setString(2, tp.getTenTP());
			pst.setString(3, tp.getTieuBang());
			pst.setInt(4, tp.getDanSo());
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Thanh pho da ton tai");
			e.printStackTrace();
			return false;
		}
	}
	//cap nhat 1 thanh pho
	public boolean update(ThanhPho tp) {
		String sql = "update THANHPHO set TENTP =?, TIEUBANG =?, DANSO =? where MATP= ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, tp.getTenTP());
			pst.setString(2, tp.getTieuBang());
			pst.setInt(3, tp.getDanSo());
			pst.setInt(4,  Integer.valueOf(tp.getMaTP()));	
			pst.execute();
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//xoa 1 thanh pho
	public void delete(ThanhPho tp){
		//xoa cac dau sach thuoc loai sach nay
		String sql = "delete from DUAN where MATP=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, tp.getMaTP());
			pst.execute();
			//xoa thanh pho
			sql = "delete from THANHPHO where MATP=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, tp.getMaTP());
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
