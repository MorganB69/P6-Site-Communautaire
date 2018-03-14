package fr.mb.projet.bean.spot;

import fr.mb.projet.bean.detail.Info;

public class Voie {
	private Integer voieId;
	private String typeVoie;
	private String nom;
	private String description;
	private Integer nbPoint;
	private Info info;
	
	public Voie() {
	
	}

	public Integer getVoieId() {
		return voieId;
	}

	public void setVoieId(Integer voieId) {
		this.voieId = voieId;
	}

	public String getTypeVoie() {
		return typeVoie;
	}

	public void setTypeVoie(String typeVoie) {
		this.typeVoie = typeVoie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbPoint() {
		return nbPoint;
	}

	public void setNbPoint(Integer nbPoint) {
		this.nbPoint = nbPoint;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
