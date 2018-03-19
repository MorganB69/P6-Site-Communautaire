package fr.mb.projet.action.site;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.detail.Coordonnee;
import fr.mb.projet.bean.detail.Situation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public class GestionSiteAction extends ActionSupport {

	// Factory
	@Inject
	private ManagerFactory managerFactory;

	// Attributs
	
		//Entrée
	private Integer id;
		//Sortie
	private List<Site> listSite;
	private Site site;
	private Coordonnee coordonnee;
	private Situation situation;

	// Getters et Setters
	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Site> getListSite() {
		return listSite;
	}

	public void setListSite(List<Site> listSite) {
		this.listSite = listSite;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	// Méthodes

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public String doList() {
		listSite = managerFactory.getSiteManager().getListSite();
		return ActionSupport.SUCCESS;
	}

	public String doDetail() {
		if (id == null) {
			this.addActionError(getText("error.project.missing.id"));
		} else {
			try {
				
				site = (Site) managerFactory.getSiteManager().getSite(id);
				
				

			} catch (NotFoundException Notfound) {
				this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
			}
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	public String add() {

		String result = ActionSupport.INPUT;

		

			// Si pas d'erreur, rajout du site
			if (!this.hasErrors()) {
				try {
					
					managerFactory.getSiteManager().insert(this.coordonnee);
					managerFactory.getSiteManager().insert(this.situation);
					this.site.setSituation(this.situation);
					this.site.setCoordonnee(this.coordonnee);
					
					managerFactory.getSiteManager().insert(this.site);

					result = ActionSupport.SUCCESS;

					this.addActionMessage("Site ajouté avec succès");

				} catch (FunctionalException functExcep) {
					// On reste sur la saisie
					this.addActionError(functExcep.getMessage());

				} catch (TechnicalException techExcep) {
					// on part sur le result "error"
					this.addActionError(techExcep.getMessage());
					result = ActionSupport.ERROR;
				}
			}
		

		return result;
	}

}
