package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.recherche.RechercheSite;

/**
 * Interface pour la DAO relative � la classe Site
 * @author Morgan
 *
 */
public interface SiteDao extends Serializable{
	
	
	/**
	 * Persister le site en bd
	 * @param site � ins�rer en bd
	 */
	public void persist(Site site);
	
	/**
	 * Mettre � jour le site en bd
	 * @param site � mettre � jour en bd
	 */
	public void update(Site site);
	
	/**
	 * Trouver le site en fonction de son id
	 * @param id pour trouver le site
	 * @return le site trouv�
	 */
	public Site findById(int id);
	
	/**
	 * Supprimer le site de la bd
	 * @param site
	 */
	public void delete(Site site);
	
	/**
	 * R�cup�re une liste de site en bd
	 * @param nbPage permet de d�finir la limite
	 * @param start permet de d�finir l'offset
	 * @return une liste de Site
	 */
	public List<Site> findAll(Integer nbPage, Integer start);
	
	/**
	 * Supprime tous les sites en base de donn�e
	 * 
	 */
	public void deleteAll();

	/**
	 * Compte le nombre d'objet en base de donn�e
	 * @return le nombre d'objets trouv�s
	 */
	public Long getCount();

	
}
