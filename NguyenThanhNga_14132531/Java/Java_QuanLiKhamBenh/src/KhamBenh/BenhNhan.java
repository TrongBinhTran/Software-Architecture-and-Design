package KhamBenh;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"msbn","hoTen","soCMND","diaChi"})
public class BenhNhan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msbn;
	private String hoTen;
	private String soCMND;
	private String diaChi;
	public BenhNhan(String msbn, String hoTen, String soCMND, String diaChi) {
		this.msbn = msbn;
		this.hoTen = hoTen;
		this.soCMND = soCMND;
		this.diaChi = diaChi;
	}
	public BenhNhan() {
		// TODO Auto-generated constructor stub
		this("","","","");
	}
	public String getMsbn() {
		return msbn;
	}
	public void setMsbn(String msbn) {
		this.msbn = msbn;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getSoCMND() {
		return soCMND;
	}
	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}
