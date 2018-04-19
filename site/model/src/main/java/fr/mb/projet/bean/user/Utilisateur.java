package fr.mb.projet.bean.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.bean.topo.Topo;

/**
 * Classe pour définir un Utilisateur
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur implements Serializable {

	/**
	 * l'Id est généré automatiquement
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * Le nom de l'utilisateur
	 */
	@Column(name = "nom")
	private String nom;
	/**
	 * Le pseudo de l'utilisateur
	 */
	@Column(name = "pseudo")
	private String pseudo;
	/**
	 * Le mot de passe de l'utilisateur
	 */
	@Column(name = "mdp")
	private String mdp;
	/**
	 * Le mail de l'utilisateur
	 */
	@Column(name = "mail")
	private String mail;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "emprunteur")
	private Set <Pret> listeTopoEmprunt=new HashSet<Pret>();
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "proprietaire")
	private Set <Topo> listeTopoPret=new HashSet<Topo>();

	public Utilisateur() {

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

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}



	public Set<Topo> getListeTopoPret() {
		return listeTopoPret;
	}

	public void setListeTopoPret(Set<Topo> listeTopoPret) {
		this.listeTopoPret = listeTopoPret;
	}

	public Set<Pret> getListeTopoEmprunt() {
		return listeTopoEmprunt;
	}

	public void setListeTopoEmprunt(Set<Pret> listeTopoEmprunt) {
		this.listeTopoEmprunt = listeTopoEmprunt;
	}

}
