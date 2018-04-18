package fr.mb.projet.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.spot.Voie;
import fr.mb.projet.contract.AjoutDao;

@Named("voieDao")
@Transactional
public class VoieDaoImpl extends AbstractDaoImpl implements AjoutDao<Voie>{

	@Override
	@Transactional
	public void persist(Voie comment) {
		template.save(comment);
		
	}

}
