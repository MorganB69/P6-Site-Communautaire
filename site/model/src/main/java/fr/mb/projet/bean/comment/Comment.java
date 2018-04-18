package fr.mb.projet.bean.comment;

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

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.user.Utilisateur;

@Entity
@Table(name = "commentaire")
public class Comment implements Serializable{
	
	@Id
	@Column(name = "comment_id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "date")
	private Date date;
	@Column(name="message")
	private String message;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Utilisateur user;
	
	@ManyToOne
	@JoinColumn(name="site_id")
	private Site site;
	
	

	public Comment() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		site.getListeComment().add(this);
		this.site = site;
	}
	

}
