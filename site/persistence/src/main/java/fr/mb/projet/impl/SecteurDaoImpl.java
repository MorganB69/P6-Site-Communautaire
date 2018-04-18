package fr.mb.projet.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.spot.Voie;
import fr.mb.projet.contract.AjoutDao;

@Named("secteurDao")
@Transactional
public class SecteurDaoImpl extends AbstractDaoImpl implements AjoutDao<Secteur>{

	@Override
	@Transactional
	public void persist(Secteur comment) {
		template.save(comment);
		
	}

}
