package fr.mb.projet;


import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.impl.ManagerFactoryImpl;




public class SiteAction extends ActionSupport{
	

	
	Site site=Helper.getManagerFactory().getSiteManager().getSite(4);
	
	
	int nbSite=Helper.getManagerFactory().getSiteManager().getCountSite();
	
	
	int idSite=site.getSiteId();
	String description=site.getDescription();
	
	
	
	
	
	//int description=managerFactory.getSiteManager().getSite(1).getSiteId();
	
    public void setNbSite(int nbSite) { this.nbSite = nbSite; }
    public int getNbSite() { return nbSite; }
	
	

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
public String execute() throws Exception {
        
        return SUCCESS;
    }
}
