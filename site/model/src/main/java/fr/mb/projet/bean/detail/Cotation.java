package fr.mb.projet.bean.detail;

public class Cotation {
	private int cotId;
	private String typeCot;
	private String cot;
	
	public Cotation(int cotId, String typeCot, String cot) {
		super();
		this.cotId = cotId;
		this.typeCot = typeCot;
		this.cot = cot;
	}
	public int getCotId() {
		return cotId;
	}
	public void setCotId(int cotId) {
		this.cotId = cotId;
	}
	public String getTypeCot() {
		return typeCot;
	}
	public void setTypeCot(String typeCot) {
		this.typeCot = typeCot;
	}
	public String getCot() {
		return cot;
	}
	public void setCot(String cot) {
		this.cot = cot;
	}
	
	
}
