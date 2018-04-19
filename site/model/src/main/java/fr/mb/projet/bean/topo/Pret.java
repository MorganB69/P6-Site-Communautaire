package fr.mb.projet.bean.topo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.mb.projet.bean.user.Utilisateur;

@Entity
@Table(name = "pret",catalog = "projet")
public class Pret implements Serializable{
	
	@Id
	@Column(name = "pret_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date_debut")
	private Date debut;
	@Column(name = "date_fin")
	private Date fin;
	@Column(name = "statut")
	private String statut;
	
	@ManyToOne
	@JoinColumn(name="topo_id")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name="emprunteur")
	private Utilisateur emprunteur;
	
	
	public Pret() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDebut() {
		return debut;
	}


	public void setDebut(Date debut) {
		this.debut = debut;
	}


	public Date getFin() {
		return fin;
	}


	public void setFin(Date fin) {
		this.fin = fin;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Topo getTopo() {
		return topo;
	}


	public void setTopo(Topo topo) {
		topo.getListePret().add(this);
		this.topo = topo;
	}


	public Utilisateur getEmprunteur() {
		return emprunteur;
	}


	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}


}
