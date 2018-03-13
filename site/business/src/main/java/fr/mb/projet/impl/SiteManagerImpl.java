package fr.mb.projet.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.recherche.RechercheSite;


@Named("siteManager")
public class SiteManagerImpl extends AbstractManager implements SiteManager {

	
	
	//@Inject
	SiteDao siteDao;
	
	@Inject
	SiteDaoImpl2 siteDao2;
	
	
	RechercheSite rechercheSite = new RechercheSite();
	
	
	
	public SiteManagerImpl() {
		
	}
	
	


	
	
	
	@Override
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		
		Site vSite=siteDao2.getById(siteId);
		
		
		return vSite;
	}
	@Override
	public List<Site> getListSite() {
		// TODO Auto-generated method stub
		
		List<Site> vList = new ArrayList();
			for(int i=0;i<4;i++) {
				Site vSite= new Site();
				vList.add(vSite);
			}
		
		return vList;
	
		}

	
	public SiteDao getSiteDao() {
		return siteDao;
	}


	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}

	
	public RechercheSite getRechercheSite() {
		return rechercheSite;
	}


	public void setRechercheSite(RechercheSite rechercheSite) {
		this.rechercheSite = rechercheSite;
	}
	

}
