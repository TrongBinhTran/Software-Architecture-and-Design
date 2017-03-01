package KhamBenh;

import java.time.LocalDateTime;

public class BangKhamBenh {
	private String msbn;
	private String msbacsy;
	private LocalDateTime ngayKham;
	private String ghiChu;
	public BangKhamBenh(String msbn, String msbacsy, LocalDateTime ngayKham, String ghiChu) {
		this.msbn = msbn;
		this.msbacsy = msbacsy;
		this.ngayKham = ngayKham;
		this.ghiChu = ghiChu;
	}
	public BangKhamBenh() {
		// TODO Auto-generated constructor stub
		this("","",LocalDateTime.now(),"");
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getMsbacsy() {
		return msbacsy;
	}
	public void setMsbacsy(String msbacsy) {
		this.msbacsy = msbacsy;
	}
	public LocalDateTime getNgayKham() {
		return ngayKham;
	}
	public void setNgayKham(LocalDateTime ngayKham) {
		this.ngayKham = ngayKham;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	
	
}
