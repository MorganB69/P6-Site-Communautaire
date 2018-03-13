package fr.mb.projet.bean.spot;

import java.io.Serializable;
import java.util.ArrayList;

import fr.mb.projet.bean.detail.Info;
import fr.mb.projet.bean.detail.Situation;

public class Site implements Serializable{
	
	private int id;
	private String nom;
	private String description;
	private String acces;
	private String image;
	private int nbSecteur;
	private int nbVoie;
	private Situation situation;
	private ArrayList <Voie> listeVoie;
	private Info info;
	
	public Site() {

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


	

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public int getNbVoie() {
		return nbVoie;
	}

	public void setNbVoie(int nbVoie) {
		this.nbVoie = nbVoie;
	}

	public ArrayList <Voie> getListeVoie() {
		return listeVoie;
	}

	public void setListeVoie(ArrayList <Voie> listeVoie) {
		this.listeVoie = listeVoie;
	}
	
	
	
	
	

}
