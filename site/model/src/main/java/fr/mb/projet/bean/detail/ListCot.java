package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_cotation")
public class ListCot {
	
	@Id
	@Column(name = "cot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "cot")
	private String cot;
	public ListCot(int id, String cot) {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCot() {
		return cot;
	}
	public void setCot(String cot) {
		this.cot = cot;
	}
	
	
	

}
