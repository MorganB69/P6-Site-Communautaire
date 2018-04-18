package fr.mb.projet.action.site;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.request.WebRequest;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.comment.Comment;
import fr.mb.projet.bean.detail.ListCot;
import fr.mb.projet.bean.spot.Secteur;
import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.spot.Voie;
import fr.mb.projet.bean.user.Utilisateur;
import fr.mb.projet.contract.ManagerFactory;

/**
 * Classe d'ajout d'un commentaire/voie/secteur à site
 * @author Morgan
 *
 */
public class AjoutAction extends ActionSupport implements SessionAware {
	
	/**
	 * Factory pour obtenir les managers de la couche business
	 */
	@Inject
	private ManagerFactory managerFactory;
	
	private Map<String, Object> session;
	private Comment comment;
	private Site site;
	private Utilisateur user;
	private Secteur secteur;
	private Voie voie;
	/**
	 * Liste des différentes cotations à récupérer en bd
	 */
	private List<ListCot> listeCotation = new ArrayList<ListCot>();
	private Integer cotVoie;
	

	
	
	public String addComment() {
				
		
		
		this.user = (Utilisateur) session.get("user");
		
		
		
		if(user!=null) {
		
		// Ajout d'une date
		this.comment.setDate(new Date());
		this.comment.setSite(this.site);
		this.comment.setUser(user);
		this.managerFactory.getCommentManager().insert(this.comment);}
		
		return ActionSupport.SUCCESS;
	}
	
	public String addSecteur() {
		
		this.user = (Utilisateur) session.get("user");
		
		if(user!=null) {
			
			
			
			this.secteur.setSite(this.site);

			this.managerFactory.getSecteurManager().insert(this.secteur);}
			
			return ActionSupport.SUCCESS;
	}
	
	public String addVoie() {
		
		this.user = (Utilisateur) session.get("user");
		
		if(user!=null) {
			
			// Récupération des objets en session
			if (session.containsKey("listCotation"))
				this.listeCotation = (List<ListCot>) session.get("listCotation");
			else
				this.listeCotation = (List<ListCot>) managerFactory.getCotationManager().getDetailList();
			
			System.out.println(this.cotVoie);
			
			// Récupération des objets dans les listes précédemment récupérée en BD
			for (ListCot l : this.listeCotation) {
				if (this.cotVoie == l.getId()) {
					this.voie.setCotation(l);
					System.out.println("Egalité : "+ l.getId());
				}
			}
			
			this.voie.setSite(this.site);

			this.managerFactory.getSecteurManager().insert(this.voie);}
			
			return ActionSupport.SUCCESS;
	}


	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public Site getSite() {
		return site;
	}


	public void setSite(Site site) {
		this.site = site;
	}





	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}


	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}





	public Utilisateur getUser() {
		return user;
	}


	public void setUser(Utilisateur user) {
		this.user = user;
	}




	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public Secteur getSecteur() {
		return secteur;
	}


	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}


	public Voie getVoie() {
		return voie;
	}


	public void setVoie(Voie voie) {
		this.voie = voie;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public List<ListCot> getListeCotation() {
		return listeCotation;
	}

	public void setListeCotation(List<ListCot> listeCotation) {
		this.listeCotation = listeCotation;
	}

	public Integer getCotVoie() {
		return cotVoie;
	}

	public void setCotVoie(Integer cotVoie) {
		this.cotVoie = cotVoie;
	}






}
