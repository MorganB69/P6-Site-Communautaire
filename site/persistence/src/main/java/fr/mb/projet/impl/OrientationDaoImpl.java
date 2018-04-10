package fr.mb.projet.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

/**
 * Classe pour récupérer en bd la liste des Orientations
 * @author Morgan
 *
 */
@Named("detailDao")
@Transactional
public class OrientationDaoImpl extends AbstractDaoImpl implements DetailDao<Orientation> {

	

	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailDao#findAll()
	 */
	@Override
	@Transactional
	public List<Orientation> findAll() {
		List<Orientation>list=template.loadAll(Orientation.class);
		return list;
	}

	@Override
	public List<Orientation> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orientation> findListInDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orientation> findByIdDb(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
