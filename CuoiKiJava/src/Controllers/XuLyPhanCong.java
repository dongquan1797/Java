package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.DuAn;
import Models.KyNang;
import Models.NhanVien;
import Models.PhanCong;
import utils.ConnectionManager;

public class XuLyPhanCong {
	private Connection con;
	public XuLyPhanCong(){
		con = ConnectionManager.getConnection();
	}
	//xay dung phuong thuc truy van tata ca cac phan cong
	public ArrayList<PhanCong> findAll(){
		ArrayList<PhanCong> ds = new ArrayList<>();
		String sql = "select * from PHANCONG";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				NhanVien nv = new NhanVien();
				DuAn da = new DuAn();
				KyNang kn = new KyNang();
				nv.setMaNV(rs.getInt("MANV"));
				kn.setMaKyNang(rs.getString("MAKN"));
				da.setMaDuAn(rs.getString("MADUAN"));
				PhanCong pc = new PhanCong(nv, da, kn);
				ds.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	//them moi 1 pc vao csdl
	public boolean insert(PhanCong pc) {
		String sql ="insert into PHANCONG values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap tham so
			pst.setInt(1, pc.getNhanVien().getMaNV());
			pst.setString(2, pc.getDuAn().getMaDuAn());
			pst.setString(3, pc.getKyNang().getMaKyNang());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ma dự án đã ton tai");
			e.printStackTrace();
			
		}
		return false;
	}
	//cap nhat
	public boolean update(PhanCong pc){
		String sql = "update PHANCONG set MADUAN=?, MAKN=? where MANV=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			pst.setString(1, pc.getDuAn().getMaDuAn());
			pst.setString(2, pc.getKyNang().getMaKyNang());
			pst.setInt(3, pc.getNhanVien().getMaNV());
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	//xoa
	public void delete(PhanCong pc){
		String sql = "delete from PHANCONG where MANV=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//set tham so
			pst.setInt(1, pc.getNhanVien().getMaNV());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//phuong thuc tim kiem phan cong
	public ArrayList<PhanCong> search(String chuoidk){
		ArrayList<PhanCong> ds = new ArrayList<PhanCong>();
		String sql = "select * from PHANCONG where MANV = ? or MADUAN like ? or MAKN like ?";
		int ma = 0;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			try {
				ma = Integer.parseInt(chuoidk);
			} catch (Exception e) {
				// TODO: handle exception
				ma = 0;
			}
			pst.setInt(1, ma);
			pst.setString(2, "%" + chuoidk + "%");
			pst.setString(3, "%" + chuoidk + "%");
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				NhanVien nv = new NhanVien();
                DuAn da = new DuAn();
				KyNang kn = new KyNang();
				nv.setMaNV(rs.getInt("MANV"));
				kn.setMaKyNang(rs.getString("MAKN"));
				da.setMaDuAn(rs.getString("MADUAN"));
				PhanCong pc = new PhanCong(nv, da, kn);
				ds.add(pc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	
}