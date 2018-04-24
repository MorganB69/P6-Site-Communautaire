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

/**
 * Classe permettant de définir les coordonnées d'un Site
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "coordonnee")
public class Coordonnee implements Serializable {

	/**
	 * L'ID est défini par le Site (strategy foreign car relation 1-1)
	 */
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "site"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "coord_id", unique = true, nullable = false, updatable=true)
	private Integer id;

	/**
	 * La latitude des coordonnées
	 */
	@Column(name = "latitude")
	private Double x;
	/**
	 * La longitude des coordonnées
	 */
	@Column(name = "longitude")
	private Double y;

	/**
	 * Classe site pour définir la relation 1-1
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
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
		this.site.setCoordonnee(this);
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.site.setCoordonnee(this);
		this.y = y;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
