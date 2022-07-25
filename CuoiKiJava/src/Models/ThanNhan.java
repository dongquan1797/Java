package Models;

import java.util.Date;

public class ThanNhan {
	private String maThanNhan;
	private String moiQuanHe;
	private Date dateMary;
	private NhanVien nhanVien;
	public ThanNhan(String maThanNhan, String moiQuanHe, Date dateMary, NhanVien nhanVien) {
		super();
		this.maThanNhan = maThanNhan;
		this.moiQuanHe = moiQuanHe;
		this.dateMary = dateMary;
		this.nhanVien = nhanVien;
	}
	public ThanNhan() {
		super();
	}
	public String getMaThanNhan() {
		return maThanNhan;
	}
	public void setMaThanNhan(String maThanNhan) {
		this.maThanNhan = maThanNhan;
	}
	public String getMoiQuanHe() {
		return moiQuanHe;
	}
	public void setMoiQuanHe(String moiQuanHe) {
		this.moiQuanHe = moiQuanHe;
	}
	public Date getDateMary() {
		return dateMary;
	}
	public void setDateMary(Date dateMary) {
		this.dateMary = dateMary;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maThanNhan == null) ? 0 : maThanNhan.hashCode());
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
		ThanNhan other = (ThanNhan) obj;
		if (maThanNhan == null) {
			if (other.maThanNhan != null)
				return false;
		} else if (!maThanNhan.equals(other.maThanNhan))
			return false;
		return true;
	}
	
	
}
