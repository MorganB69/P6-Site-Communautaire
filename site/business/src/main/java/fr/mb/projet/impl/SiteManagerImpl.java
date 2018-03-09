package fr.mb.projet.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import fr.mb.projet.bean.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.recherche.RechercheSite;


@Named("siteManager")
public class SiteManagerImpl extends AbstractManager implements SiteManager {

	
	
	@Inject
	SiteDao siteDao;
	
	
	RechercheSite rechercheSite = new RechercheSite();
	
	
	
	public SiteManagerImpl() {
		
	}

	@Override
	public int getCountSite() {
		
		int count=siteDao.getCountSite(rechercheSite);
		
		return count;
		
	}
	
	@Override
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		
		Site vSite=siteDao.getSite(siteId);
		
		return vSite;
	}
	@Override
	public List<Site> getListSite() {
		// TODO Auto-generated method stub
		
		List<Site> vList = new ArrayList();
			for(int i=0;i<4;i++) {
				Site vSite= new Site(i);
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
