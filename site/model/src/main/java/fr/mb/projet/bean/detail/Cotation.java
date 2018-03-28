package fr.mb.projet.bean.detail;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.mb.projet.bean.spot.Site;

@Entity
@Table(name = "cotation")
public class Cotation {
	@Id
	@Column(name = "cotation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cotationId;
	@Column(name = "type_cot")
	private String typeCot;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cot_id")
	private ListCot cot;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "site_id", nullable = false)
	private Site site;
	
	public Cotation() {

	}
	public Integer getCotId() {
		return cotationId;
	}
	public void cotationId(Integer cotId) {
		this.cotationId = cotId;
	}
	public String getTypeCot() {
		return typeCot;
	}
	public void setTypeCot(String typeCot) {
		this.typeCot = typeCot;
	}
	public ListCot getCot() {
		return cot;
	}
	public void setCot(ListCot cot) {
		this.cot = cot;
	}
	public Integer getCotationId() {
		return cotationId;
	}
	public void setCotationId(Integer cotationId) {
		this.cotationId = cotationId;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	
	
}
