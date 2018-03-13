package fr.mb.projet;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;


public class SiteAction extends ActionSupport{
	
	@Inject
	private ManagerFactory managerFactory;

	
	int idSite;
	String description;
	Site site;
	
	//Helper.getManagerFactory

	
	//String description=managerFactory.message();
	
	
	
	//int description=managerFactory.getSiteManager().getSite(1).getSiteId();

	 public String doList() {
		 	site=managerFactory.getSiteManager().getSite(4);
		 	
		 	idSite=site.getId();
			description=site.getDescription();
			
	        return ActionSupport.SUCCESS;
	    }
	

public String execute() throws Exception {
        
        return SUCCESS;
    }





public ManagerFactory getManagerFactory() {
	return managerFactory;
}





public void setManagerFactory(ManagerFactory pmanagerFactory) {
	managerFactory = pmanagerFactory;
}





public Site getSite() {
	return site;
}





public void setSite(Site site) {
	this.site = site;
}











public int getIdSite() {
	return idSite;
}





public void setIdSite(int idSite) {
	this.idSite = idSite;
}




public String getDescription() {
	return description;
}





public void setDescription(String description) {
	this.description = description;
}

}
