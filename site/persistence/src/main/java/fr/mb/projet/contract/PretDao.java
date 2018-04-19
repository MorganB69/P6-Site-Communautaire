package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.bean.topo.Topo;

public interface PretDao {
	
	/**
	 * Persister  en bd
	 * @param  � ins�rer en bd
	 */
	public void persist(Pret pret);
	
	/**
	 * Mettre � jour  en bd
	 * @param  � mettre � jour en bd
	 */
	public void update(Pret pret);
	
	/**
	 * Trouver le pret en fonction de son id
	 * @param pret pour trouver le site
	 * @return le pret trouv�
	 */
	public Pret findById(int id);
	
	/**
	 * Supprimer le topo de la bd
	 * @param topo
	 */
	public void delete(Pret pret);
	
	/**
	 * R�cup�re une liste de Pret en bd
	 * @param nbPage permet de d�finir la limite
	 * @param start permet de d�finir l'offset
	 * @return une liste de Topo
	 */

	public List<Pret> findAllPret();
	
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
