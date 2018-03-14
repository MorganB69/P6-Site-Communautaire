package fr.mb.projet.bean.detail;

public class Situation {
	
	private Integer situationId;
	private String pays;
	private String departement;
	private String situation;
	private Coordonnee coord;
	
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

	public String getSituation() {
		return situation;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public Coordonnee getCoord() {
		return coord;
	}

	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}
	
	
	
	

}
