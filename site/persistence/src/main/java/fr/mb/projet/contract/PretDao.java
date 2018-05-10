package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.bean.topo.Topo;

public interface PretDao {
	
	/**
	 * Persister  en bd
	 * @param  à insérer en bd
	 */
	public void persist(Pret pret);
	
	/**
	 * Mettre à jour  en bd
	 * @param  à mettre à jour en bd
	 */
	public void update(Pret pret);
	
	/**
	 * Trouver le pret en fonction de son id
	 * @param pret pour trouver le site
	 * @return le pret trouvé
	 */
	public Pret findById(int id);
	
	/**
	 * Supprimer le topo de la bd
	 * @param topo
	 */
	public void delete(Pret pret);
	
	/**
	 * Récupère une liste de Pret en bd
	 * @param nbPage permet de définir la limite
	 * @param start permet de définir l'offset
	 * @return une liste de Topo
	 */

	public List<Pret> findAllPret();
	
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
