package Models;

import java.util.ArrayList;


public class PhongBan {
	private String maPhongBan;
	private String tenPhongBan;
	private int SDTPhongBan;
	private NhaCungCap ncc;
	private KyNang kyNang;
	 
	
	public PhongBan(String maPhongBan, String tenPhongBan, int sDTPhongBan, NhaCungCap ncc, KyNang kyNang) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		SDTPhongBan = sDTPhongBan;
		this.ncc = ncc;
		this.kyNang = kyNang;
	}
	public PhongBan() {
		super();
	}
	private ArrayList<PhongBan_NhaCungCap> phongBan_NhaCungCapS = new ArrayList<PhongBan_NhaCungCap>();
	
	public ArrayList<PhongBan_NhaCungCap> getPhongBan_NhaCungCapS() {
		return phongBan_NhaCungCapS;
	}
	public void setPhongBan_NhaCungCapS(ArrayList<PhongBan_NhaCungCap> phongBan_NhaCungCapS) {
		this.phongBan_NhaCungCapS = phongBan_NhaCungCapS;
	}
	public void add(PhongBan_NhaCungCap pb){
		phongBan_NhaCungCapS.add(pb);
	}
	
	public void remove(PhongBan_NhaCungCap pb) {
		phongBan_NhaCungCapS.remove(pb);
	}
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public int getSDTPhongBan() {
		return SDTPhongBan;
	}
	public void setSDTPhongBan(int sDTPhongBan) {
		SDTPhongBan = sDTPhongBan;
	}
	
	public NhaCungCap getNcc() {
		return ncc;
	}
	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}
	public KyNang getKyNang() {
		return kyNang;
	}
	public void setKyNang(KyNang kyNang) {
		this.kyNang = kyNang;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhongBan == null) ? 0 : maPhongBan.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongBan other = (PhongBan) obj;
		if (maPhongBan == null) {
			if (other.maPhongBan != null)
				return false;
		} else if (!maPhongBan.equals(other.maPhongBan))
			return false;
		return true;
	}
	
	
	
}
