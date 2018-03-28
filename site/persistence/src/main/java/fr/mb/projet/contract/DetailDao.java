package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;

public interface DetailDao<T> {
	
	public void persist(T detail);
	
	public void update(T detail);
	
	public T findById(int id);
	
	public void delete(T detail);
	
	public List<T> findAll();
	
	public void deleteAll();
}
