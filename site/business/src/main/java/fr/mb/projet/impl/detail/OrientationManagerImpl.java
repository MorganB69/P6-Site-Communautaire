package fr.mb.projet.impl.detail;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * Manager pour l'obtention des Orientations
 * @author Morgan
 *
 */
@Named("orientationManager")
@Service
@Transactional
public class OrientationManagerImpl implements DetailManager<Orientation> {

	/**
	 *DAO pour les Orientations 
	 */
	@Inject
	DetailDao<Orientation> orientationDao;
	

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailManager#getDetailList()
	 */
	@Override
	@Transactional
	public List<Orientation> getDetailList() {
		List<Orientation>list=orientationDao.findAll();
		return list;
	}


	@Override
	public List<Orientation> getDetailListById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Orientation> getDetailListDb() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Orientation> getDetailListByIdDb(Integer paysIdOut) {
		// TODO Auto-generated method stub
		return null;
	}



}
