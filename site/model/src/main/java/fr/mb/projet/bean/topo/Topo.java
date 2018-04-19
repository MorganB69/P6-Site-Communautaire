package fr.mb.projet.bean.topo;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.user.Utilisateur;

/**
 * Model pour les Topos
 * @author Morgan
 *
 */
@Entity
@Table(name = "topo",catalog = "projet")
public class Topo implements Serializable {
	
	/**
	 * Id d'un topo
	 */
	@Id
	@Column(name = "topo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * Titre du topo
	 */
	@Column(name = "titre")
	private String titre;
	/**
	 * Auteur du topo
	 */
	@Column(name = "auteur")
	private String auteur;
	/**
	 * Lien vers l'image du topo
	 */
	@Column(name = "image")
	private String image;
	/**
	 * Description du topo
	 */
	@Column(name = "description")
	private String description;
	/**
	 * Attribut pour définir si le topo est disponible ou non 
	 */
	@Column(name = "statut")
	private String statut;
	/**
	 * Lien vers le topo
	 */
	@Column(name = "lien")
	private String lien;
	
	/**
	 * L'utilisateur à qui appartient le topo
	 */
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur proprietaire;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "topo")
	private Set<Pret>listePret=new HashSet<Pret>();
	

	
	/**
	 *Liste des sites associés au topo 
	 */
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "listeTopo")
	private Set<Site>listeSite=new HashSet<Site>();
	
	


	public Topo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}



	public Set<Site> getListeSite() {
		return listeSite;
	}

	public void setListeSite(Set<Site> listeSite) {
		this.listeSite = listeSite;
	}

	public Set<Pret> getListePret() {
		return listePret;
	}

	public void setListePret(Set<Pret> listePret) {
		this.listePret = listePret;
	}
}
