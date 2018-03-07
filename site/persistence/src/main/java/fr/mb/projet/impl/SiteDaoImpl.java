package fr.mb.projet.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import fr.mb.projet.bean.Site;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.recherche.RechercheSite;

@Component
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {
	
    
    public int getCountSite(RechercheSite pRechercheSite) {
        String vSQL
            = "SELECT COUNT(*) FROM site";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrSite = vJdbcTemplate.queryForObject(
            vSQL, Integer.class);
           

        return vNbrSite;
    
}
    
    
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
    

    
    
}
