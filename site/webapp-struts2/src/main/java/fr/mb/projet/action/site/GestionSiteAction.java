package fr.mb.projet.action.site;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.detail.Altitude;
import fr.mb.projet.bean.detail.Coordonnee;
import fr.mb.projet.bean.detail.Cotation;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.detail.Orientation;
import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.detail.Situation;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;
import fr.mb.projet.recherche.RechercheSite;

/**
 * @author Morgan
 * Action permettant la gestion des spots, ex : ajouter un nouveau spot
 * détail d'un spot etc.
 */
public class GestionSiteAction extends ActionSupport implements SessionAware {

	/**
	 * Factory pour obtenir les managers de la couche business
	 */
	@Inject
	private ManagerFactory managerFactory;

	/**
	 * Permet de stocker les objets en session
	 */
	private Map<String, Object> session;

	// ------------ Attributs-------------

	/**
	 * Entrée ID permettant d'obtenir le détail d'un site
	 */
	private Integer id;

	//-----------Paramètres Pagination-------

	/**
	 * Nombre de sites à afficher par page
	 */
	private Integer pageSize = 12;

	/**
	 * Nombre de page nécessaire pour tous les objets (soit le numéro de la dernière
	 * page)
	 */
	private Integer lastPage=0;

	/**
	 * Page sélectionnée et permet de définir l'Offset pour le changement de page
	 */
	private Integer start = 0;

	// Attributs utilisés pour alimenter le questionnaire

	/**
	 * Liste des différentes orientations à récupérer en bd
	 */
	private List<Orientation> listeOrientation = new ArrayList<Orientation>();
	/**
	 * Liste des différentes cotations à récupérer en bd
	 */
	private List<ListCot> listeCotation = new ArrayList<ListCot>();
	
	/**
	 *Liste des pays à récupérer en bd 
	 */
	private List<Pays> listePays = new ArrayList<Pays>();
	
	/**
	 *Liste des régions à récupérer en bd 
	 */
	private List<State>listeState=new ArrayList<State>();

	// Upload fichier

	/**
	 * File pour la récupération d'image sur le questionnaire d'ajout
	 */
	private File file;

	/**
	 * Permet de récupérer le nom du fichier
	 */
	private String fileFileName;

	// ----Sortie---

	/**
	 * Classe principale en sortie du questionnaire
	 */
	private Site site;

	/**
	 * Liste pour l'affichage de site
	 */
	private List<Site> listSite = new ArrayList<Site>();

	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Situation situation;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Coordonnee coordonnee;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Altitude altMin;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Altitude altMax;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Altitude altMoy;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Cotation cotMin;
	/**
	 * Attribut en sortie pour alimenter le Site
	 */
	private Cotation cotMax;
	
	private Integer paysIdOut;
	
	private Integer stateIdOut;

	/**
	 * Liste d'Orientation qui sera comprise dans un Site
	 */
	private Set<Orientation> listeOrientationOut = new HashSet<Orientation>();
	/**
	 * Liste d'Altitude qui sera comprise dans un Site
	 */
	private Set<Altitude> listeAltitudeOut = new HashSet<Altitude>();
	/**
	 * Liste de Cotation qui sera comprise dans un Site
	 */
	private Set<Cotation> listeCotationOut = new HashSet<Cotation>();

	/**
	 * Integer en sortie du questionnaire qui serviront à alimenter les listes
	 */
	private List<Integer> listeOrientationValues = new ArrayList<Integer>();
	/**
	 * Integer en sortie du questionnaire qui serviront à alimenter les listes
	 */
	private Integer cotMinValue;
	/**
	 * Integer en sortie du questionnaire qui serviront à alimenter les listes
	 */
	private Integer cotMaxValue;
	
	
	private RechercheSite recherche;
	
	// ------------------------ Méthodes-------------------------
	// ----------------------------------------------------------

