package fr.mb.projet.bean.detail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import fr.mb.projet.bean.spot.Site;

@Entity
@Table(name = "situation")
public class Situation implements Serializable {
	
	private static final Logger logger = LogManager.getLogger(Situation.class);

	@Id
	@Column(name = "situ_id")
	private Integer id;
	


	@Column(name = "pays")
	private String pays;
	@Column(name = "departement")
	private String departement;
	@Column(name = "type")
	private String type;
	
	
    @OneToOne
    @MapsId
    @JoinColumn(name="situ_id")
	private Site site;
	
	
	public Situation() {
		logger.info("création d'un situation");
	}


	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getDepartement() {
		return departement;
	}


	public void setDepartement(String departement) {
		this.departement = departement;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}



	public Site getSite() {
		return site;
	}



	public void setSite(Site site) {
		this.site = site;
	}

	
	
	
	

}
