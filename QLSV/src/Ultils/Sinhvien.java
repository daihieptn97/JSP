package Ultils;

public class Sinhvien {
	private int id, tuoi;
	private String ten, msv;
	
	

	public Sinhvien(int tuoi, String ten, String msv) {
		super();
		this.tuoi = tuoi;
		this.ten = ten;
		this.msv = msv;
	}

	public Sinhvien(int id, int tuoi, String ten, String msv) {
		super();
		this.id = id;
		this.tuoi = tuoi;
		this.ten = ten;
		this.msv = msv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getMsv() {
		return msv;
	}

	public void setMsv(String msv) {
		this.msv = msv;
	}
}
