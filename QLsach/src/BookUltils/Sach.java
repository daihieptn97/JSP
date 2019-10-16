package BookUltils;

public class Sach {
  private int id, gia;
  private String tensach;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getGia() {
	return gia;
}
public Sach() {
	super();
}
public Sach(int gia, String tensach) {
	super();
	this.gia = gia;
	this.tensach = tensach;
}
public Sach(int id, int gia, String tensach) {
	super();
	this.id = id;
	this.gia = gia;
	this.tensach = tensach;
}
public void setGia(int gia) {
	this.gia = gia;
}
public String getTensach() {
	return tensach;
}
public void setTensach(String tensach) {
	this.tensach = tensach;
}
  
  
}
