package fr.mb.projet.impl;



import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.contract.SiteManager;



public class ManagerFactoryImpl implements ManagerFactory {
	
	private SiteManager siteManager;

	public SiteManager getSiteManager() {
		// TODO Auto-generated method stub
		return siteManager;
	}

	public void setSiteManager(SiteManager pSiteManager) {
		// TODO Auto-generated method stub
		siteManager=pSiteManager;
	}
	
	public String message() {
		String mes="manager factory existe";
		return mes;
	}

}
