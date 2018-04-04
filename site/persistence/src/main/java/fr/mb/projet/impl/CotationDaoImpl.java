package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

/**
 * Classe pour l'obtention de la liste des cotations en bd
 * @author Morgan
 *
 */
@Named("cotationDao")
@Transactional
public class CotationDaoImpl extends AbstractDaoImpl implements DetailDao<ListCot> {



	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailDao#findAll()
	 */
	@Override
	@Transactional
	public List<ListCot> findAll() {
		List<ListCot>list=template.loadAll(ListCot.class);
		return list;
	}

}
