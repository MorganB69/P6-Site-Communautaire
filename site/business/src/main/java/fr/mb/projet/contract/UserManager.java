package fr.mb.projet.contract;


import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

/**
 * Interface des managers des User
 * @author Morgan
 *
 */
public interface UserManager {
public Utilisateur getUser (String login, String mdp) throws NotFoundException;
	
	

	public void insert(Utilisateur user) throws FunctionalException, TechnicalException;
}
