package fr.mb.projet.bean.detail;

import java.util.ArrayList;

public class Info {
	Integer infoId;
	ArrayList <Orientation> orientationList;
	ArrayList <Altitude> altituteList;
	ArrayList <Cotation> cotationList;
	
	
	public Info() {

	}


	public Integer getInfoId() {
		return infoId;
	}


	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}


	public ArrayList<Orientation> getOrientationList() {
		return orientationList;
	}


	public void setOrientationList(ArrayList<Orientation> orientationList) {
		this.orientationList = orientationList;
	}


	public ArrayList<Altitude> getAltituteList() {
		return altituteList;
	}


	public void setAltituteList(ArrayList<Altitude> altituteList) {
		this.altituteList = altituteList;
	}


	public ArrayList<Cotation> getCotationList() {
		return cotationList;
	}


	public void setCotationList(ArrayList<Cotation> cotationList) {
		this.cotationList = cotationList;
	}
	

	
	
	
}
