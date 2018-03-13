package fr.mb.projet.bean.detail;

public class Altitude {
	private int altId;
	private String typeAlt;
	private int alt;
	
	public Altitude(int altId, String typeAlt, int alt) {
		super();
		this.altId = altId;
		this.typeAlt = typeAlt;
		this.alt = alt;
	}
	public int getAltId() {
		return altId;
	}
	public void setAltId(int altId) {
		this.altId = altId;
	}
	public String getTypeAlt() {
		return typeAlt;
	}
	public void setTypeAlt(String typeAlt) {
		this.typeAlt = typeAlt;
	}
	public int getAlt() {
		return alt;
	}
	public void setAlt(int alt) {
		this.alt = alt;
	}
	
	
	
}
