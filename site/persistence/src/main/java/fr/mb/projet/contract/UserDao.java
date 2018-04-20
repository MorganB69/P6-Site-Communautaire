package fr.mb.projet.contract;

import java.io.Serializable;
import java.util.List;


import fr.mb.projet.bean.user.Utilisateur;

/**
 * Interface pour la gestion de la DAO de classe Utilisateur
 * @author Morgan
 *
 */
public interface UserDao extends Serializable {
	
	/**
	 * Enregistrement d'un utilisateur dans la base de donn�es
	 * @param user Utilisateur � enregistrer
	 */
	public void persist(Utilisateur user);
	
	/**
	 * Mise � jour d'un utilisateur en base de donn�es
	 * @param user Utilisateur � mettre � jour
	 */
	public void update(Utilisateur user);
	
	/**
	 * Obtention de l'utilisateur en base de donn�e en fonction de son login et mot de passe
	 * @param login
	 * @param mdp
	 * @return l'utilisateur trouv� en base de donn�e
	 */
	public Utilisateur getUtilisateur(String login, String mdp);
	
	/**
	 * Supprime l'utilisateur de la base de donn�e
	 * @param user � supprimer
	 */
	public void delete(Utilisateur user);
	
	/**
	 * Obtention d'une liste d'utilisateur � r�cup�rer en base de donn�es
	 * @return liste des utilisateurs
	 */
	public List<Utilisateur> findAll();
	
	/**
	 * Supprime tous les utilisateurs de la base de donn�e.
	 * 
	 */
	public void deleteAll();
	
	/**
	 * Obtention de l'utilisateur en base de donn�e en fonction de son login et mot de passe
	 * @param login
	 * @param mdp
	 * @return l'utilisateur trouv� en base de donn�e
	 */
	public Utilisateur getUtilisateurById(Integer id);

}
