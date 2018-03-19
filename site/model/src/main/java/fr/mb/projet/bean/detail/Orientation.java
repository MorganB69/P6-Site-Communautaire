package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orientation")
public class Orientation {
	@Id
	@Column(name = "orientation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orientationId;
	@Column(name = "valeur")
	private String orientation;
	
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
	
	
	
}
