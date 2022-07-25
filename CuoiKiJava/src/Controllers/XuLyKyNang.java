package Controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Models.KyNang;
import utils.ConnectionManager;

public class XuLyKyNang {
	private Connection con;
	public XuLyKyNang(){
		con = ConnectionManager.getConnection();
	}
	//xay dung phuong thuc truy van tat ca cac kn
			public ArrayList<KyNang> findAll(){
				ArrayList<KyNang> ds = new ArrayList<>();
				String sql = "select * from KYNANG";
				try {
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery(sql);
					while(rs.next()){
						KyNang kn = new KyNang(rs.getString("MAKN"), rs.getString("TENKN"), rs.getString("CHUTHICH"));
						
						ds.add(kn);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ds;
			}
	//them moi 1 ky nang vao csdl
	public boolean insert(KyNang kn){
		String sql = "insert into KYNANG values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap cac tham so
			pst.setString(1, kn.getMaKyNang());
			pst.setString(2, kn.getTenKynang());
			pst.setString(3, kn.getChuThich());
			
			boolean kq= pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Ma ky nang da ton tai");
			e.printStackTrace();
		return false;
		}
	}
	//cap nhat 
	public boolean update(KyNang kn){
		String sql = "update KYNANG set TENKN=?, CHUTHICH=? where MAKN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//thiet lap gia tri tham so
			
			pst.setString(1, kn.getTenKynang());
			pst.setString(2, kn.getChuThich());
			pst.setString(3, kn.getMaKyNang());
		
			boolean kq = pst.execute();
			return kq;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void delete(KyNang kn){
		/*String sql4 = "delete from PHONGBAN_NCC where MAKN=?";*/
		String sql3 = "delete from DUAN where MAKN=?";
		String sql2 = "delete from PHANCONG where MAKN=?";
		String sql1 = "delete from PHONGBAN where MAKN=?";
		String sql = "delete from KYNANG where MAKN=?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			PreparedStatement pst1 = con.prepareStatement(sql1);
			PreparedStatement pst2 = con.prepareStatement(sql2);
			PreparedStatement pst3 = con.prepareStatement(sql3);
			pst.setString(1, kn.getMaKyNang());
			pst1.setString(1, kn.getMaKyNang());
			pst2.setString(1, kn.getMaKyNang());
			pst3.setString(1, kn.getMaKyNang());
			pst3.execute();
			pst2.execute();
			pst1.execute();
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//pthuc tim kiem kn
	public ArrayList<KyNang> search(String chuoidk){
		ArrayList<KyNang> ds = new ArrayList<KyNang>();
		String sql = "select * from KYNANG where MAKN like ? or TENKN like ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+chuoidk+"%");
			pst.setString(2, "%"+chuoidk+"%");	
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
			
				
				KyNang kynang = new KyNang(rs.getString("MAKN"), rs.getString("TENKN"), rs.getString("CHUTHICH"));

				ds.add(kynang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ds;
	}

}