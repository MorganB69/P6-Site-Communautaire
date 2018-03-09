package fr.mb.projet.impl;


import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractDaoImpl {
	
	@Inject
	@Named("dataSourceSite")
	private DataSource datasource;
	
	
	protected DataSource getDataSource() {
		return datasource;
	}




}
