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
	 * Enregistrement d'un utilisateur dans la base de données
	 * @param user Utilisateur à enregistrer
	 */
	public void persist(Utilisateur user);
	
	/**
	 * Mise à jour d'un utilisateur en base de données
	 * @param user Utilisateur à mettre à jour
	 */
	public void update(Utilisateur user);
	
	/**
	 * Obtention de l'utilisateur en base de donnée en fonction de son login et mot de passe
	 * @param login
	 * @param mdp
	 * @return l'utilisateur trouvé en base de donnée
	 */
	public Utilisateur getUtilisateur(String login, String mdp);
	
	/**
	 * Supprime l'utilisateur de la base de donnée
	 * @param user à supprimer
	 */
	public void delete(Utilisateur user);
	
	/**
	 * Obtention d'une liste d'utilisateur à récupérer en base de données
	 * @return liste des utilisateurs
	 */
	public List<Utilisateur> findAll();
	
	/**
	 * Supprime tous les utilisateurs de la base de donnée.
	 * 
	 */
	public void deleteAll();
	
	/**
	 * Obtention de l'utilisateur en base de donnée en fonction de son login et mot de passe
	 * @param login
	 * @param mdp
	 * @return l'utilisateur trouvé en base de donnée
	 */
	public Utilisateur getUtilisateurById(Integer id);

}
