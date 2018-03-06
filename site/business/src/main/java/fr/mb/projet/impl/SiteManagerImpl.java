package fr.mb.projet.impl;

import java.util.ArrayList;
import java.util.List;

import fr.mb.projet.bean.Site;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.exception.NotFoundException;


public class SiteManagerImpl implements SiteManager {

	
	
	public Site getSite(Integer siteId) {
		// TODO Auto-generated method stub
		

		
		Site vSite = new Site(siteId);
		vSite.setDescription("Site numéro : "+siteId);
		
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
