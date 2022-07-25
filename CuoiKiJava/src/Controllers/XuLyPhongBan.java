package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.KyNang;
import Models.NhaCungCap;
import Models.PhongBan;
import utils.ConnectionManager;


public class XuLyPhongBan {
	private Connection con;
	public XuLyPhongBan() {
		// TODO Auto-generated constructor stub
		con = ConnectionManager.getConnection();
	}
	//xay dung phuong thuc truy van tat ca cac phong ban
		public ArrayList<PhongBan> findAll(){
			ArrayList<PhongBan> dspb = new ArrayList<>();
			String sql = "select * from PHONGBAN";
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					KyNang kyNang = new KyNang();
					NhaCungCap ncc = new NhaCungCap();
					ncc.setMaNhaCungCap(rs.getString("MANCC"));
					kyNang.setMaKyNang(rs.getString("MAKN"));
					PhongBan phongBan = new PhongBan(rs.getString("MAPB"), rs.getString("TENPB"), rs.getInt("SĐT"), ncc,kyNang);
					dspb.add(phongBan);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dspb;
		}

	//xay dung pthuc them moi 1 sp vao csdl
		public boolean insert(PhongBan pb){
			String sql = "insert into PHONGBAN values(?,?,?,?,?)";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				//thiet lap cac tham so
				pst.setString(1, pb.getMaPhongBan());
				pst.setString(2, pb.getTenPhongBan());
				pst.setInt(3, pb.getSDTPhongBan());
				pst.setString(4, pb.getNcc().getMaNhaCungCap());
				pst.setString(5, pb.getKyNang().getMaKyNang());
			
			
				boolean kq = pst.execute();
				return kq;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Ma phong ban da ton tai");
				e.printStackTrace();
				return false;
			}
		}
		//pthuc cap nhap sp
		public boolean update(PhongBan pb){
			String sql = "update PHONGBAN set TENPB=?, SĐT=?, MANCC=?,MAKN=? where MAPB=?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				//thiet lap gia tri tham so
				
				pst.setString(1, pb.getTenPhongBan());
				pst.setInt(2, pb.getSDTPhongBan());
				pst.setString(3, pb.getNcc().getMaNhaCungCap());
				pst.setString(4, pb.getKyNang().getMaKyNang());
				pst.setString(5, pb.getMaPhongBan());
				
				boolean kq = pst.execute();
				return kq;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}

		//pthuc xoa pb
		public void delete(PhongBan pb){
			String sql1 = "delete from NHANVIEN where MAPB=?";
			String sql = "delete from PHONGBAN where MAPB=?";
			try {
				PreparedStatement pst1 = con.prepareStatement(sql1);
				PreparedStatement pst = con.prepareStatement(sql);
				pst1.setString(1, pb.getMaPhongBan());
				pst.setString(1, pb.getMaPhongBan());
				pst1.execute();
				pst.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//pthuc tim kiem phongban
		public ArrayList<PhongBan> search(String chuoidk){
			ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
			String sql = "select * from PHONGBAN where MAPB LIKE ? or TENPB like ?";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, "%"+chuoidk+"%");
				pst.setString(2, "%"+chuoidk+"%");	
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
					KyNang kynang = new KyNang();
					NhaCungCap ncc= new NhaCungCap();
					ncc.setMaNhaCungCap(rs.getString("MANCC"));
					kynang.setMaKyNang(rs.getString("MAKN"));
					PhongBan phongBan = new PhongBan(rs.getString("MAPB"), rs.getString("TENPB"), rs.getInt("SDT"), ncc, kynang);
					phongBan.setMaPhongBan(rs.getString("MAPB"));
					dspb.add(phongBan);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return dspb;
		}
	//tim pb theo ma or ten
		public ArrayList<PhongBan> findByCriteria(String str) {
			String sql = "select * from PHONGBAN where MAPB like ? or TENPB like ?";
			ArrayList<PhongBan> dspb = new ArrayList<PhongBan>();
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, "%" + str + "%");
				pst.setString(2, "%" + str + "%");
				ResultSet rs = pst.executeQuery();
				while(rs.next()){
					KyNang kynang = new KyNang();
					NhaCungCap ncc= new NhaCungCap();
					PhongBan p =new PhongBan(rs.getString("MAPB"), rs.getString("TENPB"), rs.getInt("SDT"), ncc, kynang);
					dspb.add(p);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dspb;
		}
}
