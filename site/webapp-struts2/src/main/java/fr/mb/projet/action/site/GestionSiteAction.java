package fr.mb.projet.action.site;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import com.opensymphony.xwork2.ActionSupport;

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
	private Integer id;

	private List<Site> listSite;
	private Site site;

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

	public String doList() {
		listSite = managerFactory.getSiteManager().getListSite();
		return ActionSupport.SUCCESS;
	}

	public String doDetail() {
		if (id == null) {
			this.addActionError(getText("error.project.missing.id"));
		} else {
			try {
				site = managerFactory.getSiteManager().getSite(id);

			} catch (NotFoundException pE) {
				this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
			}
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}

	public String add() {

		String vResult = ActionSupport.INPUT;

		// ===== Validation de l'ajout
		if (this.site != null) {

			// Si pas d'erreur, ajout du projet...
			if (!this.hasErrors()) {
				try {
					managerFactory.getSiteManager().insert(this.site);
					// Si ajout avec succès -> Result "success"
					vResult = ActionSupport.SUCCESS;
					this.addActionMessage("Site ajouté avec succès");

				} catch (FunctionalException pEx) {
					// Sur erreur fonctionnelle on reste sur la page de saisie
					// et on affiche un message d'erreur
					this.addActionError(pEx.getMessage());

				} catch (TechnicalException pEx) {
					// Sur erreur technique on part sur le result "error"
					this.addActionError(pEx.getMessage());
					vResult = ActionSupport.ERROR;
				}
			}
		}

		return vResult;
	}

}
