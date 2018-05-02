package fr.mb.projet.action.site;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

import fr.mb.projet.bean.detail.Altitude;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.NotFoundException;

public class updateAction extends ActionSupport implements SessionAware, Preparable {
	
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
	
	/**
	 * Type de site possibles
	 */
	private List<String> listType=new ArrayList<String>();
	
	/**
	 * Boolean permettant de définir si le site a été modifié ou non
	 */
	private Boolean modif=false;
	
	/**
	 *Site à modifier 
	 */
	private Site site;
	
	/**
	 * Informations d'un site à récupérer en sortie
	 * 
	 */
	private Site siteOut;
	
	/**
	 *permet de modifier l'altitude minimum
	 */
	private Altitude altMin;
	/**
	 *permet de modifier l'altitude maximum
	 */
	private Altitude altMax;
	
	/**
	 *permet de modifier l'altitude moyenne 
	 */
	private Altitude altMoy;
	
	/**
	 * Liste d'Altitude qui sera comprise dans un Site
	 */
	private Set<Altitude> listeAltitudeOut = new HashSet<Altitude>();
	
	
	
	
	
	/**
	 * Méthode de modification du site
	 * @return
	 */
	public String update() {
		
				String result = ActionSupport.INPUT;
				

				this.listType.add("Falaise");
				this.listType.add("Bloc");
				this.listType.add("Artificiel");

				session.put("listeType", this.listType);
				// Accès à la BD pour récupérer les listes prédéfinies d'Orientation et Cotation
				// et les mettre
				// dans une session

				// ----------ENREGISTREMENT DU SITE----------

				if (this.modif != false) {

					// -------------- Validation des données saisies--------------
					if (this.site.getNom().length() == 0 || this.site.getNom() == null) {
						this.addFieldError("site.nom", "ne doit pas être vide");
					}

					// Si pas d'erreur, rajout des différents attributs au site enregistrement du
					// site
					if (!this.hasErrors()) {
						System.out.println("site: "+this.site);
						
						this.siteOut=(Site)session.get("siteOut");
						
						
						//Modification du site récupéré en base de donnée avec les nouvelles informations
						
						this.siteOut.setNom(this.site.getNom());
						this.siteOut.setAcces(this.site.getAcces());
						this.siteOut.setDescription(this.site.getDescription());
						this.siteOut.getCoordonnee().setX(this.site.getCoordonnee().getX());
						this.siteOut.getCoordonnee().setY(this.site.getCoordonnee().getY());
						this.siteOut.setNbSecteur(this.site.getNbSecteur());
						this.siteOut.setNbVoie(this.site.getNbVoie());
						this.siteOut.setType(this.site.getType());
						
						
						if(this.altMax!=null) {
							boolean max=false;
							
							if(this.siteOut.getListeAltitude()!=null) {
								for (Iterator iterator = this.siteOut.getListeAltitude().iterator(); iterator.hasNext();) {
									Altitude alt = (Altitude) iterator.next();
									if(alt.getTypeAlt().equals("max")) {
										alt.setAlt(this.altMax.getAlt());
										max=true;
									}		
								}						
						}
							if(max==false) {
								altMax.setTypeAlt("max");
								altMax.setSite(this.siteOut);
								this.siteOut.getListeAltitude().add(altMax);
							}
							
						}
						
						if(this.altMin!=null) {
							boolean min=false;
							
							if(this.siteOut.getListeAltitude()!=null) {
								for (Iterator iterator = this.siteOut.getListeAltitude().iterator(); iterator.hasNext();) {
									Altitude alt = (Altitude) iterator.next();
									if(alt.getTypeAlt().equals("min")) {
										alt.setAlt(this.altMin.getAlt());
										min=true;
									}		
								}						
						}
							if(min==false) {
								altMin.setTypeAlt("min");
								altMin.setSite(this.siteOut);
								this.siteOut.getListeAltitude().add(altMin);
							}
							
						}
						
						if(this.altMoy!=null) {
							boolean moy=false;
							
							if(this.siteOut.getListeAltitude()!=null) {
								for (Iterator iterator = this.siteOut.getListeAltitude().iterator(); iterator.hasNext();) {
									Altitude alt = (Altitude) iterator.next();
									if(alt.getTypeAlt().equals("moy")) {
										alt.setAlt(this.altMoy.getAlt());
										moy=true;
									}		
								}						
						}
							if(moy==false) {
								altMoy.setTypeAlt("moy");
								altMoy.setSite(this.siteOut);
								this.siteOut.getListeAltitude().add(altMoy);
							}
							
						}
						
						
						
						
						// Insertion du site en BD
						managerFactory.getSiteManager().update(this.siteOut);

						// Fin de l'action
						result = ActionSupport.SUCCESS;

						this.addActionMessage("Site modifié avec succès");

					}
				}

		return result;

	}
	


	@Override
	public void prepare() throws Exception {
		


		if (this.id == null) {
			this.addActionError(getText("error.project.missing.id"));
		} else {
			try {
				if (this.modif == false) {
					this.site = (Site) managerFactory.getSiteManager().getSite(this.id);
					session.put("siteOut", this.site);

					


					if (this.site.getListeAltitude() != null) {
						for (Iterator iterator = this.site.getListeAltitude().iterator(); iterator.hasNext();) {
							Altitude alt = (Altitude) iterator.next();
							if (alt.getTypeAlt().equals("min")) {
								this.altMin = alt;
							} else if (alt.getTypeAlt().equals("max")) {
								this.altMax = new Altitude();
								this.altMax = alt;
							} else if (alt.getTypeAlt().equals("moy")) {
								this.altMoy = new Altitude();
								this.altMoy = alt;
							}

						}

					}

				}
				}
			
				catch (NotFoundException Notfound) {
					this.addActionError(getText("error.project.notfound", Collections.singletonList(id)));
				}
			}
		
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





	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public List<String> getListType() {
		return listType;
	}





	public void setListType(List<String> listType) {
		this.listType = listType;
	}





	public Boolean getModif() {
		return modif;
	}





	public void setModif(Boolean modif) {
		this.modif = modif;
	}





	public Site getSite() {
		return site;
	}





	public void setSite(Site site) {
		this.site = site;
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



	public Site getSiteOut() {
		return siteOut;
	}



	public void setSiteOut(Site siteOut) {
		this.siteOut = siteOut;
	}



	public Set<Altitude> getListeAltitudeOut() {
		return listeAltitudeOut;
	}



	public void setListeAltitudeOut(Set<Altitude> listeAltitudeOut) {
		this.listeAltitudeOut = listeAltitudeOut;
	}







}
