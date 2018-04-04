package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.UserDao;

/**
 * Implémentation de la DAO pour la classe Utilisateur
 * 
 * @author Morgan
 *
 */
@Named("userDAO")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.mb.projet.contract.UserDao#persist(fr.mb.projet.bean.user.Utilisateur)
	 */
	@Override
	public void persist(Utilisateur user) {
		template.save(user);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserDao#update(fr.mb.projet.bean.user.Utilisateur)
	 */
	@Override
	public void update(Utilisateur user) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserDao#getUtilisateur(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Utilisateur getUtilisateur(String login, String mdp) {
		List<Utilisateur> list = (List<Utilisateur>) template.find("from Utilisateur where pseudo=? and mdp=?", login,
				mdp);

		if (list.isEmpty())
			return null;

		return list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserDao#delete(fr.mb.projet.bean.user.Utilisateur)
	 */
	@Override
	public void delete(Utilisateur user) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserDao#findAll()
	 */
	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.mb.projet.contract.UserDao#deleteAll()
	 */
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
