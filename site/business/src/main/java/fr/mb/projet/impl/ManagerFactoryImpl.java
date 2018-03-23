package fr.mb.projet.impl;





import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.contract.UserManager;




@Named("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {
	
	
	
	public ManagerFactoryImpl() {
		
	}

	@Inject
	private SiteManager siteManager;
	@Inject
	private UserManager userManager;

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

}
