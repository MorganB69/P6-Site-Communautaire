package fr.mb.projet.impl.topo;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.contract.PretDao;
import fr.mb.projet.contract.PretManager;
import fr.mb.projet.contract.TopoDao;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

@Named("pretManager")
@Service
@Transactional
public class PretManagerImpl implements PretManager{
	
	@Inject
	PretDao pretDao;

	@Override
	public Pret getTopo(Integer pretId) throws NotFoundException {
		Pret vPret = pretDao.findById(pretId);
		return vPret;
	}

	@Override
	public void insert(Pret pret) throws FunctionalException, TechnicalException {
		if (pret == null) {
			throw new FunctionalException("Le pret est null !");
		}

		pretDao.persist(pret);
	}

	@Override
	public void update(Pret pret) {
		pretDao.update(pret);
		
	}

	@Override
	public void delete(Pret pret) {
		pretDao.delete(pret);
		
	}

}
