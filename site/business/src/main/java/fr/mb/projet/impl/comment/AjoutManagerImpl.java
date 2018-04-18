package fr.mb.projet.impl.comment;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.spot.Voie;
import fr.mb.projet.contract.AjoutDao;
import fr.mb.projet.contract.AjoutManager;
import fr.mb.projet.contract.SiteDao;

/**
 * Manager pour le rajout de commentaire
 * @author Morgan
 *
 */
@Named("ajoutManager")
@Service
@Transactional
public class AjoutManagerImpl implements AjoutManager<Comment> {
	
	@Inject
	AjoutDao<Secteur> secteurDao;
	@Inject
	AjoutDao<Comment> commentDao;
	@Inject
	AjoutDao<Voie> voieDao;

	@Override
	@Transactional
	public void insert(Comment comment) {
		this.commentDao.persist(comment);
		
	}

	@Override
	public void insert(Secteur comment) {
		this.secteurDao.persist(comment);
		
	}

	@Override
	public void insert(Voie comment) {
		this.voieDao.persist(comment);
		
	}

}
