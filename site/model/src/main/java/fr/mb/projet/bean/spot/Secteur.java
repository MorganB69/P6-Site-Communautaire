package fr.mb.projet.bean.spot;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe permettant de définir le secteur d'un Site
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "secteur")
public class Secteur implements Serializable {
	/**
	 * l'Id d'un secteur, généré automatiquement
	 */
	@Id
	@Column(name = "secteur_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * le nom du secteur
	 */
	@Column(name = "nom")
	private String nom;
	/**
	 * la description du secteur
	 */
	@Column(name = "description")
	private String description;

	/**
	 * La relation avec un Site (many to one)
	 */
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;

	public Secteur() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		site.getListeSecteur().add(this);
		this.site = site;
	}

}
