package fr.mb.projet.impl;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.contract.AjoutDao;

@Named("commentDao")
@Transactional
public class CommentDaoImpl extends AbstractDaoImpl implements AjoutDao<Comment>{

	@Override
	@Transactional
	public void persist(Comment comment) {
		template.save(comment);
		
	}

}
