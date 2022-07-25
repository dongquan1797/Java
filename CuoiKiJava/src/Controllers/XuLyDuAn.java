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

import Models.DuAn;
import Models.KyNang;
import Models.ThanhPho;
import utils.ConnectionManager;



public class XuLyDuAn {
	private Connection con;
	public XuLyDuAn(){
		con = ConnectionManager.getConnection();
		
	}
	//xay dung pthuc them moi 1 du an vao csdl
	public boolean insert(DuAn da){
		String sql = "insert into DUAN values(?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap cac tham so
			pst.setString(1, da.getMaDuAn());
			pst.setString(2, da.getTenDuAn());
			pst.setInt(3, da.getKinhPhi());
			pst.setString(4, da.getThanhPho().getMaTP());
			pst.setString(5, da.getKyNang().getMaKyNang());
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//pthuc cap nhap du an
	public boolean update(DuAn da){
		String sql = "update DUAN set TENDUAN=?, KINHPHI=?, MATP=?, MAKN=? where MADUAN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			
			pst.setString(1, da.getTenDuAn());
			pst.setFloat(2, Float.valueOf(da.getKinhPhi()));
			pst.setString(3, da.getThanhPho().getMaTP());
			pst.setString(4, da.getKyNang().getMaKyNang());
			pst.setString(5, da.getMaDuAn());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//pthuc xoa du an
	public void delete(DuAn da){
		String sql1 = "delete from PHANCONG where MADUAN=?";
		String sql = "delete from DUAN where MADUAN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst1 = con.prepareStatement(sql1);
			pst.setString(1, da.getMaDuAn());
			pst1.setString(1, da.getMaDuAn());
			pst1.execute();
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//pthuc tim kiem duan
	public ArrayList<DuAn> search(String chuoidk){
		ArrayList<DuAn> ds = new ArrayList<DuAn>();
		String sql = "select * from DUAN where MATP like ? OR MADUAN like ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+chuoidk+"%");
			pst.setString(2, "%"+chuoidk+"%");	
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				ThanhPho thanhPho = new ThanhPho();
				KyNang kyNang = new KyNang();
				DuAn da = new DuAn(rs.getString("maDuAn"), rs.getString("tenDuAn"), rs.getInt("kinhPhi"), thanhPho, kyNang);
				ds.add(da);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ds;
	}
}