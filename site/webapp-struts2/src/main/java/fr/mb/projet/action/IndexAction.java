/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.mb.projet.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.contract.ManagerFactory;



/**
 * Classe Action pour l'index du site
 * @author Morgan
 *
 */
/**
 * @author Morgan
 *
 */
public class IndexAction extends ActionSupport implements SessionAware{
    
	/**
	 * Factory pour obtenir les managers de la couche business
	 */
	@Inject
	private ManagerFactory managerFactory;

	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;
	
	/**
	 * Nombre de sites à afficher par page
	 */
	private Integer pageSize = 3;
	
	/**
	 * Liste pour l'affichage de site
	 */
	private List<Site> listSite = new ArrayList<Site>();
	
	/**
	 * Liste pour l'affichage de topo
	 */
	private List<Topo> listTopo = new ArrayList<Topo>();
	
	/**
	 * Page sélectionnée et permet de définir l'Offset pour le changement de page
	 */
	private Integer start = 0;
    
    

	/* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {
    	
    	this.listSite = managerFactory.getSiteManager().getListSite(this.pageSize, this.start);
    	this.listTopo =managerFactory.getTopoManager().getListTopo(this.pageSize, this.start);
       
        return SUCCESS;
    }
    
    /**
     * Affichage des mentions légales
     * @return
     */
    public String mentions() {
    	return ActionSupport.SUCCESS;
    }

    
    //GETTERS ET SETTERS


	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}



	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}



	public Map<String, Object> getSession() {
		return session;
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



	public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}



	public List<Site> getListSite() {
		return listSite;
	}



	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}



	public List<Topo> getListTopo() {
		return listTopo;
	}



	public void setListTopo(List<Topo> listTopo) {
		this.listTopo = listTopo;
	}
}
