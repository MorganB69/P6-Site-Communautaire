package fr.mb.projet.bean.spot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.mb.projet.bean.detail.Altitude;
import fr.mb.projet.bean.detail.Coordonnee;
import fr.mb.projet.bean.detail.Cotation;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Situation;

public class Site implements Serializable{
	
	private Integer id;
	private String nom;
	private String description;
	private String acces;
	private String image;
	private Integer nbSecteur;
	private Integer nbVoie;
	private Date dateAjout;
	
	private Situation situation;
	private Coordonnee coordonnee;
	
	private Set <Voie> listeVoie=new HashSet<Voie>();
	private Set <Secteur> listeSecteur=new HashSet<Secteur>();
	
	private Set <Altitude> listeAltitude=new HashSet<Altitude>();
	private Set <Orientation> listeOrientation=new HashSet<Orientation>();
	private Set <Cotation> listeCotation=new HashSet<Cotation>();
	
	
	public Site() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getNbSecteur() {
		return nbSecteur;
	}

	public void setNbSecteur(Integer nbSecteur) {
		this.nbSecteur = nbSecteur;
	}

	public Integer getNbVoie() {
		return nbVoie;
	}

	public void setNbVoie(Integer nbVoie) {
		this.nbVoie = nbVoie;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	public Set<Voie> getListeVoie() {
		return listeVoie;
	}

	public void setListeVoie(Set<Voie> listeVoie) {
		this.listeVoie = listeVoie;
	}

	public Set<Secteur> getListeSecteur() {
		return listeSecteur;
	}

	public void setListeSecteur(Set<Secteur> listeSecteur) {
		this.listeSecteur = listeSecteur;
	}

	public Set<Altitude> getListeAltitude() {
		return listeAltitude;
	}

	public void setListeAltitude(Set<Altitude> listeAltitude) {
		this.listeAltitude = listeAltitude;
	}

	public Set<Orientation> getListeOrientation() {
		return listeOrientation;
	}

	public void setListeOrientation(Set<Orientation> listeOrientation) {
		this.listeOrientation = listeOrientation;
	}

	public Set<Cotation> getListeCotation() {
		return listeCotation;
	}

	public void setListeCotation(Set<Cotation> listeCotation) {
		this.listeCotation = listeCotation;
	}



	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}


	
	
	
	
	

}
