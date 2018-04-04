package fr.mb.projet.bean.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe pour définir un Utilisateur
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

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

}
