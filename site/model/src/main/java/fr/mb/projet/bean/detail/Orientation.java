package fr.mb.projet.bean.detail;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import fr.mb.projet.bean.spot.Site;

/**
 * Classe pour définir l'Orientation d'un site
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "orientation", catalog = "projet")
public class Orientation implements Serializable {
	/**
	 * L'ID
	 */
	@Id
	@Column(name = "orientation_id")
	private Integer orientationId;
	/**
	 * Valeur de l'orientation (Sud etc.)
	 */
	@Column(name = "valeur")
	private String orientation;
	/**
	 * Liste de Site pour définir la relations n-n
	 */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "listeOrientation")
	private Set<Site> sites = new HashSet<Site>();

	public Orientation() {

	}

	public Integer getOrientationId() {
		return orientationId;
	}

	public void setOrientationId(Integer orientationId) {
		this.orientationId = orientationId;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public Set<Site> getSites() {
		return sites;
	}

	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}

}
