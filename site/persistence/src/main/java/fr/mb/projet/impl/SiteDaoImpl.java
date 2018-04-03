package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;


@Named("siteDao")
@Transactional
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	

	
    
    public SiteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	@Override
	@Transactional
	public void persist(Site site) {
		
		template.save(site);

		
		
	}

	@Override
	public void update(Site entity) {
		// TODO Auto-generated method stub
		template.update(entity);
	}

	@Override
	@Transactional
	public Site findById(int id) {
		Site e=(Site)template.get(fr.mb.projet.bean.spot.Site.class,id);  
	    return e;

		
	}

	@Override
	public void delete(Site entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Site> findAll(Integer nbPage, Integer start) {
		
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		Query query=session.createQuery("FROM Site ORDER BY id DESC");
		
		query.setFirstResult(start);
		query.setMaxResults(nbPage);
		

		
		List<Site>list=query.list();
		
		 session.close();
		
		return list;
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Long getCount() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		String countQ = "SELECT COUNT(*) FROM Site";
	    Query countQuery = session.createQuery(countQ);
	    Long countResults = (Long) countQuery.uniqueResult();
	 
	    
	    session.close();
		return countResults;
	}
    
    
    
    
    
    
    
    
    
/*
    @Override
	public int getCountSite(RechercheSite pRechercheSite) {
        String vSQL
            = "SELECT COUNT(*) FROM site";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrSite = vJdbcTemplate.queryForObject(
            vSQL, Integer.class);
           

        return vNbrSite;
    
}
    
    @Override
    public Site getSite(int SiteId) {
        String vSQL
            = "SELECT * FROM site WHERE site_id="+SiteId+"";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        
        RowMapper<Site> vRowMapper = new RowMapper<Site>() {
            public Site mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Site vSite = new Site(pRS.getInt("site_id"));
                vSite.setDescription(pRS.getString("description"));
                return vSite;
            }
        };
        
        Site site = vJdbcTemplate.queryForObject(
            vSQL, vRowMapper);
           

        return site;	
    
}
    
*/
    
    
}
