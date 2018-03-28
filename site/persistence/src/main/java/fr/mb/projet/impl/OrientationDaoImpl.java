package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

@Named("detailDao")
@Transactional
public class OrientationDaoImpl extends AbstractDaoImpl implements DetailDao<Orientation> {

	@Override
	public void persist(Orientation detail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Orientation detail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Orientation findById(int id) {
		Orientation e=(Orientation)template.get(fr.mb.projet.bean.detail.Orientation.class,id);  
	    return e;
	}

	@Override
	public void delete(Orientation detail) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Orientation> findAll() {
		List<Orientation>list=template.loadAll(Orientation.class);
		return list;
	}

}
