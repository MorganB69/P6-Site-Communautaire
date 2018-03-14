package fr.mb.projet.action;

import java.util.Collections;

import javax.inject.Inject;
import javax.inject.Named;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.NotFoundException;


public class SiteAction extends ActionSupport{
	
	@Inject
	private ManagerFactory managerFactory;

	
	Integer idSite=3;
	String description;
	Site site;
	
	//Helper.getManagerFactory

	
	//String description=managerFactory.message();
	
	
	
	//int description=managerFactory.getSiteManager().getSite(1).getSiteId();

	 public String doList() {
		 	
		 	

			
	        return ActionSupport.SUCCESS;
	    }
	 
	    public String doDetail() {
	        if (idSite == null) {
	            this.addActionError(getText("error.project.missing.id"));
	        } else {
	            try {
	            	site=managerFactory.getSiteManager().getSite(idSite);
	    		 	idSite=site.getId();
	    			description=site.getDescription();
	    			
	            } catch (NotFoundException pE) {
	                this.addActionError(getText("error.project.notfound", Collections.singletonList(idSite)));
	            }
	        }

	        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	    }
	

public String execute() {
        
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
