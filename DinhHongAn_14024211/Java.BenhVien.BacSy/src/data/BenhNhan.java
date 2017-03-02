package data;

import java.util.Arrays;

public class BenhNhan {
	private String msbn;
	private String socmnd;
	private String hoten;
	private String diachi;
	private KhamBenh[] listKhamBenh;
	
	public BenhNhan(String msbn, String socmnd, String hoten) {
		super();
		this.msbn = msbn;
		this.socmnd = socmnd;
		this.hoten = hoten;
	}
	public BenhNhan(String msbn, String socmnd, String hoten, String diachi) {
		super();
		this.msbn = msbn;
		this.socmnd = socmnd;
		this.hoten = hoten;
		this.diachi = diachi;
	}
	public BenhNhan(String msbn, String socmnd, String hoten, String diachi, KhamBenh[] listKhamBenh) {
		super();
		this.msbn = msbn;
		this.socmnd = socmnd;
		this.hoten = hoten;
		this.diachi = diachi;
		this.listKhamBenh = listKhamBenh;
	}
	
	@Override
	public String toString() {
		return "BenhNhan [msbn=" + msbn + ", socmnd=" + socmnd + ", hoten=" + hoten + ", diachi=" + diachi
				+ ", listKhamBenh=" + Arrays.toString(listKhamBenh) + "]";
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getSocmnd() {
		return socmnd;
	}
	public void setSocmnd(String socmnd) {
		this.socmnd = socmnd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public KhamBenh[] getListKhamBenh() {
		return listKhamBenh;
	}
	public void setListKhamBenh(KhamBenh[] listKhamBenh) {
		this.listKhamBenh = listKhamBenh;
	}
}
