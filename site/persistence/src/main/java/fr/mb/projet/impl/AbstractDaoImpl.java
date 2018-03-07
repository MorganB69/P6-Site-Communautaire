package fr.mb.projet.impl;

import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import fr.mb.projet.recherche.RechercheSite;

public abstract class AbstractDaoImpl {
	
	@Autowired
	@Named("dataSourceSite")
	private DataSource datasource;
	
	
	protected DataSource getDataSource() {
		return datasource;
	}




}
