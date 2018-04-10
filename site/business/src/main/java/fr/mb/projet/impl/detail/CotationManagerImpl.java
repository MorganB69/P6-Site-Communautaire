package fr.mb.projet.impl.detail;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;
import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;


/**
 * Manager pour l'obtention des cotations
 * @author Morgan
 *
 */
@Named("cotationManager")
@Service
@Transactional
public class CotationManagerImpl implements DetailManager<ListCot> {

	/**
	 * Dao pour l'obtention des données
	 */
	@Inject
	DetailDao<ListCot> cotationDao;
	

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailManager#getDetailList()
	 */
	@Override
	@Transactional
	public List<ListCot> getDetailList() {
		List<ListCot>list=cotationDao.findAll();
		return list;
	}


	@Override
	public List<ListCot> getDetailListById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ListCot> getDetailListDb() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ListCot> getDetailListByIdDb(Integer paysIdOut) {
		// TODO Auto-generated method stub
		return null;
	}



}
