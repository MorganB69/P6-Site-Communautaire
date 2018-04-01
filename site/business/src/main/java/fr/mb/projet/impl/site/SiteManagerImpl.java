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


@Named("siteManager")
@Service
@Transactional
public class SiteManagerImpl implements SiteManager {

	
	
	@Inject
	SiteDao siteDao;
	
	RechercheSite rechercheSite = new RechercheSite();
	
	
	
	public SiteManagerImpl() {
		
	}
	

	@Override
	@Transactional
	public Site getSite(Integer siteId) throws NotFoundException {
		
		
		Site vSite=siteDao.findById(siteId);
		
		
		return vSite;
	}
	@Override
	public List<Site> getListSite() {
		
		
		List<Site>list=siteDao.findAll();
		
		return list;
	
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







	@Override
	@Transactional
	public void insert(Site site) throws FunctionalException {
		
        if (site == null) {
            throw new FunctionalException("Le site est null !");
        }
        
        siteDao.persist(site);

	}







	@Override
	public void update(Site site) {
		 siteDao.update(site);
		
	}
	

}
