package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;


import fr.mb.projet.bean.user.Utilisateur;

public interface UserDao extends Serializable {
	
	public void persist(Utilisateur user);
	
	public void update(Utilisateur user);
	
	public Utilisateur getUtilisateur(String login, String mdp);
	
	public void delete(Utilisateur user);
	
	public List<Utilisateur> findAll();
	
	public void deleteAll();

}
