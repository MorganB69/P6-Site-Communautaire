package fr.mb.projet.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.orm.hibernate5.HibernateTemplate;

import fr.mb.projet.bean.spot.Site;

@Named("siteDao2")
public class SiteDaoImpl2 {
	
	@Inject
	HibernateTemplate template;
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	
	public Site getById(int id){  
		Site e=new Site();
		e=(Site)template.get(fr.mb.projet.bean.spot.Site.class,id);  
	    return e;  
	}
}
