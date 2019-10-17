package Ultils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "sach")
public class Sach {
	
	@ManyToMany(cascade  = {CascadeType.ALL})
	@JoinTable(
			name = "Mua",
			joinColumns = { @JoinColumn(name = "id_sach") }, 
	        inverseJoinColumns = { @JoinColumn(name = "id_nguoimua") }
			)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tensach")
	private String ten;
	
	@Column(name = "giasach")
	private int gia;
	
	
	
	public Sach(int id, String ten, int gia) {
		super();
		this.id = id;
		this.ten = ten;
		this.gia = gia;
	}


	public Sach(String ten, int gia) {
		super();
		this.ten = ten;
		this.gia = gia;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public int getGia() {
		return gia;
	}


	public void setGia(int gia) {
		this.gia = gia;
	}


	public Sach() {
		// TODO Auto-generated constructor stub
	}

}
