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
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao<Site,Integer> {
	
	private Session currentSession;
	
	private Transaction currentTransaction;
	
    
    public SiteDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    




	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = (Transaction) currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		try {
			currentTransaction.commit();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public void persist(Site entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Site entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site findById(Integer id) {
		Site site = (Site) getCurrentSession().get(Site.class, id);

		return site;
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
