package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "altitude")
public class Altitude {
	
	@Id
	@Column(name = "alt_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer altId;
	
	@Column(name = "type_alt")
	private String typeAlt;
	@Column(name = "alt")
	private Integer alt;
	
	public Altitude() {

	}
	public Integer getAltId() {
		return altId;
	}
	public void setAltId(Integer altId) {
		this.altId = altId;
	}
	public String getTypeAlt() {
		return typeAlt;
	}
	public void setTypeAlt(String typeAlt) {
		this.typeAlt = typeAlt;
	}
	public Integer getAlt() {
		return alt;
	}
	public void setAlt(Integer alt) {
		this.alt = alt;
	}
	
	
	
}
