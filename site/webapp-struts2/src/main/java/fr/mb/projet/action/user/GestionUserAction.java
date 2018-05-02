package fr.mb.projet.action.user;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

/**
 * Action permettant la gestion des utilisateurs (Inscription, connexion etc.)
 * 
 * @author Morgan
 *
 */
public class GestionUserAction extends ActionSupport implements SessionAware {
	// ATTRIBUTS

	// Factory
	/**
	 * Factory permettant d'obtenir le manager de la couche business
	 */
	@Inject
	private ManagerFactory managerFactory;

	/**
	 * Object de la classe Utilisateur
	 */
	private Utilisateur user;

	/**
	 * login de l'utilisateur
	 */
	private String login;
	/**
	 * Mot de passe de l'utilisateur
	 */
	private String password;
	
	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;

	// METHODES

	/**
	 * Méthode d'ajout d'un utilisateur en base de donnée
	 * 
	 * @return Succes si pas d'erreur
	 */
	public String add() {
		String result = ActionSupport.INPUT;

		if (this.user != null) {

			// Vérification des données non nulles
			if (this.user.getPseudo().length() == 0 || this.user.getMdp().length() == 0
					|| this.user.getNom().length() == 0 || this.user.getMail().length() == 0) {
				this.addFieldError("user.pseudo", "Les champs ne doivent pas être vides");
			}

			if (!this.hasErrors()) {
				try {
					// Enregistrement en base de donnée
					managerFactory.getUserManager().insert(this.user);

					result = ActionSupport.SUCCESS;

					this.addActionMessage("Utilisateur ajouté avec succès");

				} catch (FunctionalException functExcep) {
					// On reste sur la saisie
					this.addActionError(functExcep.getMessage());

				} catch (TechnicalException techExcep) {
					// on part sur le result "error"
					this.addActionError(techExcep.getMessage());
					result = ActionSupport.ERROR;
				}
			}

		}

		return result;

	}
	
	public String espace() {
		this.user=(Utilisateur) session.get("user");
		try {
			this.user=managerFactory.getUserManager().getUserById(this.user.getId());
			session.replace("user", this.user);
		} catch (NotFoundException e) {
			this.addActionError(getText("error.user.notfound"));
		}

				
			
			
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	// ---------------------GETTERS/SETTERS---------------------------

	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
