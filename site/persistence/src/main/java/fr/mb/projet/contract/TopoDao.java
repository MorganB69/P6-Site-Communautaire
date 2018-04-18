package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;

public interface TopoDao {
	
	/**
	 * Persister le topo en bd
	 * @param topo � ins�rer en bd
	 */
	public void persist(Topo topo);
	
	/**
	 * Mettre � jour le topo en bd
	 * @param topo � mettre � jour en bd
	 */
	public void update(Topo topo);
	
	/**
	 * Trouver le topo en fonction de son id
	 * @param topo pour trouver le site
	 * @return le topo trouv�
	 */
	public Topo findById(int id);
	
	/**
	 * Supprimer le topo de la bd
	 * @param topo
	 */
	public void delete(Topo topo);
	
	/**
	 * R�cup�re une liste de topo en bd
	 * @param nbPage permet de d�finir la limite
	 * @param start permet de d�finir l'offset
	 * @return une liste de Topo
	 */
	public List<Topo> findAll(Integer nbPage, Integer start);
	
	/**
	 * R�cup�re une liste de topo en bd
	 * @return une liste de Topo
	 */
	public List<Topo> findAllTopo();
	
	/**
	 * Supprime tous les topo en base de donn�e
	 * 
	 */
	
	
	public void deleteAll();

	/**
	 * Compte le nombre d'objet en base de donn�e
	 * @return le nombre d'objets trouv�s
	 */
	public Long getCount();


}
