package Models;

import java.util.ArrayList;



public class NhaCungCap {
	private String maNhaCungCap;
	private String tenNhaCungCap;
	private String diaChi;
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
	}
	public NhaCungCap() {
		super();
	}
	
		private ArrayList<PhongBan> phongBans = new ArrayList<PhongBan>();
		
		public void add(PhongBan pb){
			phongBans.add(pb);
		}
		
		public void remove(PhongBan pb) {
			phongBans.remove(pb);
		}
		
	public ArrayList<PhongBan> getPhongBans() {
			return phongBans;
		}
		public void setPhongBans(ArrayList<PhongBan> phongBans) {
			this.phongBans = phongBans;
		}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}
	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhaCungCap == null) ? 0 : maNhaCungCap.hashCode());
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
		NhaCungCap other = (NhaCungCap) obj;
		if (maNhaCungCap == null) {
			if (other.maNhaCungCap != null)
				return false;
		} else if (!maNhaCungCap.equals(other.maNhaCungCap))
			return false;
		return true;
	}
	
	
}
