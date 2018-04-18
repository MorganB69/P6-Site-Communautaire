package fr.mb.projet.contract;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.spot.Voie;


/**
 * Interface pour le manager des commentaires
 * @author Morgan
 *
 */
public interface AjoutManager <T> {
	
	public void insert(Comment comment);
	
	public void insert(Secteur comment);
	
	public void insert(Voie comment);
	
	

}
