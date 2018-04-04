package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.recherche.RechercheSite;

/**
 * Interface pour la DAO relative à la classe Site
 * @author Morgan
 *
 */
public interface SiteDao extends Serializable{
	
	
	/**
	 * Persister le site en bd
	 * @param site à insérer en bd
	 */
	public void persist(Site site);
	
	/**
	 * Mettre à jour le site en bd
	 * @param site à mettre à jour en bd
	 */
	public void update(Site site);
	
	/**
	 * Trouver le site en fonction de son id
	 * @param id pour trouver le site
	 * @return le site trouvé
	 */
	public Site findById(int id);
	
	/**
	 * Supprimer le site de la bd
	 * @param site
	 */
	public void delete(Site site);
	
	/**
	 * Récupère une liste de site en bd
	 * @param nbPage permet de définir la limite
	 * @param start permet de définir l'offset
	 * @return une liste de Site
	 */
	public List<Site> findAll(Integer nbPage, Integer start);
	
	/**
	 * Supprime tous les sites en base de donnée
	 * 
	 */
	public void deleteAll();

	/**
	 * Compte le nombre d'objet en base de donnée
	 * @return le nombre d'objets trouvés
	 */
	public Long getCount();

	
}
