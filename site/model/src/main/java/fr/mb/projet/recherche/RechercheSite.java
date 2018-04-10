package fr.mb.projet.recherche;


/**
 * Classe pour définir les critères de recherche d'un Site
 * @author Morgan
 *
 */
public class RechercheSite {
	private int rSiteId;
	private Integer rPays;
	private Integer rDepartement;
	private Integer rCotMin;
	private Integer rCotMax;
	private Integer rAltMin;
	private Integer rAltMax;
	private String rtype;
	private Integer rOrient;

	public RechercheSite() {
		
		
	}

	public int getrSiteId() {
		return rSiteId;
	}

	public void setrSiteId(int rSiteId) {
		this.rSiteId = rSiteId;
	}

	public Integer getrPays() {
		return rPays;
	}

	public void setrPays(Integer rPays) {
		this.rPays = rPays;
	}

	public Integer getrDepartement() {
		return rDepartement;
	}

	public void setrDepartement(Integer rDepartement) {
		this.rDepartement = rDepartement;
	}

	public Integer getrCotMin() {
		return rCotMin;
	}

	public void setrCotMin(Integer rCotMin) {
		this.rCotMin = rCotMin;
	}

	public Integer getrCotMax() {
		return rCotMax;
	}

	public void setrCotMax(Integer rCotMax) {
		this.rCotMax = rCotMax;
	}

	public Integer getrAltMin() {
		return rAltMin;
	}

	public void setrAltMin(Integer rAltMin) {
		this.rAltMin = rAltMin;
	}

	public Integer getrAltMax() {
		return rAltMax;
	}

	public void setrAltMax(Integer rAltMax) {
		this.rAltMax = rAltMax;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public Integer getrOrient() {
		return rOrient;
	}

	public void setrOrient(Integer rOrient) {
		this.rOrient = rOrient;
	}


	
}
