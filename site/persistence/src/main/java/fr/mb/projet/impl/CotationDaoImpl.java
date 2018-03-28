package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

@Named("cotationDao")
@Transactional
public class CotationDaoImpl extends AbstractDaoImpl implements DetailDao<ListCot> {

	@Override
	public void persist(ListCot detail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(ListCot detail) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@Transactional
	public ListCot findById(int id) {
		ListCot e=(ListCot)template.get(fr.mb.projet.bean.detail.ListCot.class,id);  
	    return e;
	}

	@Override
	public void delete(ListCot detail) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<ListCot> findAll() {
		List<ListCot>list=template.loadAll(ListCot.class);
		return list;
	}

}
