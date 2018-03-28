package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public interface DetailManager <T> {
	
	public T getDetail (Integer detailId) throws NotFoundException;
	
	public List<T> getDetailList();

	public void insert(T detail) throws FunctionalException, TechnicalException;

	public void update(T detail);

}
