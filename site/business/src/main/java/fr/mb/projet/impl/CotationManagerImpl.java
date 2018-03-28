package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;
import fr.mb.projet.contract.DetailManager;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;


@Named("cotationManager")
@Service
@Transactional
public class CotationManagerImpl implements DetailManager<ListCot> {

	@Inject
	DetailDao<ListCot> cotationDao;
	
	@Override
	@Transactional
	public ListCot getDetail(Integer detailId) throws NotFoundException {
		ListCot vCotation=cotationDao.findById(detailId);
		
		
		return vCotation;
	}

	@Override
	@Transactional
	public List<ListCot> getDetailList() {
		List<ListCot>list=cotationDao.findAll();
		return list;
	}

	@Override
	public void insert(ListCot detail) throws FunctionalException, TechnicalException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ListCot detail) {
		// TODO Auto-generated method stub
		
	}

}
