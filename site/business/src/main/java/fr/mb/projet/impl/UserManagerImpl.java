package fr.mb.projet.impl;

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


@Named("userManager")
public class UserManagerImpl implements UserManager {
	
	@Inject
	UserDao userDao;

	@Override
	public Utilisateur getUser(String login, String mdp) throws NotFoundException {

		Utilisateur user=userDao.getUtilisateur(login,mdp);
		
		return user;
	}

	@Override
	public void insert(Utilisateur user) throws FunctionalException, TechnicalException {
		userDao.persist(user);
		
	}

}
