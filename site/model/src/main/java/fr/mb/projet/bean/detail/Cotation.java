package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cotation")
public class Cotation {
	@Id
	@Column(name = "cotation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cotationId;
	@Column(name = "type_cot")
	private String typeCot;
	@ManyToOne
	@JoinColumn(name="cot_id")
	private ListCot cot;
	
	public Cotation() {

	}
	public Integer getCotId() {
		return cotationId;
	}
	public void cotationId(Integer cotId) {
		this.cotationId = cotId;
	}
	public String getTypeCot() {
		return typeCot;
	}
	public void setTypeCot(String typeCot) {
		this.typeCot = typeCot;
	}
	public ListCot getCot() {
		return cot;
	}
	public void setCot(ListCot cot) {
		this.cot = cot;
	}
	
	
}
