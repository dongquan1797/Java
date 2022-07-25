package Models;

import java.util.ArrayList;
import java.util.Date;

public class NhanVien {
	private int maNV;
	private String ho;
	private String ten;
	private String gioiTinh;
	private int SDT;
	private Date ngayVaoLam;
	private String congViec;
	private PhongBan phongBan;
	
	
	

	public NhanVien(int maNV, String ho, String ten, String gioiTinh, int sDT, Date ngayVaoLam, String congViec,
			PhongBan phongBan) {
		super();
		this.maNV = maNV;
		this.ho = ho;
		this.ten = ten;
		this.gioiTinh = gioiTinh;
		SDT = sDT;
		this.ngayVaoLam = ngayVaoLam;
		this.congViec = congViec;
		this.phongBan = phongBan;
	}

	public NhanVien() {
		super();
	}
	
		private ArrayList<KyNang> kyNangs = new ArrayList<KyNang>();
		
		public void add(KyNang kn){
			kyNangs.add(kn);
		}
		
		public void remove(KyNang kn) {
			kyNangs.remove(kn);
		}
		private ArrayList<ThanNhan> thanNhans = new ArrayList<ThanNhan>();
		
		public void add(ThanNhan tn) {
			thanNhans.add(tn);
		}
		
		public void remove(ThanNhan tn) {
			thanNhans.remove(tn);
		}
		
	public ArrayList<ThanNhan> getThanNhans() {
			return thanNhans;
		}
		public void setThanNhans(ArrayList<ThanNhan> thanNhans) {
			this.thanNhans = thanNhans;
		}
	public ArrayList<KyNang> getKyNangs() {
			return kyNangs;
		}
		public void setKyNangs(ArrayList<KyNang> kyNangs) {
			this.kyNangs = kyNangs;
		}
	
	public int getMaNV() {
			return maNV;
		}

		public void setMaNV(int maNV) {
			this.maNV = maNV;
		}

	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	
	public int getSDT() {
		return SDT;
	}
	public void setSDT(int sDT) {
		SDT = sDT;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getCongViec() {
		return congViec;
	}
	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	
	@Override
	public String toString() {
		return ho + " " + ten ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maNV;
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
		NhanVien other = (NhanVien) obj;
		if (maNV != other.maNV)
			return false;
		return true;
	}

	

	
	
	
}
