package fr.mb.projet.bean.detail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Pays implements Serializable{
	
	@Id
	@Column(name = "country_id")
	private Integer id;
	@Column(name = "sortname")
	private String sortName;
	@Column(name = "name")
	private String name;
	@Column(name = "phonecode")
	private Integer phoneCode;
	
	
	
	
	public Pays() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPhoneCode() {
		return phoneCode;
	}
	public void setPhoneCode(Integer phoneCode) {
		this.phoneCode = phoneCode;
	}
	
	

}
