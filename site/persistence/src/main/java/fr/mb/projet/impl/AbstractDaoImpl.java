package fr.mb.projet.impl;


import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTemplate;

/**
 * Classe abstraite permettant l'injection du template hibernate ou d'une sessionFactory
 * @author Morgan
 *
 */
public abstract class AbstractDaoImpl {
	
	/**
	 * Template hibernate utilisé pour les requêtes basiques
	 */
	@Inject
	HibernateTemplate template;
	
	/**
	 * Permet de créer des sessions personnalisées pour des requêtes plus complexes
	 */
	@Inject
	SessionFactory sessionFactory;
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}  
	


}
