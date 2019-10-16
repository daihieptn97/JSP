package Ultils;

public class Sach {

	private int id, gia;
	private String ten;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getGia() {
		return gia;
	}



	public void setGia(int gia) {
		this.gia = gia;
	}



	public String getTen() {
		return ten;
	}



	public void setTen(String ten) {
		this.ten = ten;
	}



	public Sach(int gia, String ten) {
		super();
		this.gia = gia;
		this.ten = ten;
	}



	public Sach(int id, int gia, String ten) {
		super();
		this.id = id;
		this.gia = gia;
		this.ten = ten;
	}



	/**
	 * 
	 */
	public Sach() {
		// TODO Auto-generated constructor stub
	}
}
