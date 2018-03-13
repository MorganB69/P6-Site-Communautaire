package fr.mb.projet.bean.detail;

public class Orientation {
	private int orientationId;
	private String orientation;
	
	public Orientation(int orientationId, String orientation) {
		super();
		this.orientationId = orientationId;
		this.orientation = orientation;
	}
	public int getOrientationId() {
		return orientationId;
	}
	public void setOrientationId(int orientationId) {
		this.orientationId = orientationId;
	}
	public String getOrientation() {
		return orientation;
	}
	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	
	
}
