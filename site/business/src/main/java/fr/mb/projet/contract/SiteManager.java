package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;
import fr.mb.projet.recherche.RechercheSite;

/**
 * Interface manager des Site
 * @author Morgan
 *
 */
public interface SiteManager {

	public Site getSite (Integer siteId) throws NotFoundException;
	
	public List<Site> getListSite(Integer nbPage,Integer start);
	
	public List<Object> getListSiteRecherche(Integer nbPage,Integer start,RechercheSite recherche);

	public void insert(Site site) throws FunctionalException, TechnicalException;

	public void update(Site site);

	public Integer getCount(Integer pageSize, Integer start);
	
	public Integer getCountRecherche(Integer pageSize, Integer start, RechercheSite recherche);

	public List<Site> doOffSet(List<Site> listSite, Integer start, Integer pageSize);
		
}
