package Models;

import java.util.ArrayList;



public class ThanhPho {
	private String maTP;
	private String tenTP;
	private String tieuBang;
	private int danSo;
	public ThanhPho(String maTP, String tenTP, String tieuBang, int danSo) {
		super();
		this.maTP = maTP;
		this.tenTP = tenTP;
		this.tieuBang = tieuBang;
		this.danSo = danSo;
	}
	public ThanhPho() {
		super();
	}
	
		private ArrayList<DuAn> duAns = new ArrayList<DuAn>();
		
		public void add(DuAn da){
			duAns.add(da);
		}
		public void remove(DuAn da) {
			duAns.remove(da);
		}
		
	public ArrayList<DuAn> getDuAns() {
			return duAns;
		}
		public void setDuAns(ArrayList<DuAn> duAns) {
			this.duAns = duAns;
		}
	public String getMaTP() {
		return maTP;
	}
	public void setMaTP(String maTP) {
		this.maTP = maTP;
	}
	public String getTenTP() {
		return tenTP;
	}
	public void setTenTP(String tenTP) {
		this.tenTP = tenTP;
	}
	public String getTieuBang() {
		return tieuBang;
	}
	public void setTieuBang(String tieuBang) {
		this.tieuBang = tieuBang;
	}
	public int getDanSo() {
		return danSo;
	}
	public void setDanSo(int danSo) {
		this.danSo = danSo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTP == null) ? 0 : maTP.hashCode());
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
		ThanhPho other = (ThanhPho) obj;
		if (maTP == null) {
			if (other.maTP != null)
				return false;
		} else if (!maTP.equals(other.maTP))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return tenTP;
	}
	
	
}
