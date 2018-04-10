package fr.mb.projet.contract;

import java.util.List;
import java.util.Set;

import fr.mb.projet.bean.detail.State;
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
	
	public List<T> findListInDB();

	public List<T> findById(Integer id);

	public List<T> findByIdDb(Integer id);
	

}
