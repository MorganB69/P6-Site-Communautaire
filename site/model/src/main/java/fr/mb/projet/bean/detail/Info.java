package fr.mb.projet.bean.detail;

import java.util.ArrayList;

public class Info {
	int infoId;
	ArrayList <Orientation> orientationList;
	ArrayList <Altitude> altituteList;
	ArrayList <Cotation> cotationList;
	
	
	public Info(int infoId, ArrayList<Orientation> orientationList, ArrayList<Altitude> altituteList,
			ArrayList<Cotation> cotationList) {
		super();
		this.infoId = infoId;
		this.orientationList = orientationList;
		this.altituteList = altituteList;
		this.cotationList = cotationList;
	}


	public int getInfoId() {
		return infoId;
	}


	public void setInfoId(int infoId) {
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
