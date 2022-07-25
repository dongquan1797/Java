package Models;

import java.util.ArrayList;


public class KyNang {
	private String maKyNang;
	private String tenKynang;
	private String chuThich;
	
	public KyNang(String maKyNang, String tenKynang, String chuThich) {
		super();
		this.maKyNang = maKyNang;
		this.tenKynang = tenKynang;
		this.chuThich = chuThich;
	}
	public KyNang() {
		super();
	}
	
	//mot nhan vien co nhieu ky nang
		private ArrayList<PhongBan> phongBans = new ArrayList<PhongBan>();
		//them 1 ky nang vao danh sach
		public void add(PhongBan kn){
			phongBans.add(kn);
		}
		//xoa 1ky nang ra khoi danh sach
		public void remove(PhongBan kn) {
			phongBans.remove(kn);
		}
	
	public ArrayList<PhongBan> getPhongBans() {
			return phongBans;
		}
		public void setPhongBans(ArrayList<PhongBan> phongBans) {
			this.phongBans = phongBans;
		}
	public String getMaKyNang() {
		return maKyNang;
	}
	public void setMaKyNang(String maKyNang) {
		this.maKyNang = maKyNang;
	}
	public String getTenKynang() {
		return tenKynang;
	}
	public void setTenKynang(String tenKynang) {
		this.tenKynang = tenKynang;
	}
	public String getChuThich() {
		return chuThich;
	}
	public void setChuThich(String chuThich) {
		this.chuThich = chuThich;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKyNang == null) ? 0 : maKyNang.hashCode());
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
		KyNang other = (KyNang) obj;
		if (maKyNang == null) {
			if (other.maKyNang != null)
				return false;
		} else if (!maKyNang.equals(other.maKyNang))
			return false;
		return true;
	}

	
	
}
