package fr.mb.projet.bean;

public class Site {
	
	private int siteId;
	private String nom;
	private String description;
	private String acces;
	private String image;
	private int nbSecteur;
	private Situation situation;
	
	public Site(int siteId) {
		
		this.siteId = siteId;

	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAcces() {
		return acces;
	}

	public void setAcces(String acces) {
		this.acces = acces;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNbSecteur() {
		return nbSecteur;
	}

	public void setNbSecteur(int nbSecteur) {
		this.nbSecteur = nbSecteur;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}
	
	
	
	
	

}
