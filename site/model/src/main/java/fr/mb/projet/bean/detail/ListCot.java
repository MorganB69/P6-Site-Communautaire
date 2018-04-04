package fr.mb.projet.bean.detail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe permettant de définir toutes les cotations existantes (liste fixe)
 * 
 * @author Morgan
 *
 */
@Entity
@Table(name = "list_cotation")
public class ListCot implements Serializable {

	/**
	 * L'ID
	 */
	@Id
	@Column(name = "cot_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	/**
	 * La valeur de la cotation (ex:9+)
	 */
	@Column(name = "cot")
	private String cot;

	public ListCot() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCot() {
		return cot;
	}

	public void setCot(String cot) {
		this.cot = cot;
	}

}
