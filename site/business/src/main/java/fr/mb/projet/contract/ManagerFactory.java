package fr.mb.projet.contract;

public interface ManagerFactory {
	
	public SiteManager getSiteManager();
	
	public void setSiteManager(SiteManager pSiteManager);
	
	public UserManager getUserManager();
	
	public void setUserManager(UserManager pUserManager);
	
	public String message();

}
