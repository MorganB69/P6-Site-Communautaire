package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

/**
 * Interface pour l'obtention d'une liste de détails d'un site
 * @author Morgan
 *
 * @param <T>
 */
public interface DetailManager <T> {
	
	
	
	/**
	 * Obtenir la liste
	 * @return
	 */
	public List<T> getDetailList();

	public List<T> getDetailListById(Integer Id);
	
	public List<T> getDetailListDb();

	public List<T> getDetailListByIdDb(Integer paysIdOut);



}
