package fr.mb.projet.impl.site;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.SiteManager;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;
import fr.mb.projet.recherche.RechercheSite;

/**
 * Manager pour la gestion des Site
 * 
 * @author Morgan
 *
 */
@Named("siteManager")
@Service
@Transactional
public class SiteManagerImpl implements SiteManager {

	/**
	 * DAO pour la classe Site
	 */
	@Inject
	SiteDao siteDao;

	public SiteManagerImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteManager#getSite(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Site getSite(Integer siteId) throws NotFoundException {

		Site vSite = siteDao.findById(siteId);

		return vSite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteManager#getListSite(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Site> getListSite(Integer nbPage, Integer start) {

		Integer offset = (start - 1) * nbPage;
		List<Site> list = siteDao.findAll(nbPage, offset);

		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteManager#insert(fr.mb.projet.bean.spot.Site)
	 */
	@Override
	@Transactional
	public void insert(Site site) throws FunctionalException {

		if (site == null) {
			throw new FunctionalException("Le site est null !");
		}

		siteDao.persist(site);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteManager#update(fr.mb.projet.bean.spot.Site)
	 */
	@Override
	public void update(Site site) {
		siteDao.update(site);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteManager#getCount(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public Integer getCount(Integer pageSize, Integer start) {
		Long nbSite = siteDao.getCount();

	
		double page = (double) pageSize;

		double lastPageNumber = (Math.ceil(nbSite / page));

		int value = (int) lastPageNumber;
		return value;
	}
	
	@Override
	public List<Object> getListSiteRecherche(Integer nbPage, Integer start, RechercheSite recherche) {
		int offset;
		
		//Calcul de l'offset
		if(start!=0) {
			offset = (start - 1) * nbPage;
		}
		else offset=0;
		
		List<Site>list=new ArrayList<Site>();

		
		list = siteDao.recherche(nbPage, offset,recherche);
		

		double page = (double) nbPage;
		double lastPageNumber = (Math.ceil(list.size() / page));
		int valuePage = (int) lastPageNumber;
		
		ArrayList<Object> returnList=new ArrayList();
		returnList.add(valuePage);
		returnList.add(list);
		
		
		return returnList;
	}
	
	public List<Site> doOffSet(List<Site>list, Integer start, Integer nbPage){
		int offset;		
		//Calcul de l'offset
		if(start!=0) {
			offset = (start - 1) * nbPage;
		}
		else offset=0;
		List<Site> listOffset= new ArrayList<Site>();
		//Application de l'offset
		if(list.size()>(offset+nbPage))	{
		for (int i = offset; i < offset+nbPage; i++) {
			if(list.get(i)!=null)listOffset.add(list.get(i));
		}}
		else {
			for(int i = offset; i < list.size(); i++) {
				if(list.get(i)!=null)listOffset.add(list.get(i));
		}}
		
		return listOffset;
		
	}

	@Override
	public Integer getCountRecherche(Integer pageSize, Integer start, RechercheSite recherche) {
		Long nbSite = siteDao.getCountRecherche();

		double page = (double) pageSize;

		double lastPageNumber = (Math.ceil(nbSite / page));

		int value = (int) lastPageNumber;
		return value;
	}
	
	

	// Getters et Setters

	public SiteDao getSiteDao() {
		return siteDao;
	}

	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}





}
