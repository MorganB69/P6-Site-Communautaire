package fr.mb.projet.impl;





import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.mb.projet.contract.AjoutManager;
import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.contract.TopoManager;
import fr.mb.projet.contract.UserManager;




/**
 * Implémentation de la factory des managers
 * @author Morgan
 *
 */
@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {
	
	
	
	public ManagerFactoryImpl() {
		
	}

	@Inject
	private SiteManager siteManager;
	
	@Inject
	private TopoManager topoManager;
	
	@Inject
	private UserManager userManager;
	
	@Inject
	private DetailManager<?> cotationManager;
	
	@Inject
	private DetailManager<?> orientationManager;
	
	@Inject
	private DetailManager<?> paysManager;
	
	@Inject
	private DetailManager<?> stateManager;
	
	@Inject
	private AjoutManager<?> ajoutManager;
	

	
	
	
	

	@Override
	public SiteManager getSiteManager() {
		// TODO Auto-generated method stub
		return siteManager;
	}

	public void setSiteManager(SiteManager pSiteManager) {
		// TODO Auto-generated method stub
		siteManager=pSiteManager;
	}
	
	@Override
	public String message() {

		
		return "Bonjour la factory existe";
	}

	@Override
	public UserManager getUserManager() {
		// TODO Auto-generated method stub
		return userManager;
	}

	@Override
	public void setUserManager(UserManager pUserManager) {
		// TODO Auto-generated method stub
		
	}

	public DetailManager<?> getCotationManager() {
		return cotationManager;
	}

	public void setCotationManager(DetailManager<?> cotationManager) {
		this.cotationManager = cotationManager;
	}

	public DetailManager<?> getOrientationManager() {
		return orientationManager;
	}

	public void setOrientationManager(DetailManager<?> orientationManager) {
		this.orientationManager = orientationManager;
	}

	@Override
	public DetailManager<?> getPaysManager() {
		// TODO Auto-generated method stub
		return paysManager;
	}

	@Override
	public DetailManager<?> getStateManager() {
		// TODO Auto-generated method stub
		return stateManager;
	}

	public AjoutManager<?> getCommentManager() {
		return ajoutManager;
	}



	public AjoutManager<?> getSecteurManager() {
		return ajoutManager;
	}
	
	


	public void setPaysManager(DetailManager<?> paysManager) {
		this.paysManager = paysManager;
	}

	public void setStateManager(DetailManager<?> stateManager) {
		this.stateManager = stateManager;
	}


	@Override
	public void SetCommentManager(AjoutManager<?> pCommentManager) {
		this.ajoutManager = pCommentManager;
		
	}

	@Override
	public void SetSecteurManager(AjoutManager<?> pCommentManager) {
		this.ajoutManager = pCommentManager;
		
	}

	@Override
	public AjoutManager<?> getVoieManager() {
		// TODO Auto-generated method stub
		return ajoutManager;
	}

	@Override
	public void SetVoieManager(AjoutManager<?> pCommentManager) {
	this.ajoutManager=pCommentManager;
		
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}

	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
	}











}
