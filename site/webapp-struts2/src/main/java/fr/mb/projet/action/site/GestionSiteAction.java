package fr.mb.projet.action.site;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
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
import fr.mb.projet.bean.detail.Situation;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.contract.ManagerFactory;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public class GestionSiteAction extends ActionSupport implements SessionAware {

	// Factory
	@Inject
	private ManagerFactory managerFactory;
	
	private Map<String, Object> session;

	// Attributs
	
		//Entrée
	private Integer id;
	private  List<Orientation> listeOrientation;
	private  List<ListCot> listeCotation;
	
		//Upload fichier
    private File file;
    private String fileContentType;
    private String fileFileName;
    
    
		//Sortie
	private List<Site> listSite;
	private Site site;
	private Situation situation;
	private Coordonnee coordonnee;
	private Altitude altMin;
	private Altitude altMax;
	private Altitude altMoy;
	private Cotation cotMin;
	private Cotation cotMax;
	private Cotation cotMoy;
	
	
	private List<Integer>listeOrientationValues;
	private Integer cotMinValue;
	private Integer cotMaxValue;
	private Integer cotMoyValue;
	
	private  Set<Orientation> listeOrientationOut=new HashSet<Orientation>();
	private  Set<Altitude> listeAltitudeOut=new HashSet<Altitude>();
	private  Set<Cotation> listeCotationOut=new HashSet<Cotation>();
	
	private Orientation orient;
	




	//------------------------ Méthodes-------------------------
	//----------------------------------------------------------
	
	
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

	public String add() throws NotFoundException {
		
		this.listeOrientation=(List<Orientation>) managerFactory.getOrientationManager().getDetailList();
		this.listeCotation=(List<ListCot>) managerFactory.getCotationManager().getDetailList();
		session.put("listeOrientation", this.listeOrientation);
		session.put("listeCotation", this.listeCotation);
		
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

					
					this.site.setImage(this.fileFileName);
					this.site.setDateAjout(new Date());
					
					
					this.situation.setSite(this.site);
					this.coordonnee.setSite(this.site);
					
					this.altMax.setTypeAlt("max");
					this.altMax.setSite(this.site);
					this.listeAltitudeOut.add(this.altMax);
					this.altMin.setTypeAlt("min");
					this.altMin.setSite(this.site);
					this.listeAltitudeOut.add(this.altMin);
					this.altMoy.setTypeAlt("moy");
					this.altMoy.setSite(this.site);
					this.listeAltitudeOut.add(this.altMoy);
					
					this.cotMin=new Cotation();
					this.cotMin.setSite(this.site);
					this.cotMin.setTypeCot("min");
					for (ListCot l : this.listeCotation) {
						if (this.cotMinValue==l.getId()) {
							this.cotMin.setCot(l);
						}
					}
					this.cotMax=new Cotation();
					this.cotMax.setSite(this.site);
					this.cotMax.setTypeCot("max");
					for (ListCot j : this.listeCotation) {
						if (this.cotMaxValue==j.getId()) {
							this.cotMax.setCot(j);
						}
					}
					
					this.cotMoy=new Cotation();
					this.cotMoy.setSite(this.site);
					this.cotMoy.setTypeCot("moy");
					for (ListCot h : this.listeCotation) {
						if (this.cotMoyValue==h.getId()) {
							this.cotMoy.setCot(h);
						}
					}

					
					this.listeCotationOut.add(this.cotMin);
					this.listeCotationOut.add(this.cotMax);
					this.listeCotationOut.add(this.cotMoy);
					
					
					if (session.containsKey("listOrientation"))
					    this.listeOrientation=(List<Orientation>)session.get("listOrientation");
					
					for (Orientation o : this.listeOrientation) {
						System.out.println(o.getOrientationId());
						}
					
					
					
					for (Integer val : this.listeOrientationValues) {
						for (Orientation o : this.listeOrientation) {
							if (val==o.getOrientationId()) {
								this.listeOrientationOut.add(o);
							}
						}
					}
							

					
					
					this.site.setSituation(this.situation);
					this.site.setCoordonnee(this.coordonnee);
					this.site.setListeOrientation(this.listeOrientationOut);
					this.site.setListeAltitude(this.listeAltitudeOut);
					this.site.setListeCotation(listeCotationOut);
					
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

	public List <Orientation> getListeOrientation() {
		return listeOrientation;
	}

	public void setListeOrientation(List <Orientation> listeOrientation) {
		this.listeOrientation = listeOrientation;
	}

	public Orientation getOrientation() {
		return orient;
	}

	public void setOrientation(Orientation orientation) {
		this.orient = orientation;
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

	public Cotation getCotMoy() {
		return cotMoy;
	}

	public void setCotMoy(Cotation cotMoy) {
		this.cotMoy = cotMoy;
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
		
		this.session=pSession;
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

	public Integer getCotMoyValue() {
		return cotMoyValue;
	}

	public void setCotMoyValue(Integer cotMoyValue) {
		this.cotMoyValue = cotMoyValue;
	}

	public Orientation getOrient() {
		return orient;
	}

	public void setOrient(Orientation orient) {
		this.orient = orient;
	}
	
}
