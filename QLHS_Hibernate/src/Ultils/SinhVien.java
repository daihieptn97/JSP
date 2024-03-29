package Ultils;

import javax.persistence.*;
//import javax.persistence.Table;

@Entity
@Table(name = "sinhvien")

public class SinhVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String msv;

	private String ten;

	private int tuoi;

	@Column(name = "quequan")
	private String qq;

	private String gt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public SinhVien(int id, String msv, String ten, int tuoi, String qq, String gt) {
		super();
		this.id = id;
		this.msv = msv;
		this.ten = ten;
		this.tuoi = tuoi;
		this.qq = qq;
		this.gt = gt;
	}

	public SinhVien() {
		super();
	}

	public SinhVien(String msv, String ten, int tuoi, String qq, String gt) {
		super();
		this.msv = msv;
		this.ten = ten;
		this.tuoi = tuoi;
		this.qq = qq;
		this.gt = gt;
	}

}
