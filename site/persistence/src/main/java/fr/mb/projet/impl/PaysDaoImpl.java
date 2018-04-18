package fr.mb.projet.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

/**
 * Classe pour l'obtention de la liste des cotations en bd
 * @author Morgan
 *
 */
@Named("paysDao")
@Transactional
public class PaysDaoImpl extends AbstractDaoImpl implements DetailDao<Pays> {



	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailDao#findAll()
	 */
	@Override
	@Transactional
	public List<Pays> findAll() {
		List<Pays>list=template.loadAll(Pays.class);
		return list;
	}

	@Override
	public List<Pays> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Pays> findListInDB() {
		List<Pays>list=(List<Pays>) template.find("SELECT distinct pays From Site");
		
		return list;
	}

	@Override
	public List<Pays> findByIdDb(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
