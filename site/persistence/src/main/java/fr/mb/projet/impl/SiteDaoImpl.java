package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;

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

}
