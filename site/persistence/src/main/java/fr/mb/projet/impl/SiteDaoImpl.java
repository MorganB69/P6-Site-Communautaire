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
	@Transactional
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

	/* 
	 * Méthode de recherche de site en fonction de multicritères
	 * Méthode décomposée en plusieurs "sous-requêtes" appelée si le critère est renseigné
	 * Chaque méthode renvoie une liste de Site que l'on compare à la liste de la requête précédente
	 * pour filtrer les sites puis renvoie une liste finale
	 * 
 	 */
	@Override
	public List<Site> recherche(Integer nbPage, Integer offset, RechercheSite recherche) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//CREATION DES LISTES POUR CHAQUE SOUS REQUETE
		List<Site> listAltMax=new ArrayList<Site>();
		List<Site> listCotMin=new ArrayList<Site>();
		List<Site> listCotMax=new ArrayList<Site>();
		List<Site> listOrient=new ArrayList<Site>();
		List<Site> listPays=new ArrayList<Site>();
		List<Site> listState=new ArrayList<Site>();
		List<Site> listType=new ArrayList<Site>();
		List<Site>listReturn=new ArrayList<Site>();
		
		
		
		//QUERY POUR TOUS LES SITES
		Query queryAllSite = session.createQuery("SELECT site FROM Site as site ORDER BY site.id DESC");
		
		
		//ALTITUDE MINIMUM (Requête lancée si le crière est renseigné)
		if(recherche.getrAltMin()!=null) {
		Query queryAltMin = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
				+ " WHERE (altitude.typeAlt=(:altMinType) AND altitude.alt>(:altMin))"
				+ " ORDER BY site.id DESC");
		
		queryAltMin.setParameter("altMinType", "min");
		queryAltMin.setParameter("altMin", recherche.getrAltMin());
		listReturn = queryAltMin.getResultList();}
		
		
		
		//ALTITUDE MAXIMUM (Requête lancée si le critère est renseigné)
		if(recherche.getrAltMax()!=null) {
		Query queryAltMax = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeAltitude as altitude"
				+ " WHERE (altitude.typeAlt=(:altMaxType) AND altitude.alt<(:altMax))"
				+ " ORDER BY site.id DESC");
				
		queryAltMax.setParameter("altMaxType", "max");
		queryAltMax.setParameter("altMax", recherche.getrAltMax());
		listAltMax = queryAltMax.getResultList();
		if(listReturn.isEmpty())listReturn=listAltMax;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listAltMax.contains(s)==false)iterator.remove();
		}}}
		
		
		
		//COTATION MAXIMUM (Requête lancée si le critère est renseigné)
		Query queryCotMax = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeCotation as cotation"
				+ " WHERE (cotation.typeCot=(:cotMaxType) AND cotation.cot.id<=(:cotMax))"
				+ " ORDER BY site.id DESC");
		
		queryCotMax.setParameter("cotMaxType", "max");
		queryCotMax.setParameter("cotMax", recherche.getrCotMax());
		listCotMax = queryCotMax.getResultList();
		if(listReturn.isEmpty())listReturn=listCotMax;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listCotMax.contains(s)==false)iterator.remove();
		}}
		
		//COTATION MINIMUM (Requête lancée si le critère est renseigné)
		Query queryCotMin = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeCotation as cotation"
				+ " WHERE (cotation.typeCot=(:cotMinType) AND cotation.cot.id>=(:cotMin))"
				+ " ORDER BY site.id DESC");
		
		queryCotMin.setParameter("cotMinType", "min");
		queryCotMin.setParameter("cotMin", recherche.getrCotMin());
		listCotMin = queryCotMin.getResultList();
		if(listReturn.isEmpty())listReturn=listCotMin;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listCotMin.contains(s)==false)iterator.remove();
		}}
		
		//ORIENTATION (Requête lancée si le critère est spécifié)
		if(recherche.getrOrient()!=10000) {
		Query queryOrient = session.createQuery("SELECT site FROM Site as site"
				+ " JOIN site.listeOrientation as orientation"
				+ " WHERE (orientation.id=(:orient))"
				+ " ORDER BY site.id DESC");
		
		queryOrient.setParameter("orient", recherche.getrOrient());
		
		listOrient = queryOrient.getResultList();
		if(listReturn.isEmpty())listReturn=listOrient;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listOrient.contains(s)==false)iterator.remove();
		}}}
		
		
		//PAYS (Requête lancée si le critère est renseigné)

		if(recherche.getrPays()!=10000) {
		Query queryPays = session.createQuery("SELECT site FROM Site as site"
				+ " WHERE (pays.id=(:id))"
				+ " ORDER BY site.id DESC");
		
		queryPays.setParameter("id", recherche.getrPays());
		
		listPays = queryPays.getResultList();
		System.out.println("PAYSTAILLE"+ listPays.size());
		if(listReturn.isEmpty())listReturn=listPays;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listPays.contains(s)==false)iterator.remove();
		}}}
		
		
		//STATE (Requête lancée si le critère est renseigné)
		if(recherche.getrDepartement()!=10000) {
		Query queryState = session.createQuery("SELECT site FROM Site as site"
				+ " WHERE (state.id=(:id))"
				+ " ORDER BY site.id DESC");
		
		queryState.setParameter("id", recherche.getrDepartement());
		
		listState = queryState.getResultList();
		System.out.println("STATETAILLE"+ listPays.size());
		if(listReturn.isEmpty())listReturn=listState;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listState.contains(s)==false)iterator.remove();
		}}}
		
		
		//TYPE (Requête lancée si le critère est renseigné)
		if(recherche.getrType().equals("ALL")==false) {
		Query queryType = session.createQuery("SELECT site FROM Site as site"
				+ " WHERE (site.type=(:type))"
				+ " ORDER BY site.id DESC");

		queryType.setParameter("type", recherche.getrType());
		
		listType = queryType.getResultList();
		if(listReturn.isEmpty())listReturn=listType;
		else {
		for (Iterator iterator = listReturn.iterator(); iterator.hasNext();) {
			Site s = (Site) iterator.next();
			if (listType.contains(s)==false)iterator.remove();
		}}}
		

		
		

		

		session.close();
		
		
		return listReturn;
	}

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.SiteDao#getCountRecherche()
	 */
	@Override
	public Long getCountRecherche() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Site> rechercheNew(Integer nbPage, Integer offset, RechercheSite recherche) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//Liste à retourner
		List<Site>listReturn=new ArrayList<Site>();
		
		//-------------CREATION REQUETE HQL DYNAMIQUE--------------
		
		//-------------SELECTION DES SITES-------------
		String SQL = " SELECT DISTINCT site FROM Site as site ";
		
		//-------------JOINTURES OBLIGATOIRES---------------
			  SQL += " JOIN site.listeCotation as cotation ";
		
		//-------------JOINTURES FACULTATIVES----------------
		//Altitudes
		if(recherche.getrAltMax()!=null||recherche.getrAltMin()!=null) {
			  SQL += " JOIN site.listeAltitude as altitude ";
		}
		//Orientation
		if(recherche.getrOrient()!=10000) {
			  SQL += " JOIN site.listeOrientation as orientation ";
			  }
		
		//-------------CRITERE DE RECHERCHE---------------
		
		//-------------CRITERES OBLIGATOIRES---------------
		
			  SQL+=" WHERE (cotation.typeCot=(:cotMaxType) AND cotation.cot.id<=(:cotMax))";
			  
		//-----------sous requête obligatoire--------------
			  
			  SQL+=" AND site.id IN(SELECT site from Site as site "
				+ " JOIN site.listeCotation as cotation "
				+ " WHERE (cotation.typeCot=(:cotMinType) AND cotation.cot.id>=(:cotMin))) ";
			  
		//-----------CRITERES FACULTATIFS-------------------
		
		//Altitude Minimum
		if(recherche.getrAltMin()!=null) {
			SQL+=" AND (altitude.typeAlt=(:altMinType) AND altitude.alt>(:altMin)) ";}

		//Altitude Maximum
		if(recherche.getrAltMax()!=null) {
			SQL+=" AND site.id IN(SELECT site from Site as site "
				+ " JOIN site.listeAltitude as altitude "
				+ " WHERE (altitude.typeAlt=(:altMaxType) AND altitude.alt<(:altMax))) ";
		}

		//Orientation
		if(recherche.getrOrient()!=10000) {
			 SQL += " AND (orientation.id=(:orient)) ";
			  }
		
		//Pays
		if(recherche.getrPays()!=10000) {
			 SQL += " AND (site.pays.id=(:paysId)) ";
			  }
		
		//State
		if(recherche.getrDepartement()!=10000) {
			 SQL += " AND (site.state.id=(:stateId)) ";
			  }
		
		//Type
		if(recherche.getrType().equals("ALL")==false) {
			SQL += " AND (site.type=(:type)) ";
			
		}
		
		//TRI
		SQL+="  ORDER BY site.id DESC ";
		
		
		//CREATION DE LA QUERY
		Query query = session.createQuery(SQL);
		
		//PARAMETRAGE
		//----------Obligatoire-------------------------
		query.setParameter("cotMinType", "min");
		query.setParameter("cotMin", recherche.getrCotMin());
		query.setParameter("cotMaxType", "max");
		query.setParameter("cotMax", recherche.getrCotMax());
		
	
		
		//---------Conditions--------------------------
		
		// Altitude
		if(recherche.getrAltMin()!=null) {
			 query.setParameter("altMinType", "min");
			 query.setParameter("altMin", recherche.getrAltMin());
			
		}

		
		if(recherche.getrAltMax()!=null) {
			query.setParameter("altMaxType", "max");
			 query.setParameter("altMax", recherche.getrAltMax());
		}
		
		
		//Orientation
		if(recherche.getrOrient()!=10000) {
			query.setParameter("orient", recherche.getrOrient());
		}
		
		//Pays
		if(recherche.getrPays()!=10000) {
			query.setParameter("paysId", recherche.getrPays());
		}
		
		//States
		if(recherche.getrDepartement()!=10000) {
			query.setParameter("stateId", recherche.getrDepartement());
		}
		//Type
		if(recherche.getrType().equals("ALL")==false) {
			query.setParameter("type", recherche.getrType());
			
		}
		//Recherche des résultats de la Query
		listReturn=query.getResultList();		

		session.close();		
		
		return listReturn;
	}

}
