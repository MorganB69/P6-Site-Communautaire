package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;
import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;


@Named("orientationManager")
@Service
@Transactional
public class OrientationManagerImpl implements DetailManager<Orientation> {

	@Inject
	DetailDao<Orientation> orientationDao;
	
	@Override
	@Transactional
	public Orientation getDetail(Integer detailId) throws NotFoundException {
		Orientation vOrientation=orientationDao.findById(detailId);
		
		
		return vOrientation;
	}

	@Override
	@Transactional
	public List<Orientation> getDetailList() {
		List<Orientation>list=orientationDao.findAll();
		return list;
	}

	@Override
	public void insert(Orientation detail) throws FunctionalException, TechnicalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Orientation detail) {
		// TODO Auto-generated method stub
		
	}

}
