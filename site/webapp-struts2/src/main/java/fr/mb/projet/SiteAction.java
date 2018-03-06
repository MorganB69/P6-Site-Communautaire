package fr.mb.projet;


import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.impl.ManagerFactoryImpl;




public class SiteAction extends ActionSupport{
	

	
	
	
	String description=Helper.getManagerFactory().getSiteManager().getSite(1).getDescription();
	
	//String description=managerFactory.getSiteManager().getSite(1).getDescription();
	
	
	
	
	
	//int description=managerFactory.getSiteManager().getSite(1).getSiteId();
	
    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }
	
	
	

	
	
public String execute() throws Exception {
        
        return SUCCESS;
    }
}
