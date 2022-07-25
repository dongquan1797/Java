package Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Models.KyNang;
import Models.NhaCungCap;
import Models.PhongBan;
import Models.PhongBan_NhaCungCap;

import utils.ConnectionManager;




public class XuLyPhongBan_NhaCungCap {
	Connection con = ConnectionManager.getConnection();
	//xay dung phuong thuc truy van tat ca cac phong ban
	public ArrayList<PhongBan_NhaCungCap> findAll(){
		ArrayList<PhongBan_NhaCungCap> dspb_ncc = new ArrayList<>();
		String sql = "select * from PHONGBAN_NCC";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				PhongBan pb = new PhongBan();
				NhaCungCap ncc = new NhaCungCap();
				pb.setMaPhongBan(rs.getString("MAPB"));
				ncc.setMaNhaCungCap(rs.getString("MANCC"));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date ngaylv = sdf.parse(rs.getString("NgayLamViec"));
				PhongBan_NhaCungCap pb_ncc = new PhongBan_NhaCungCap(pb, ncc, ngaylv);
				dspb_ncc.add(pb_ncc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dspb_ncc;
	}
	//
	public void insert(PhongBan_NhaCungCap pb_ncc){
		String sql = "insert into PHONGBAN_NCC values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pb_ncc.getPhongBan().getMaPhongBan());
			pst.setString(2, pb_ncc.getNhaCungCap().getMaNhaCungCap());
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date ngaylv = new java.sql.Date(pb_ncc.getNgayLamViec().getTime());
			pst.setDate(3, ngaylv);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//
	public boolean update(PhongBan_NhaCungCap pb_ncc){
		String sql = "update PHONGBAN_NCC set NGAYLAMVIEC='?' where MAPB='?', MANCC='?'";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			
			java.sql.Date ngaylv = new java.sql.Date(pb_ncc.getNgayLamViec().getTime());
			pst.setDate(1, ngaylv);
			pst.setString(2, pb_ncc.getPhongBan().getMaPhongBan());
			pst.setString(3, pb_ncc.getNhaCungCap().getMaNhaCungCap());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//
	public void delete(PhongBan_NhaCungCap pb_ncc){
		String sql = "delete from PHONGBAN_NCC where MAPB=? OR MANCC=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, pb_ncc.getPhongBan().getMaPhongBan());
			pst.setString(2, pb_ncc.getNhaCungCap().getMaNhaCungCap());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
