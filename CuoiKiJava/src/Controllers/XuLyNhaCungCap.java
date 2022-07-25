package Controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Models.NhaCungCap;
import utils.ConnectionManager;


public class XuLyNhaCungCap {
	Connection con = ConnectionManager.getConnection();
	
	//tim hoa doan cuoi cung(hoa don moi nhat)
	public NhaCungCap findNCC_Last(){
		String sql = "select top 1 * from NHACUNGCAP order by MANCC DESC";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				NhaCungCap ncc =new NhaCungCap(rs.getString("MANCC"), rs.getString("TENNCC"), rs.getString("DIACHI"));
				//JOptionPane.showMessageDialog(null, h.getMaHD());
				return ncc;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//return null;
		}
		return null;
	}
	public String taoMaNhaCungCap() {
		String ma = null;
		//lay ma ncc sau cung
		NhaCungCap ncc = findNCC_Last();
		if(ncc==null)
			ma="HD01";
		else
		{
			ma = ncc.getMaNhaCungCap().substring(2);
			//chuyen thanh so
			int soncc = Integer.parseInt(ma)+1;
			//chuyen so thanh chuoi co dinh dang, %d la so nguyen, %02d la tu 0 - 98
			ma = "HD" + String.format("%02d", soncc);
		}
		return ma;
	}
	
		//insert
		public void insert(NhaCungCap ncc){
		String sql = "insert into NHACUNGCAP values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ncc.getMaNhaCungCap());
			pst.setString(2, ncc.getTenNhaCungCap());
			pst.setString(3, ncc.getDiaChi());
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
