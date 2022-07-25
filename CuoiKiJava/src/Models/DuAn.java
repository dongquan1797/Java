package Models;

public class DuAn {
	private String maDuAn;
	private String tenDuAn;
	private int kinhPhi;
	private ThanhPho thanhPho;
	private KyNang kyNang;
	
	public DuAn() {
		super();
	}
	public DuAn(String maDuAn, String tenDuAn, int kinhPhi, ThanhPho thanhPho, KyNang kyNang) {
		super();
		this.maDuAn = maDuAn;
		this.tenDuAn = tenDuAn;
		this.kinhPhi = kinhPhi;
		this.thanhPho = thanhPho;
		this.kyNang = kyNang;
	}
	
	public String getMaDuAn() {
		return maDuAn;
	}
	public void setMaDuAn(String maDuAn) {
		this.maDuAn = maDuAn;
	}
	public String getTenDuAn() {
		return tenDuAn;
	}
	public void setTenDuAn(String tenDuAn) {
		this.tenDuAn = tenDuAn;
	}
	public int getKinhPhi() {
		return kinhPhi;
	}
	public void setKinhPhi(int kinhPhi) {
		this.kinhPhi = kinhPhi;
	}
	public ThanhPho getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(ThanhPho thanhPho) {
		this.thanhPho = thanhPho;
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
		result = prime * result + ((maDuAn == null) ? 0 : maDuAn.hashCode());
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
		DuAn other = (DuAn) obj;
		if (maDuAn == null) {
			if (other.maDuAn != null)
				return false;
		} else if (!maDuAn.equals(other.maDuAn))
			return false;
		return true;
	}
	
	
	
}
