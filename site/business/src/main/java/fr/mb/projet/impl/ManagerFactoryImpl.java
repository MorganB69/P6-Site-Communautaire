package fr.mb.projet.impl;





import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.contract.SiteManager;
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
	private UserManager userManager;
	
	@Inject
	private DetailManager<?> cotationManager;
	
	@Inject
	private DetailManager<?> orientationManager;
	
	@Inject
	private DetailManager<?> paysManager;
	
	@Inject
	private DetailManager<?> stateManager;
	
	

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



}
