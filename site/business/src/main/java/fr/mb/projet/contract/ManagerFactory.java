package fr.mb.projet.contract;

/**
 * Interface pour la Manager factory
 * @author Morgan
 *
 */
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

	public DetailManager<?> getPaysManager();

	public DetailManager<?> getStateManager();
	
	public AjoutManager<?> getCommentManager();
	
	public void SetCommentManager(AjoutManager<?> pCommentManager);
	
	public AjoutManager<?> getSecteurManager();
	
	public void SetSecteurManager(AjoutManager<?> pCommentManager);
	
	public AjoutManager<?> getVoieManager();
	
	public void SetVoieManager(AjoutManager<?> pCommentManager);
	
	public TopoManager getTopoManager();
	
	public void setTopoManager(TopoManager pTopoManager);
	
	public PretManager getPretManager();
	
	public void setPretManager(PretManager pPretManager);

}
