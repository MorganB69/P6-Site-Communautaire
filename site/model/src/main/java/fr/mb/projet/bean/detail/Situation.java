package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "situation")
public class Situation {
	@Id
	@Column(name = "situation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer situationId;
	@Column(name = "pays")
	private String pays;
	@Column(name = "departement")
	private String departement;
	@Column(name = "type")
	private String type;
	
	
	public Situation() {

	}


	public Integer getSituationId() {
		return situationId;
	}


	public void setSituationId(Integer situationId) {
		this.situationId = situationId;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

	
	
	
	

}
