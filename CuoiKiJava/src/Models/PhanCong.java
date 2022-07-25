package Models;

public class PhanCong {
	private NhanVien nhanVien;
	private DuAn duAn;
	private KyNang kyNang;
	public PhanCong(NhanVien nhanVien, DuAn duAn, KyNang kyNang) {
		super();
		this.nhanVien = nhanVien;
		this.duAn = duAn;
		this.kyNang = kyNang;
	}
	public PhanCong() {
		super();
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public DuAn getDuAn() {
		return duAn;
	}
	public void setDuAn(DuAn duAn) {
		this.duAn = duAn;
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
		result = prime * result + ((duAn == null) ? 0 : duAn.hashCode());
		result = prime * result + ((kyNang == null) ? 0 : kyNang.hashCode());
		result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
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
		PhanCong other = (PhanCong) obj;
		if (duAn == null) {
			if (other.duAn != null)
				return false;
		} else if (!duAn.equals(other.duAn))
			return false;
		if (kyNang == null) {
			if (other.kyNang != null)
				return false;
		} else if (!kyNang.equals(other.kyNang))
			return false;
		if (nhanVien == null) {
			if (other.nhanVien != null)
				return false;
		} else if (!nhanVien.equals(other.nhanVien))
			return false;
		return true;
	}

	
	
	
}
