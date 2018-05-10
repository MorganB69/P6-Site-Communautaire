package fr.mb.projet.bean.spot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.detail.Altitude;
import fr.mb.projet.bean.detail.Coordonnee;
import fr.mb.projet.bean.detail.Cotation;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.detail.Situation;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.topo.Topo;
/**
 * Classe principale permettant de définir un Site
 * @author Morgan
 *
 */
@Entity
@Table(name = "site",catalog = "projet")
public class Site implements Serializable{
	
	
	
	/**
	 * l'Id est généré automatiquement
	 */
	@Id
	@Column(name = "site_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * Nom du site
	 */
	@Column(name = "nom")
	private String nom;
	/**
	 * Description du site
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Description de l'accès au site
	 */
	@Column(name = "acces")
	private String acces;
	/**
	 * lien vers l'image du site
	 */
	@Column(name = "image")
	private String image;
	/**
	 * le nombre de secteur du site
	 */
	@Column(name = "nb_secteur")
	private Integer nbSecteur;
	/**
	 * le nombre de voie du site
	 */
	@Column(name = "nb_voie")
	private Integer nbVoie;
	/**
	 * date d'ajout du site
	 */
	@Column(name = "date_ajout")
	private Date dateAjout;
	
	/**
	 * Relation 1-1 avec Situation
	 */
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
	private Situation situation;
	
	/**
	 * Relation 1-1 avec Coordonnee
	 */
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
	private Coordonnee coordonnee;
	
	/**
	 * Relation 1-n avec Voie
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site")
	private Set <Voie> listeVoie=new HashSet<Voie>();
	
	/**
	 * Relation 1-n avec Secteur
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site")
	private Set <Secteur> listeSecteur=new HashSet<Secteur>();
	
	/**
	 * Relation 1-n avec Altitude
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
	private Set <Altitude> listeAltitude=new HashSet<Altitude>();
	
	
	/**
	 * Relation n-n avec les Orientation
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "info_orientation",catalog = "projet", joinColumns = { 
	@JoinColumn(name = "site_id",  nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "orientation_id", 
				nullable = false, updatable = false) })
	private Set <Orientation> listeOrientation=new HashSet<Orientation>();
	
	/**
	 * Relation 1-n avec Cotation
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site", cascade = CascadeType.ALL)
	private Set <Cotation> listeCotation=new HashSet<Cotation>();
	
	/**
	 * Relation n-1 avec Pays
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="country_id")
	private Pays pays;
	
	/**
	 *Relation n-1 avec State 
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="state_id")
	private State state;
	
	
	/**
	 *D�finit le type d'un site 
	 */
	@Column(name = "type")
	private String type;
	
	/**
	 *Relations 1-n pour les commentaires d'un site 
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "site")
	private Set <Comment> listeComment=new HashSet<Comment>();
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "topo_site",catalog = "projet", joinColumns = { 
	@JoinColumn(name = "site_id",  nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "topo_id", 
				nullable = false, updatable = false) })
	private Set<Topo> listeTopo=new HashSet<Topo>();
	
	
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
		situation.setSite(this);
		this.situation = situation;
		
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		coordonnee.setSite(this);
		this.coordonnee = coordonnee;
	}

	public Set<Voie> getListeVoie() {
		return listeVoie;
	}

	public void setListeVoie(Set<Voie> listeVoie) {
		for (Iterator<Voie> iterator = listeVoie.iterator(); iterator.hasNext();) {
			Voie voie = (Voie) iterator.next();
			voie.setSite(this);
			
		}
		
		this.listeVoie = listeVoie;
	}

	public Set<Secteur> getListeSecteur() {
		return listeSecteur;
	}

	public void setListeSecteur(Set<Secteur> listeSecteur) {
		for (Iterator<Secteur> iterator = listeSecteur.iterator(); iterator.hasNext();) {
			Secteur secteur = (Secteur) iterator.next();
			secteur.setSite(this);
			
		}
		this.listeSecteur = listeSecteur;
	}

	public Set<Altitude> getListeAltitude() {

		
		return listeAltitude;
	}

	public void setListeAltitude(Set<Altitude> listeAltitude) {
		for (Iterator<Altitude> iterator = listeAltitude.iterator(); iterator.hasNext();) {
			Altitude altitude = (Altitude) iterator.next();
			altitude.setSite(this);
		}
		
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
		for (Iterator<Cotation> iterator = listeCotation.iterator(); iterator.hasNext();) {
			Cotation cotation = (Cotation) iterator.next();
			cotation.setSite(this);
		}
		
		this.listeCotation = listeCotation;
	}



	public Date getDateAjout() {
		return dateAjout;
	}

	public void setDateAjout(Date dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<Comment> getListeComment() {
		return listeComment;
	}

	public void setListeComment(Set<Comment> listeComment) {
		this.listeComment = listeComment;
	}

	public Set<Topo> getListeTopo() {
		return listeTopo;
	}

	public void setListeTopo(Set<Topo> listeTopo) {
		this.listeTopo = listeTopo;
	}


	
	
	
	
	

}
