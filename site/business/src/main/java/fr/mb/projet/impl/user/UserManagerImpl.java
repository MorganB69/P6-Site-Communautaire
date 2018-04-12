package fr.mb.projet.impl.user;

import javax.inject.Inject;
import javax.inject.Named;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.UserDao;
import fr.mb.projet.contract.UserManager;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

/**
 * Manager pour la gestion des USER
 * 
 * @author Morgan
 *
 */
@Named("userManager")
public class UserManagerImpl implements UserManager {

	/**
	 * DAO de User
	 */
	@Inject
	UserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserManager#getUser(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Utilisateur getUser(String login, String mdp) throws NotFoundException {

		Utilisateur user = userDao.getUtilisateur(login, mdp);
		

		return user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.projet.contract.UserManager#insert(fr.mb.projet.bean.user.Utilisateur)
	 */
	@Override
	public void insert(Utilisateur user) throws FunctionalException, TechnicalException {
		userDao.persist(user);

	}

}
