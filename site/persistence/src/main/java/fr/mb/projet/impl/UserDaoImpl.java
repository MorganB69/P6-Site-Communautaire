package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;


import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.UserDao;


@Named("userDAO")
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	@Override
	public void persist(Utilisateur user) {
		template.save(user);
		
	}

	@Override
	public void update(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getUtilisateur(String login, String mdp) {
		List <Utilisateur> list=(List<Utilisateur>) template.find("from Utilisateur where pseudo=? and mdp=?", login, mdp);
		
		if (list.isEmpty()) return null; 
			 
		return list.get(0);
	}

	@Override
	public void delete(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
