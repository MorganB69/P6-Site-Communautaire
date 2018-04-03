package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.recherche.RechercheSite;

public interface SiteDao extends Serializable{
	
	
	public void persist(Site site);
	
	public void update(Site entity);
	
	public Site findById(int id);
	
	public void delete(Site entity);
	
	public List<Site> findAll(Integer nbPage, Integer start);
	
	public void deleteAll();

	public Long getCount();

	
}
