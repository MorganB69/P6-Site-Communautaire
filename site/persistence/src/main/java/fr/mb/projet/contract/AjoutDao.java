package fr.mb.projet.contract;

import fr.mb.projet.bean.comment.Comment;


public interface AjoutDao <T> {
	/**
	 * Persister le commentaire en bd
	 * @param comment à insérer en bd
	 */
	public void persist(T comment);
}
