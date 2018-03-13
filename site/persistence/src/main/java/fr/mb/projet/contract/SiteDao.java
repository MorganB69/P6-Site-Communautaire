package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.recherche.RechercheSite;

public interface SiteDao<T,Id extends Serializable>{

	public void persist(T entity);
	
	public void update(T entity);
	
	public T findById(Id id);
	
	public void delete(T entity);
	
	public List<T> findAll();
	
	public void deleteAll();

	public Session openCurrentSession();

	public void closeCurrentSession();

}
