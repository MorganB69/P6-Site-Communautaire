package fr.mb.projet.contract;

public interface ManagerFactory {
	
	public SiteManager getSiteManager();
	
	public void setSiteManager(SiteManager pSiteManager);
	
	public UserManager getUserManager();
	
	public void setUserManager(UserManager pUserManager);
	
	public DetailManager<?> getOrientationManager();
	
	public void setOrientationManager(DetailManager<?> pDetailManager);
	
	public DetailManager<?> getCotationManager();
	
	public void setCotationManager(DetailManager<?> pDetailManager);
	
	public String message();

}
