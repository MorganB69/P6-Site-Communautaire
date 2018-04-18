package fr.mb.projet.action.topo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public class GestionTopoAction extends ActionSupport implements SessionAware {

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
	 * Pour d�finir le propri�taire du topo
	 */
	private Utilisateur proprietaire;
	
	
	/**
	 * Pour d�finir l'emprunteur d'un topo s'il y en a un
	 */
	private Utilisateur emprunteur;
	
	/**
	 * Classe Topo pour obtenir ou rajouter des d�tails au topo
	 */
	private Topo topo;
	
	/**
	 * Liste des sites pour associer � un topo
	 */
	private List<Site>listeSite=new ArrayList<Site>();
	/**
	 * Liste des id des sites � associer
	 */
	private List<Integer>listeSiteValues=new ArrayList<Integer>();
	/**
	 *Utilis�e pour ajouter une image au topo 
	 */
	private File file;
	/**
	 *Utilis�e pour donner un nom � l'image 
	 */
	private String fileFileName;
	/**
	 *Id pour la sortie 
	 */
	private Integer id;
	
	// METHODES
	
	/**
	 * M�thode de rajout d'un topo
	 * @return retourne succes si le rajout a r�ussi
	 */
	public String addTopo() {
		
		// Acc�s � la BD pour r�cup�rer les listes pr�d�finies d'Orientation et Cotation
		// et les mettre
		// dans une session
		
		String result = ActionSupport.INPUT;
		
		if(this.topo!=null) {
		
		
		// Enregistrement de l'image
					if (this.file != null) {
						String filePath = ServletActionContext.getServletContext().getRealPath("/image/topo/");
						;
						File saveFilePath = new File(filePath, this.fileFileName);
						try {
							FileUtils.copyFile(this.file, saveFilePath);
							// Ajout du lien de l'image au site
							this.topo.setImage(this.fileFileName);
						} catch (IOException ex) {
							this.addActionError("Enregistrement de l'image impossible: " + ex.getMessage());
						}
					}
					// Si image null, enregistrement d'une image par d�faut
					else
						this.topo.setImage("defautTopo.jpg");
					
					if (!this.hasErrors()) {
						try {

							// Ajout d'une date au site
							this.topo.setStatut("Disponible");
							this.proprietaire = (Utilisateur) session.get("user");
							this.topo.setProprietaire(this.proprietaire);

							

							// Insertion du site en BD
							this.managerFactory.getTopoManager().insert(this.topo);



							this.addActionMessage("Topo ajout� avec succ�s");
							result = ActionSupport.SUCCESS;

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
	
	/**
	 * Obtenir la liste des topos
	 * @return succ�s lorsque la liste est obtenue
	 */
	public String doList() {
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Obtenir le d�tail d'un topo
	 * @return succ�s lorsque le topo est obtenu
	 */
	public String doDetail() {
		if (id == null) {
			this.addActionError(getText("error.project.missing.id"));
		} else {
			try {

				topo = (Topo) managerFactory.getTopoManager().getTopo(id);

			} catch (NotFoundException Notfound) {
				this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
			}
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	
	
	
	//GETTERS ET SETTERS
	public Topo getTopo() {
		return topo;
	}
	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	public List<Site> getListeSite() {
		return listeSite;
	}
	public void setListeSite(List<Site> listeSite) {
		this.listeSite = listeSite;
	}
	public List<Integer> getListeSiteValues() {
		return listeSiteValues;
	}
	public void setListeSiteValues(List<Integer> listeSiteValues) {
		this.listeSiteValues = listeSiteValues;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}

	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	
	
	
}


