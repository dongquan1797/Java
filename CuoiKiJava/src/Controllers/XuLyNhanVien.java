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

import javax.swing.JOptionPane;

import Models.NhanVien;
import Models.PhongBan;
import Models.ThanNhan;
import utils.ConnectionManager;




public class XuLyNhanVien {
	private Connection con;
	public XuLyNhanVien(){
		con = ConnectionManager.getConnection();
	}
	//pthuc truy van tat ca nhan vien
	public ArrayList<NhanVien> findAll() {
		ArrayList<NhanVien> ds = new ArrayList<>();
		String sql = "select * from NHANVIEN";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			while(rs.next()){
				PhongBan pb = new PhongBan();
				pb.setMaPhongBan(rs.getString("MAPB"));
				String ngayvl = rs.getString("NGAYVAOLAM");
				java.util.Date dngayvl = sdf.parse(ngayvl);
				NhanVien nv = new NhanVien(rs.getInt("MANV"), rs.getString("HO"), rs.getString("TEN"), rs.getString("GIOITINH"), rs.getInt("SĐT"), dngayvl, rs.getString("CONGVIEC"), pb);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
	//tim pb
	public String findPB(String mapb) {
		String sql1 = "select * from PHONGBAN  where MAPB = '" + mapb+ "'"; 
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql1);
			while(rs.next()){
				
				return rs.getString(2);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//tim ds than nhan thuoc nhan vien da biet
		
  /* public ArrayList<ThanNhan> findThanNhanByID(int id){
		ArrayList<ThanNhan> ds = new ArrayList<>();
		String sql = "select * from THANNHAN where MANV=" +  id;
		//Integer.parseInt(id) 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				String ngaykh = rs.getString("DATEMARY");
				java.util.Date dngaykh = sdf.parse(ngaykh);
				NhanVien nv = new NhanVien();
				nv.setMaNV(rs.getInt("MANV"));
				ThanNhan tn = new ThanNhan(rs.getString("MATN"), rs.getString("MOIQUANHE"), dngaykh, nv);
				ds.add(tn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
    }	*/
	
	//xay dung pthuc them moi 1 nhan vien vao csdl
	public boolean insert(NhanVien nv){
		String sql = "insert into NHANVIEN values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap cac tham so
			pst.setInt(1, nv.getMaNV());
			pst.setString(2, nv.getHo());
			pst.setString(3, nv.getTen());
			pst.setString(4, nv.getGioiTinh());
			pst.setInt(5, nv.getSDT());
			//chuyen java.util.Date to java.sql.Date
			Date dayNVL = new Date(nv.getNgayVaoLam().getTime());
			pst.setDate(6, dayNVL);
			pst.setString(7, nv.getCongViec());
			pst.setString(8, nv.getPhongBan().getMaPhongBan());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ma nhan vien da ton tai");
			e.printStackTrace();
			return false;
		}
	}
	//pthuc cap nhap NHANVIEN
	public boolean update(NhanVien nv){
		String sql = "update NHANVIEN set ho=?, ten=?, gioiTinh=?, sđt=?, ngayvaolam=?, congviec=?, mapb=? where manv=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			
			pst.setString(1, nv.getHo());
			pst.setString(2, nv.getTen());
			pst.setString(3, nv.getGioiTinh());
			pst.setInt(4, nv.getSDT());
			//chuyen java.util.Date to java.sql.Date
			Date dayNVL = new Date(nv.getNgayVaoLam().getTime());
			pst.setDate(5, dayNVL);
			pst.setString(6, nv.getCongViec());
			pst.setString(7, nv.getPhongBan().getMaPhongBan());
			pst.setInt(8, nv.getMaNV());
			
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	//pthuc xoa NHANVIEN
	public void delete(NhanVien nv){
		String sql3 = "delete from TAIKHOAN where MANV=?";
		String sql2= "delete from THANNHAN where MANV=?";
		String sql1 = "delete from PHANCONG where MANV=?";
		String sql = "delete from NHANVIEN where MANV=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst1 = con.prepareStatement(sql1);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			PreparedStatement pst3 = con.prepareStatement(sql3);
			pst.setInt(1, nv.getMaNV());
			pst1.setInt(1, nv.getMaNV());
			pst2.setInt(1, nv.getMaNV());
			pst3.setInt(1, nv.getMaNV());
			pst3.execute();
			pst2.execute();
			pst1.execute();
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//pthuc tim kiem nhanvien
	public ArrayList<NhanVien> search(String chuoidk){
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		String sql = "select * from NHANVIEN where TEN like ? OR MAPB like ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+chuoidk+"%");
			pst.setString(2, "%"+chuoidk+"%");
				
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
				String ngay = rs.getString("NgayVaoLam");
				java.util.Date dngayvl = sdf.parse(ngay);
				PhongBan phong = new PhongBan();
				phong.setMaPhongBan(rs.getString("MAPB"));
				NhanVien nv = new NhanVien(rs.getInt("maNV"), rs.getString("ho"), rs.getString("ten"), rs.getString("gioiTinh"), rs.getInt("SĐT"), dngayvl, rs.getString("congViec"), phong);
				ds.add(nv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ds;
	}
}
