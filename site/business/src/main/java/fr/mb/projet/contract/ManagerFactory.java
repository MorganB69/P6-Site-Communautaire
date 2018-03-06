package fr.mb.projet.contract;

public interface ManagerFactory {
	
	public SiteManager getSiteManager();
	
	public void setSiteManager(SiteManager pSiteManager);
	
	public String message();

}
