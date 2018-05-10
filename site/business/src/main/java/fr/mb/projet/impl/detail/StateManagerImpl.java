package fr.mb.projet.impl.detail;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;
import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;


/**
 * Manager pour l'obtention des regions
 * @author Morgan
 *
 */
@Named("stateManager")
@Service
@Transactional
public class StateManagerImpl implements DetailManager<State> {

	/**
	 * Dao pour l'obtention des données
	 */
	@Inject
	DetailDao<State> stateDao;
	

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailManager#getDetailList()
	 */
	@Override
	@Transactional
	public List<State> getDetailList() {
		List<State>list=stateDao.findAll();
		return list;
	}


	@Override
	public List<State> getDetailListById(Integer Id) {
		List<State>list=stateDao.findById(Id);
		return list;
	}


	@Override
	public List<State> getDetailListDb() {
		List<State>list=stateDao.findListInDB();		
		return list;
	}


	@Override
	public List<State> getDetailListByIdDb(Integer Id) {
		List<State>list=stateDao.findByIdDb(Id);
		return list;
	}



}
