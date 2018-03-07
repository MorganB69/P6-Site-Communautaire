package fr.mb.projet.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.mb.projet.bean.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.recherche.RechercheSite;


public class SiteManagerImpl implements SiteManager {

	@Autowired
	SiteDao siteDao;
	
	
	RechercheSite rechercheSite = new RechercheSite();
	
	public int getCountSite() {
		
		int count=siteDao.getCountSite(rechercheSite);
		
		return count;
		
	}
	
	
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		
		Site vSite=siteDao.getSite(siteId);
		
		return vSite;
	}

	public List<Site> getListSite() {
		// TODO Auto-generated method stub
		
		List<Site> vList = new ArrayList();
			for(int i=0;i<4;i++) {
				Site vSite= new Site(i);
				vList.add(vSite);
			}
		
		return vList;
	
		}
	

}