	/**
	 * Méthode d'obtention de la liste des sites
	 * 
	 * @return Retourne succes si pas d'erreur
	 */
	public String doList() {

		setListeOrientation((List<Orientation>) managerFactory.getOrientationManager().getDetailList());
		this.listeCotation = (List<ListCot>) managerFactory.getCotationManager().getDetailList();
		session.put("listeOrientation", this.listeOrientation);
		session.put("listeCotation", this.listeCotation);

		this.lastPage = managerFactory.getSiteManager().getCount(this.pageSize, this.start);

		this.listSite = managerFactory.getSiteManager().getListSite(this.pageSize, this.start);
		session.put("lastPage", this.lastPage);
		session.put("listSite", this.listSite);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * Méthode de recherche de site en fonction des critères
	 * @return
	 */
	public String rechercheSite() {
		setListeOrientation((List<Orientation>) managerFactory.getOrientationManager().getDetailList());
		this.listeCotation = (List<ListCot>) managerFactory.getCotationManager().getDetailList();
		session.put("listeOrientation", this.listeOrientation);
		session.put("listeCotation", this.listeCotation);
		
		
		//this.lastPage = managerFactory.getSiteManager().getCountRecherche(this.pageSize, this.start,this.recherche);

		this.listSite = managerFactory.getSiteManager().getListSiteRecherche(this.pageSize, this.start, this.recherche);
		session.replace("listSite", this.listSite);
		
		return ActionSupport.SUCCESS;
		
	}

	/**
	 * Méthode d'obtention d'un Site et de ses détails
	 * 
	 * @return Succes si pas d'erreur et Error si une erreur est présente
	 */
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

	/**
	 * Méthode d'ajout d'un Site en reprenant les infos du formulaire
	 * 
	 * @return
	 * @throws NotFoundException
	 *             si le site est non trouvé
	 */
	public String add() throws NotFoundException {

		String result = ActionSupport.INPUT;

		// Accès à la BD pour récupérer les listes prédéfinies d'Orientation et Cotation
		// et les mettre
		// dans une session
		setListeOrientation((List<Orientation>) managerFactory.getOrientationManager().getDetailList());
		this.listeCotation = (List<ListCot>) managerFactory.getCotationManager().getDetailList();
		this.listePays = (List<Pays>) managerFactory.getPaysManager().getDetailList();
		//this.listeState = (List<State>) managerFactory.getStateManager().getDetailList();
		session.put("listeOrientation", this.listeOrientation);
		session.put("listeCotation", this.listeCotation);
		session.put("listePays", this.listePays);
		

		// ----------ENREGISTREMENT DU SITE----------

		if (this.site != null) {
			// -------------- Validation des données saisies--------------
			if (this.site.getNom().length() == 0 || this.site.getNom() == null) {
				this.addFieldError("site.nom", "ne doit pas être vide");
			}

			if (this.situation.getPays().length() == 0 || this.situation.getPays() == null) {
				this.addFieldError("situation.pays", "ne doit pas être vide");
			}

			if (this.situation.getDepartement().length() == 0 || this.situation.getDepartement() == null) {
				this.addFieldError("situation.departement", "ne doit pas être vide");
			}

			// Enregistrement de l'image
			if (this.file != null) {
				String filePath = ServletActionContext.getServletContext().getRealPath("/image/site/");
				;
				File saveFilePath = new File(filePath, this.fileFileName);
				try {
					FileUtils.copyFile(this.file, saveFilePath);
					// Ajout du lien de l'image au site
					this.site.setImage(this.fileFileName);
				} catch (IOException ex) {
					this.addActionError("Enregistrement de l'image impossible: " + ex.getMessage());
				}
			}
			// Si image null, enregistrement d'une image par défaut
			else
				this.site.setImage("defaut.jpg");

			// Si pas d'erreur, rajout des différents attributs au site enregistrement du
			// site
			if (!this.hasErrors()) {
				try {

					// Ajout d'une date au site
					this.site.setDateAjout(new Date());

					// Ajouter d'abord le site aux différents éléments
					// pour les relations en base de données

					// Situation et Coordonnées
					//this.situation.setSite(this.site);
					//this.coordonnee.setSite(this.site);

					// Altitudes
					if (this.altMax.getAlt() != null) {
						System.out.println("non null");
						this.altMax.setTypeAlt("max");
						//this.altMax.setSite(this.site);
						this.listeAltitudeOut.add(this.altMax);
					}
					if (this.altMin.getAlt() != null) {
						System.out.println("non null");
						this.altMin.setTypeAlt("min");
						//this.altMin.setSite(this.site);
						this.listeAltitudeOut.add(this.altMin);
					}
					if (this.altMoy.getAlt() != null) {
						System.out.println("non null");
						this.altMoy.setTypeAlt("moy");
						//this.altMoy.setSite(this.site);
						this.listeAltitudeOut.add(this.altMoy);
					}

					// Cotations

					// Récupération des objets en session
					if (session.containsKey("listCotation"))
						this.listeCotation = (List<ListCot>) session.get("listCotation");

					if (session.containsKey("listOrientation"))
						this.listeOrientation = (List<Orientation>) session.get("listOrientation");
					
					if (session.containsKey("listState"))
						this.listeState = (List<State>) session.get("listState");
					
					
					if (this.cotMinValue != null) {
						this.cotMin = new Cotation();
						//this.cotMin.setSite(this.site);
						this.cotMin.setTypeCot("min");

						// Récupération des objets dans les listes précédemment récupérée en BD
						for (ListCot l : this.listeCotation) {
							if (this.cotMinValue == l.getId()) {
								this.cotMin.setCot(l);
							}
						}
						// Ajout à la liste qui sera insérée dans le site
						this.listeCotationOut.add(this.cotMin);
					}

					if (this.cotMaxValue != null) {
						this.cotMax = new Cotation();
						//this.cotMax.setSite(this.site);
						this.cotMax.setTypeCot("max");
						// Récupération des objets dans les listes précédemment récupérée en BD
						for (ListCot j : this.listeCotation) {
							if (this.cotMaxValue == j.getId()) {
								this.cotMax.setCot(j);
							}
						}
						// Ajout à la liste qui sera insérée dans le site
						this.listeCotationOut.add(this.cotMax);
					}

					// Orientation

					// Récupération des objets dans les listes précédemment récupérée en BD
					if (this.listeOrientationValues != null) {
						for (Integer val : this.listeOrientationValues) {
							for (Orientation o : this.listeOrientation) {
								if (val == o.getOrientationId()) {
									// Ajout à la liste qui sera insérée dans le site
									this.listeOrientationOut.add(o);
								}
							}
						}
					}
					
					for (Pays p : this.listePays) {
						if (this.paysIdOut.equals(p.getId())) {
							this.site.setPays(p);

						
							
						}
	
					}
					
					for (State s : this.listeState) {
						if (this.stateIdOut.equals(s.getId())) {
							this.site.setState(s);
							
						}
				
						
					}
					
					

					// Insertion de chaque élément dans le site avant insertion en BD
					this.site.setSituation(this.situation);
					this.site.setCoordonnee(this.coordonnee);
					if (this.listeOrientationOut != null)
						this.site.setListeOrientation(this.listeOrientationOut);
					if (this.listeAltitudeOut != null)
						this.site.setListeAltitude(this.listeAltitudeOut);
					if (this.listeCotationOut != null)
						this.site.setListeCotation(listeCotationOut);

					// Insertion du site en BD
					managerFactory.getSiteManager().insert(this.site);

					// Fin de l'action
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
	


	// -------------- Getters et Setters----------------
	// -------------------------------------------------

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

	public List<Orientation> getListeOrientation() {
		return listeOrientation;
	}

	public void setListeOrientation(List<Orientation> listeOrientation) {
		this.listeOrientation = listeOrientation;
	}

	public Set<Orientation> getListeOrientationOut() {
		return listeOrientationOut;
	}

	public Altitude getAltMin() {
		return altMin;
	}

	public void setAltMin(Altitude altMin) {
		this.altMin = altMin;
	}

	public Altitude getAltMax() {
		return altMax;
	}

	public void setAltMax(Altitude altMax) {
		this.altMax = altMax;
	}

	public Altitude getAltMoy() {
		return altMoy;
	}

	public void setAltMoy(Altitude altMoy) {
		this.altMoy = altMoy;
	}

	public Cotation getCotMin() {
		return cotMin;
	}

	public void setCotMin(Cotation cotMin) {
		this.cotMin = cotMin;
	}

	public Cotation getCotMax() {
		return cotMax;
	}

	public void setCotMax(Cotation cotMax) {
		this.cotMax = cotMax;
	}

	public void setListeOrientationOut(Set<Orientation> listeOrientationOut) {
		this.listeOrientationOut = listeOrientationOut;
	}

	public List<Integer> getListeOrientationValues() {
		return listeOrientationValues;
	}

	public void setListeOrientationValues(List<Integer> listeOrientationValues) {
		this.listeOrientationValues = listeOrientationValues;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> pSession) {

		this.session = pSession;
	}

	public Set<Altitude> getListeAltitudeOut() {
		return listeAltitudeOut;
	}

	public void setListeAltitudeOut(Set<Altitude> listeAltitudeOut) {
		this.listeAltitudeOut = listeAltitudeOut;
	}

	public Set<Cotation> getListeCotationOut() {
		return listeCotationOut;
	}

	public void setListeCotationOut(Set<Cotation> listeCotationOut) {
		this.listeCotationOut = listeCotationOut;
	}

	public List<ListCot> getListeCotation() {
		return listeCotation;
	}

	public void setListeCotation(List<ListCot> listeCotation) {
		this.listeCotation = listeCotation;
	}

	public Integer getCotMinValue() {
		return cotMinValue;
	}

	public void setCotMinValue(Integer cotMinValue) {
		this.cotMinValue = cotMinValue;
	}

	public Integer getCotMaxValue() {
		return cotMaxValue;
	}

	public void setCotMaxValue(Integer cotMaxValue) {
		this.cotMaxValue = cotMaxValue;
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

	public Integer getLastPage() {
		return lastPage;
	}

	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}

	public RechercheSite getRecherche() {
		return recherche;
	}

	public void setRecherche(RechercheSite recherche) {
		this.recherche = recherche;
	}

	public List<Pays> getListePays() {
		return listePays;
	}

	public void setListePays(List<Pays> listePays) {
		this.listePays = listePays;
	}

	public List<State> getListeState() {
		return listeState;
	}

	public void setListeState(List<State> listeState) {
		this.listeState = listeState;
	}

	public Integer getPaysIdOut() {
		return paysIdOut;
	}

	public void setPaysIdOut(Integer paysIdOut) {
		this.paysIdOut = paysIdOut;
	}

	public Integer getStateIdOut() {
		return stateIdOut;
	}

	public void setStateIdOut(Integer stateIdOut) {
		this.stateIdOut = stateIdOut;
	}



}
