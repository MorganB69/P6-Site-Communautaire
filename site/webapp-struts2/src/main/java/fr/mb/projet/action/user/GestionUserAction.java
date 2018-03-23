package fr.mb.projet.action.user;

import javax.inject.Inject;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.TechnicalException;

public class GestionUserAction extends ActionSupport {
	// ATTRIBUTS

	// Factory
	@Inject
	private ManagerFactory managerFactory;
	private Utilisateur user;

	private String login;
	private String password;

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

	// METHODES

	public String add() {
		String result = ActionSupport.INPUT;
		
			if (this.user != null) {
			
			// Récupération du responsable
			if (this.user.getPseudo().length() == 0 
			|| this.user.getMdp().length() == 0 
			|| this.user.getNom().length() == 0
			|| this.user.getMail().length() == 0) {
				this.addFieldError("user.pseudo", "Les champs ne doivent pas être vides");
			} 
			
			if (!this.hasErrors()) {
				try {

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

}
