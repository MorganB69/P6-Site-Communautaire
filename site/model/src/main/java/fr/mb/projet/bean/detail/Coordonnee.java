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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import fr.mb.projet.bean.spot.Site;

@Entity
@Table(name = "coordonnee")
public class Coordonnee implements Serializable{
	

	@Id
	@Column(name = "coord_id")
	private Integer id;
	

	@Column(name = "latitude")
	private Double x;
	@Column(name = "longitude")
	private Double y;
	
    @OneToOne
    @MapsId
    @JoinColumn(name="coord_id")
	private Site site;
	
	public Coordonnee() {

	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}





	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}



	public Site getSite() {
		return site;
	}



	public void setSite(Site site) {
		this.site = site;
	}


	
	
	
	
	
}
