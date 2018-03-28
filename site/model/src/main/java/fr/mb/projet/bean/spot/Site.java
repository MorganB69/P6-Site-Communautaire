package fr.mb.projet.bean.spot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mb.projet.bean.detail.Altitude;
import fr.mb.projet.bean.detail.Coordonnee;
import fr.mb.projet.bean.detail.Cotation;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Situation;
@Entity
@Table(name = "site",catalog = "projet")
public class Site implements Serializable{
	
	
	
	@Id
	@Column(name = "site_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "description")
	private String description;
	@Column(name = "acces")
	private String acces;
	@Column(name = "image")
	private String image;
	@Column(name = "nb_secteur")
	private Integer nbSecteur;
	@Column(name = "nb_voie")
	private Integer nbVoie;
	@Column(name = "date_ajout")
	private Date dateAjout;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "site", cascade = CascadeType.ALL)
	private Situation situation;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "site", cascade = CascadeType.ALL)
	private Coordonnee coordonnee;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
	private Set <Voie> listeVoie=new HashSet<Voie>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "site")
	private Set <Secteur> listeSecteur=new HashSet<Secteur>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
	private Set <Altitude> listeAltitude=new HashSet<Altitude>();
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "info_orientation",catalog = "projet", joinColumns = { 
	@JoinColumn(name = "site_id",  nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "orientation_id", 
				nullable = false, updatable = false) })
	private Set <Orientation> listeOrientation=new HashSet<Orientation>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
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
