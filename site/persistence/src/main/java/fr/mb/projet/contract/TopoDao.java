package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;

public interface TopoDao {
	
	/**
	 * Persister le topo en bd
	 * @param topo à insérer en bd
	 */
	public void persist(Topo topo);
	
	/**
	 * Mettre à jour le topo en bd
	 * @param topo à mettre à jour en bd
	 */
	public void update(Topo topo);
	
	/**
	 * Trouver le topo en fonction de son id
	 * @param topo pour trouver le site
	 * @return le topo trouvé
	 */
	public Topo findById(int id);
	
	/**
	 * Supprimer le topo de la bd
	 * @param topo
	 */
	public void delete(Topo topo);
	
	/**
	 * Récupère une liste de topo en bd
	 * @param nbPage permet de définir la limite
	 * @param start permet de définir l'offset
	 * @return une liste de Topo
	 */
	public List<Topo> findAll(Integer nbPage, Integer start);
	
	/**
	 * Récupère une liste de topo en bd
	 * @return une liste de Topo
	 */
	public List<Topo> findAllTopo();
	
	/**
	 * Supprime tous les topo en base de donnée
	 * 
	 */
	
	
	public void deleteAll();

	/**
	 * Compte le nombre d'objet en base de donnée
	 * @return le nombre d'objets trouvés
	 */
	public Long getCount();


}
