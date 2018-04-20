package fr.mb.projet.contract;

import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public interface PretManager {
	
	public Pret getTopo (Integer pretId) throws NotFoundException;
	
	public void insert(Pret pret) throws FunctionalException, TechnicalException;

	public void update(Pret pret);
	
	public void delete(Pret pret);
	

}
