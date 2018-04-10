package fr.mb.projet.contract;

import java.util.List;
import java.util.Set;

import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;

/**
 * Interface g�n�rique pour l'obtention des listes de d�tails d'un site (Listes fixes ex: Orientation etc.)
 * @author Morgan
 *
 * @param <T>
 */
public interface DetailDao<T> {
	
	
	
	/**
	 * M�thode pour l'obtention de la liste en bd
	 * @return
	 */
	public List<T> findAll();
	
	public List<T> findListInDB();

	public List<T> findById(Integer id);

	public List<T> findByIdDb(Integer id);
	

}
