package fr.mb.projet.bean.spot;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import fr.mb.projet.bean.detail.ListCot;

/**
 * La classe d'une Voie d'un Site
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "voie")
public class Voie {
	/**
	 * l'Id d'une voie est généré automatiquement
	 */
	@Id
	@Column(name = "voie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voieId;
	/**
	 * type de voie
	 */
	@Column(name = "type_voie")
	private String typeVoie;
	/**
	 * le nom de la voie
	 */
	@Column(name = "nom")
	private String nom;
	/**
	 * description de la voie
	 */
	@Column(name = "description")
	private String description;
	/**
	 * nombre de points de la voie
	 */
	@Column(name = "nb_point")
	private Integer nbPoint;
	/**
	 * hauteur de la voie
	 */
	@Column(name = "hauteur")
	private Integer hauteur;
	/**
	 * cotation de la voie(relation n-1 avec ListCot contenant les cotations)
	 */
	@ManyToOne
	@JoinColumn(name = "cot_id")
	private ListCot cotation;

	/**
	 * Relation n-1 avec un Site
	 */
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNbPoint() {
		return nbPoint;
	}

	public void setNbPoint(Integer nbPoint) {
		this.nbPoint = nbPoint;
	}

	public Integer getHauteur() {
		return hauteur;
	}

	public void setHauteur(Integer hauteur) {
		this.hauteur = hauteur;
	}

	public ListCot getCotation() {
		return cotation;
	}

	public void setCotation(ListCot cotation) {
		this.cotation = cotation;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		site.getListeVoie().add(this);
		this.site = site;
	}

}
