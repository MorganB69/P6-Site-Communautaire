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
 * Manager pour l'obtention des pays
 * @author Morgan
 *
 */
@Named("paysManager")
@Service
@Transactional
public class PaysManagerImpl implements DetailManager<Pays> {

	/**
	 * Dao pour l'obtention des données
	 */
	@Inject
	DetailDao<Pays> paysDao;
	

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailManager#getDetailList()
	 */
	@Override
	@Transactional
	public List<Pays> getDetailList() {
		List<Pays>list=paysDao.findAll();
		return list;
	}


	@Override
	public List<Pays> getDetailListById(Integer Id) {
		
		return null;
	}


	@Override
	@Transactional
	public List<Pays> getDetailListDb() {
		List<Pays>list=paysDao.findListInDB();
		return list;
	}


	@Override
	public List<Pays> getDetailListByIdDb(Integer paysIdOut) {
		// TODO Auto-generated method stub
		return null;
	}



}
