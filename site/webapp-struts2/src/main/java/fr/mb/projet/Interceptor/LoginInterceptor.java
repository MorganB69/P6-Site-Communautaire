package fr.mb.projet.Interceptor;


import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.HttpParameters;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

import fr.mb.projet.bean.user.Utilisateur;

public class LoginInterceptor implements Interceptor, SessionAware {


	private Map<String, Object> session;


	@Override
	public void destroy() {
		//release resources here
	}

	@Override
	public void init() {
		// create resources here
	}

	@Override
	public String intercept(ActionInvocation actionInvocation)
			throws Exception {
		
		Map<String, Object> session = actionInvocation.getInvocationContext()
				    .getSession();
		
		
		String actionName = actionInvocation.getInvocationContext().getName();
		
		
		
		if (!"login".equalsIgnoreCase(actionName)) {
		    session.put("lastAction", actionName);

		}
		

		
		Utilisateur user = (Utilisateur) session.get("user");
		

		
		if(user == null){
			return "loginUser";
		}
		else{
				

			return actionInvocation.invoke();
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	


}