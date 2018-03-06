package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.Site;
import fr.mb.projet.exception.NotFoundException;

public interface SiteManager {

	public Site getSite (Integer siteId);
	
	public List<Site> getListSite();
		
}
