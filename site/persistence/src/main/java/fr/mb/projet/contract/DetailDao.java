package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;

/**
 * Interface générique pour l'obtention des listes de détails d'un site (Listes fixes ex: Orientation etc.)
 * @author Morgan
 *
 * @param <T>
 */
public interface DetailDao<T> {
	
	
	
	/**
	 * Méthode pour l'obtention de la liste en bd
	 * @return
	 */
	public List<T> findAll();
	

}
