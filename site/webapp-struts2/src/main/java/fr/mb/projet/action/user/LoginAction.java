package fr.mb.projet.action.user;

import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.NotFoundException;

public class LoginAction extends ActionSupport implements SessionAware {

	//ATTRIBUTS
	
	//Factory
	@Inject
	private ManagerFactory managerFactory;
	private Utilisateur user;
	private String login;
	private String password;
	
	private Map<String, Object> session;
	
	//Getters Setters
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

	
	//Methodes
	public String doLogin() {
		String result = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(login, password)) {
            try {
                this.user=managerFactory.getUserManager().getUser(login, password);
                if (this.user!=null) {
                this.session.put("user", user);
                result = ActionSupport.SUCCESS;}
                else this.addActionError("Identifiant ou mot de passe invalide !");
            } catch (NotFoundException pEx) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        
        return result;
		
	}
	
	public String doLogout() {
		this.session.remove("user");
		return ActionSupport.SUCCESS;
	}
	
	
	@Override
	public void setSession(Map<String, Object> pSession) {
		
		this.session=pSession;
	}
	
	
	
}
