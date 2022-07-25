package Models;

import java.util.Date;

public class PhongBan_NhaCungCap {
	private PhongBan phongBan;
	private NhaCungCap nhaCungCap;
	private Date ngayLamViec;
	public PhongBan_NhaCungCap(PhongBan phongBan, NhaCungCap nhaCungCap, Date ngayLamViec) {
		super();
		this.phongBan = phongBan;
		this.nhaCungCap = nhaCungCap;
		this.ngayLamViec = ngayLamViec;
	}
	public PhongBan_NhaCungCap() {
		super();
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public Date getNgayLamViec() {
		return ngayLamViec;
	}
	public void setNgayLamViec(Date ngayLamViec) {
		this.ngayLamViec = ngayLamViec;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nhaCungCap == null) ? 0 : nhaCungCap.hashCode());
		result = prime * result + ((phongBan == null) ? 0 : phongBan.hashCode());
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
		PhongBan_NhaCungCap other = (PhongBan_NhaCungCap) obj;
		if (nhaCungCap == null) {
			if (other.nhaCungCap != null)
				return false;
		} else if (!nhaCungCap.equals(other.nhaCungCap))
			return false;
		if (phongBan == null) {
			if (other.phongBan != null)
				return false;
		} else if (!phongBan.equals(other.phongBan))
			return false;
		return true;
	}
	
	
}
