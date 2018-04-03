package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public interface SiteManager {

	public Site getSite (Integer siteId) throws NotFoundException;
	
	public List<Site> getListSite(Integer nbPage,Integer start);

	public void insert(Site site) throws FunctionalException, TechnicalException;

	public void update(Site site);

	public Integer getCount(Integer pageSize, Integer start);
		
}
