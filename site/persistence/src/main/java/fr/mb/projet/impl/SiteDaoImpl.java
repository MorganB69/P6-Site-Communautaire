package fr.mb.projet.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.recherche.RechercheSite;

/**
 * Implémentation de la DAO pour les classes de Site
 * 
 * @author Morgan
 *
 */
@Named("siteDao")
@Transactional
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
	

	public SiteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#persist(fr.mb.projet.bean.spot.Site)
	 */
	@Override
	@Transactional
	public void persist(Site site) {

		template.save(site);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#update(fr.mb.projet.bean.spot.Site)
	 */
	@Override
	public void update(Site entity) {
		// TODO Auto-generated method stub
		template.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#findById(int)
	 */
	@Override
	@Transactional
	public Site findById(int id) {
		Site e = (Site) template.get(fr.mb.projet.bean.spot.Site.class, id);
		return e;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#delete(fr.mb.projet.bean.spot.Site)
	 */
	@Override
	public void delete(Site entity) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#findAll(java.lang.Integer,
	 * java.lang.Integer)
	 */
	@Override
	public List<Site> findAll(Integer nbPage, Integer start) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Site ORDER BY id DESC");

		query.setFirstResult(start);
		query.setMaxResults(nbPage);

		List<Site> list = query.list();

		session.close();

		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.SiteDao#getCount()
	 */
	@Override
	public Long getCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String countQ = "SELECT COUNT(*) FROM Site";
		Query countQuery = session.createQuery(countQ);
		Long countResults = (Long) countQuery.uniqueResult();

		session.close();
		return countResults;
	}

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.SiteDao#recherche(java.lang.Integer, java.lang.Integer, fr.mb.projet.recherche.RechercheSite)
	 */
	@Override
	public List<Site> recherche(Integer nbPage, Integer offset, RechercheSite recherche) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Site> allSite=new ArrayList<Site>();
		List<Site> listAltMin=new ArrayList<Site>();
		List<Site> listAltMax=new ArrayList<Site>();
		List<Site> listCotMin=new ArrayList<Site>();
		List<Site> listCotMax=new ArrayList<Site>();
		List<Site> listOrient=new ArrayList<Site>();
		List<Site> listPays=new ArrayList<Site>();
		List<Site> listState=new ArrayList<Site>();
		List<Site> listType=new ArrayList<Site>();
		
		//PAR DEFAUT TOUS LES SITES
		
		Query queryGeneral = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
				+ " WHERE (altitude.typeAlt=(:altMinType) AND altitude.alt>(:altMin) "
				+ " AND site.id IN (SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
			    + "	WHERE (altitude.typeAlt=(:altMaxType) AND altitude.alt<(:altMax))))"
				+ " ORDER BY site.id DESC");
		
		queryGeneral.setParameter("altMinType", "min");
		queryGeneral.setParameter("altMin", recherche.getrAltMin());
		queryGeneral.setParameter("altMaxType", "max");
		queryGeneral.setParameter("altMax", recherche.getrAltMax());
		allSite=queryGeneral.getResultList();
		
		
		
		
		
		
		
		
		/*
		
		
		Query queryAllSite = session.createQuery("SELECT site FROM Site as site ORDER BY site.id DESC");
		allSite=queryAllSite.getResultList();
		
		//ALTITUDE MINIMUM
		if(recherche.getrAltMin()!=null) {
		Query queryAltMin = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
				+ " WHERE (altitude.typeAlt=(:altMinType) AND altitude.alt>(:altMin))"
				+ " ORDER BY site.id DESC");
		
		queryAltMin.setParameter("altMinType", "min");
		queryAltMin.setParameter("altMin", recherche.getrAltMin());
		listAltMin = queryAltMin.getResultList();}
		else listAltMin=allSite;
		
		
		//ALTITUDE MAXIMUM
		if(recherche.getrAltMax()!=null) {
		Query queryAltMax = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
				+ " WHERE (altitude.typeAlt=(:altMaxType) AND altitude.alt<(:altMax))"
				+ " ORDER BY site.id DESC");
				
		queryAltMax.setParameter("altMaxType", "max");
		queryAltMax.setParameter("altMax", recherche.getrAltMax());
		listAltMax = queryAltMax.getResultList();}
		else listAltMax=allSite;
		
		
		//COTATION MAXIMUM
		Query queryCotMax = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeCotation as cotation"
				+ " WHERE (cotation.typeCot=(:cotMaxType) AND cotation.cot.id<=(:cotMax))"
				+ " ORDER BY site.id DESC");
		
		queryCotMax.setParameter("cotMaxType", "max");
		queryCotMax.setParameter("cotMax", recherche.getrCotMax());
		listCotMax = queryCotMax.getResultList();
		
		//COTATION MINIMUM
		Query queryCotMin = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeCotation as cotation"
				+ " WHERE (cotation.typeCot=(:cotMinType) AND cotation.cot.id>=(:cotMin))"
				+ " ORDER BY site.id DESC");
		
		queryCotMin.setParameter("cotMinType", "min");
		queryCotMin.setParameter("cotMin", recherche.getrCotMin());
		listCotMin = queryCotMin.getResultList();
		
		//ORIENTATION
		if(recherche.getrOrient()!=10000) {
		Query queryOrient = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeOrientation as orientation"
				+ " WHERE (orientation.id=(:orient))"
				+ " ORDER BY site.id DESC");
		
		queryOrient.setParameter("orient", recherche.getrOrient());
		
		listOrient = queryOrient.getResultList();}
		else listOrient=allSite;
		
		//PAYS
		if(recherche.getrPays()!=10000) {
		Query queryPays = session.createQuery("SELECT site FROM Site as site"
				+ " WHERE (pays.id=(:id))"
				+ " ORDER BY site.id DESC");
		
		queryPays.setParameter("id", recherche.getrPays());
		
		listPays = queryPays.getResultList();}
		else listPays=allSite;
		
		//STATE
		if(recherche.getrDepartement()!=10000) {
		Query queryState = session.createQuery("SELECT site FROM Site as site"
				+ " WHERE (state.id=(:id))"
				+ " ORDER BY site.id DESC");
		
		queryState.setParameter("id", recherche.getrDepartement());
		
		listState = queryState.getResultList();}
		else listState=allSite;
		

		
		
		List <Site> listReturn=new ArrayList<Site>();
		
		//RECHERCHE DES SITES CORRESPONDANT AUX RECHERCHES
		for (Iterator iterator = listAltMin.iterator(); iterator.hasNext();) {
			Site site = (Site) iterator.next();
			
			if (listAltMax.contains(site)) {
				if(listCotMax.contains(site)){
					if(listCotMin.contains(site)) {
						if(listOrient.contains(site)) {
							if(listPays.contains(site)) {
								if(listState.contains(site)) {
									listReturn.add(site);
								}
							}
							
						}
						
					}
									
				}
			}
			
		}

		//query.setFirstResult(offset);
		//query.setMaxResults(nbPage);
		

		//List<Site> list = query.getResultList();
		*/

		session.close();
		
		
		return allSite;
	}

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.SiteDao#getCountRecherche()
	 */
	@Override
	public Long getCountRecherche() {
		// TODO Auto-generated method stub
		return null;
	}

}
