package fr.mb.projet.impl;

import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.DetailDao;

/**
 * Classe pour l'obtention de la liste des regions en bd
 * @author Morgan
 *
 */
@Named("stateDao")
@Transactional
public class StateDaoImpl extends AbstractDaoImpl implements DetailDao<State> {



	/* (non-Javadoc)
	 * @see fr.mb.projet.contract.DetailDao#findAll()
	 */
	@Override
	@Transactional
	public List<State> findAll() {
		List<State>list=template.loadAll(State.class);
		return list;
	}

	@Override
	public List<State> findById(Integer id) {
		List<State>list=(List<State>) template.find("from State where pays.id=?", id);
		
		return list;
	}

	@Override
	public List<State> findListInDB() {
		List<State>list=(List<State>) template.find("SELECT Distinct State From Site");
		return list;
	}

	@Override
	public List<State> findByIdDb(Integer id) {
		List<State>list=(List<State>) template.find("SELECT state From Site site where site.pays.id=?",id);
		return list;
	}

}
