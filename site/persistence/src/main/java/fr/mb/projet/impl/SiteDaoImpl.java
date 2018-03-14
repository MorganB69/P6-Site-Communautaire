package fr.mb.projet.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.recherche.RechercheSite;


@Named("siteDao")
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	

	
    
    public SiteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
	@Override
	public void persist(Site entity) {
		template.save(entity);
		
	}

	@Override
	public void update(Site entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site findById(int id) {
		Site e=(Site)template.get(fr.mb.projet.bean.spot.Site.class,id);  
	    return e;

		
	}

	@Override
	public void delete(Site entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
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
