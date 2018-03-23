package fr.mb.projet.action.site;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
	
		//Upload fichier
    private File file;
    private String fileContentType;
    private String fileFileName;
    
    
		//Sortie
	private List<Site> listSite;
	private Site site;
	private Situation situation;
	private Coordonnee coordonnee;
	


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



	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
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

/*
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
	*/
	
	
	//------------------------ Méthodes-------------------------
	//----------------------------------------------------------

	public Situation getSituation() {
		return situation;
	}

	public void setSituation(Situation situation) {
		this.situation = situation;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
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

		if (this.site!=null) {
			//Enregistrement de l'image
			String filePath = ServletActionContext.getServletContext().getRealPath("/image/site/");;
			File saveFilePath = new File(filePath,this.fileFileName);
	        try {
	            FileUtils.copyFile(this.file, saveFilePath);
	        } catch (IOException ex) {
	            this.addActionError("Enregistrement de l'image impossible: " + ex.getMessage());
	        }
	        
			// Si pas d'erreur, rajout du site
			if (!this.hasErrors()) {
				try {
					/*
					managerFactory.getSiteManager().insert(this.coordonnee);
					managerFactory.getSiteManager().insert(this.situation);
					this.site.setSituation(this.situation);
					this.site.setCoordonnee(this.coordonnee);
					*/
					this.site.setImage(this.fileFileName);
					this.site.setDateAjout(new Date());
					
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
		
		}
		return result;
	}
	
}
