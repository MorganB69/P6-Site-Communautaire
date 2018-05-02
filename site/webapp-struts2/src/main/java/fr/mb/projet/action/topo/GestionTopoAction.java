package fr.mb.projet.action.topo;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Pret;
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
	 * Pour d�finir l'utilisateur en cours sur le site
	 */
	private Utilisateur user;
	
	
	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	/**
	 * Pour d�finir l'emprunteur d'un topo s'il y en a un
	 */
	private Utilisateur emprunteur;
	
	/**
	 * Pour d�finir une demande de pr�t
	 */
	private Pret DemandePret;
	
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
	
	/**
	 * Pour d�finir si le topo visit� est d�j� en demande d'emprunt par l'utilisateur
	 */
	private Boolean topoEmprunt=false;
	
	/**
	 *Liste des topos � obtenir 
	 */
	private List<Topo>listeTopo=new ArrayList<Topo>();

	/**
	 *Nombre de Topo � afficher par page 
	 */
	private Integer pageSize=12;

	/**
	 *Page choisit � afficher pour d�finir l'offset 
	 */
	private Integer start=0;

	/**
	 *Num�ro de la derni�re page 
	 */
	private Object lastPage;
	
	/**
	 *Id du pr�t 
	 */
	private Integer idPret;
	
	
	
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
			// -------------- Validation des donn�es saisies--------------
			if (this.topo.getAuteur().length() == 0 || this.topo.getAuteur() == null) {
				this.addFieldError("topo.auteur", "ne doit pas �tre vide");
			}
			if (this.topo.getTitre().length() == 0 || this.topo.getTitre() == null) {
				this.addFieldError("topo.titre", "ne doit pas �tre vide");
			}
		
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
						this.topo.setImage("defautTopo.png");
					
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
							// Autres erreurs, on part sur le result "error"
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
		
		this.lastPage = managerFactory.getTopoManager().getCount(this.pageSize, this.start);
		
		this.listeTopo = managerFactory.getTopoManager().getListTopo(this.pageSize, this.start);
		session.put("lastPageTopo", this.lastPage);
		session.put("listTopo", this.listeTopo);
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
				this.user = (Utilisateur) session.get("user");
				topo = (Topo) managerFactory.getTopoManager().getTopo(id);
				
				if (this.user!=null) {
					
				for (Iterator iterator = topo.getListePret().iterator(); iterator.hasNext();) {
					Pret pret = (Pret) iterator.next();
				
					if (pret.getEmprunteur().getId()==this.user.getId())this.topoEmprunt=true;
					
					
				}
				}
				
			} catch (NotFoundException Notfound) {
				this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
			}
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	/**
	 * Cr�ation d'une demande de r�servation
	 * @return
	 */
	public String reservation() {
		
		try {
			this.emprunteur = (Utilisateur) session.get("user");
			
			this.topo = (Topo) managerFactory.getTopoManager().getTopo(this.id);
			
			this.DemandePret=new Pret();
			this.DemandePret.setEmprunteur(this.emprunteur);
			this.DemandePret.setTopo(this.topo);
			this.DemandePret.setStatut("En cours");
			
			try {
				managerFactory.getPretManager().insert(this.DemandePret);
				addActionMessage("Votre demande a bien �t� effectu�e");
				this.topoEmprunt=true;
				
			} catch (FunctionalException functExcep) {
				// On reste sur la saisie
				this.addActionError(functExcep.getMessage());

			} catch (TechnicalException techExcep) {
				// Autre erreur, on part sur le result "error"
				this.addActionError(techExcep.getMessage());
				
			}
			
			
			
		} catch (NotFoundException e) {
			this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	
	/**
	 * Acceptation de la r�servation
	 * @return
	 */
	public String acceptResa(){
		
		//On d�finit la date du jour comme date de d�part
		LocalDate dateDebut=LocalDate.now();
		//On d�finit la date de fin 21 jours plus tard
		LocalDate dateFin=dateDebut.plusDays(21);
		
		
		try {
			this.topo = (Topo) managerFactory.getTopoManager().getTopo(this.id);
			this.topo.setStatut("R�serv�");
			
			for (Iterator iterator = this.topo.getListePret().iterator(); iterator.hasNext();) {
				Pret pret = (Pret) iterator.next();
				if(pret.getId()==this.idPret) {
					pret.setDebut(dateDebut);
					pret.setFin(dateFin);
					pret.setStatut("Accept�");
					managerFactory.getPretManager().update(pret);
					managerFactory.getTopoManager().update(this.topo);
					this.user=(Utilisateur) session.get("user");
					this.user=managerFactory.getUserManager().getUserById(this.user.getId());

							session.replace("user", this.user);

				}
				
			}
		} catch (NotFoundException e) {
			this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
		}
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	/**
	 * Refus de la r�servation
	 * @return
	 */
	public String refusResa() {
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Annulation de la r�servation
	 * @return
	 */
	public String annulerResa() {
		try {
			this.topo = (Topo) managerFactory.getTopoManager().getTopo(this.id);
			this.topo.setStatut("Disponible");
			
			for (Iterator iterator = this.topo.getListePret().iterator(); iterator.hasNext();) {
				Pret pret = (Pret) iterator.next();
				if(pret.getId()==this.idPret) {
					pret.setDebut(null);
					pret.setFin(null);
					pret.setStatut("Annul�");
					managerFactory.getPretManager().update(pret);
					managerFactory.getTopoManager().update(this.topo);
					this.user=(Utilisateur) session.get("user");
					this.user=managerFactory.getUserManager().getUserById(this.user.getId());
					session.replace("user", this.user);
						
						
					
				}
				
			}
			
		} catch (NotFoundException e) {
			this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
		}
		
		
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
	}
	
	/**
	 * Suppression d'une r�servation
	 * @return
	 */
	public String deleteResa() {
		
		try {
			this.topo = (Topo) managerFactory.getTopoManager().getTopo(this.id);
			
			
			for (Iterator iterator = this.topo.getListePret().iterator(); iterator.hasNext();) {
				Pret pret = (Pret) iterator.next();
				if(pret.getId()==this.idPret) {
					pret.setDebut(null);
					pret.setFin(null);
					pret.setStatut("Annul�");
					managerFactory.getPretManager().delete(pret);
					
					this.user=(Utilisateur) session.get("user");
					this.user=managerFactory.getUserManager().getUserById(this.user.getId());
					session.replace("user", this.user);
						
						
					
				}
				
			}
			
		} catch (NotFoundException e) {
			this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
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

	public Pret getDemandePret() {
		return DemandePret;
	}

	public void setDemandePret(Pret demandePret) {
		DemandePret = demandePret;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public Boolean getTopoEmprunt() {
		return topoEmprunt;
	}

	public void setTopoEmprunt(Boolean topoEmprunt) {
		this.topoEmprunt = topoEmprunt;
	}

	public List<Topo> getListeTopo() {
		return listeTopo;
	}

	public void setListeTopo(List<Topo> listeTopo) {
		this.listeTopo = listeTopo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Object getLastPage() {
		return lastPage;
	}

	public void setLastPage(Object lastPage) {
		this.lastPage = lastPage;
	}

	public Integer getIdPret() {
		return idPret;
	}

	public void setIdPret(Integer idPret) {
		this.idPret = idPret;
	}
	
	
	
	
}


