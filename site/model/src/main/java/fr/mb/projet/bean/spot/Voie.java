package fr.mb.projet.bean.spot;

import fr.mb.projet.bean.detail.Info;

public class Voie {
	private int voieId;
	private String typeVoie;
	private String nom;
	private String description;
	private int nbPoint;
	private Info info;
	
	public Voie(int voieId, String typeVoie, String nom, int nbPoint, Info info) {
		super();
		this.voieId = voieId;
		this.typeVoie = typeVoie;
		this.nom = nom;
		this.nbPoint = nbPoint;
		this.info = info;
	}

	public int getVoieId() {
		return voieId;
	}

	public void setVoieId(int voieId) {
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

	public int getNbPoint() {
		return nbPoint;
	}

	public void setNbPoint(int nbPoint) {
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
