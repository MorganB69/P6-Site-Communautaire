package fr.mb.projet.contract;

public interface ManagerFactory {
	
	public SiteManager getSiteManager();
	
	public void setSiteManager(SiteManager pSiteManager);
	
	public UserManager getUserManager();
	
	public void setUserManager(UserManager pUserManager);
	
	public DetailManager<?> getDetailManager();
	
	public void setDetailManager(DetailManager<?> pDetailManager);
	
	public String message();

}
