package fr.mb.projet.action.site;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.struts2.interceptor.SessionAware;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import fr.mb.projet.bean.detail.Pays;
import fr.mb.projet.bean.detail.State;
import fr.mb.projet.contract.ManagerFactory;

public class JSONDateAction extends ActionSupport implements SessionAware {
	
	@Inject
	private ManagerFactory managerFactory;
	
	private Map<String, Object> session;
	
	private Pays pays;



	private Integer paysIdOut=75;
	private List<State>listState=new ArrayList<State>();
	private ArrayList <String> listJson = new ArrayList<String>();
	private Gson gson=new Gson();
	private String result;
	
	
	public JSONDateAction() {
		
	}


	public String getListDb() {
		this.listState = (List<State>) managerFactory.getStateManager().getDetailListByIdDb(this.paysIdOut);
		this.result=this.gson.toJson(this.listState);
		this.session.put("listState", this.listState);
		return ActionSupport.SUCCESS;
	}
	
	public String getList() {
		
	
		this.listState = (List<State>) managerFactory.getStateManager().getDetailListById(this.paysIdOut);
		
		
		this.result=this.gson.toJson(this.listState);
		this.session.put("listState", this.listState);
		
		return ActionSupport.SUCCESS;
	}
	
	
	public Integer getPaysIdOut() {
		return paysIdOut;
	}
	public void setPaysIdOut(Integer paysIdOut) {
		this.paysIdOut = paysIdOut;
	}
	public List<State> getListeState() {
		return listState;
	}
	public void setListeState(List<State> listState) {
		this.listState = listState;
	}


	public ManagerFactory getManagerFactory() {
		return managerFactory;
	}


	public void setManagerFactory(ManagerFactory managerFactory) {
		this.managerFactory = managerFactory;
	}
	public Pays getPays() {
		return pays;
	}


	public void setPays(Pays pays) {
		this.pays = pays;
	}


	public Gson getJson() {
		return gson;
	}


	public void setJson(Gson json) {
		this.gson = json;
	}


	public ArrayList <String> getListJson() {
		return listJson;
	}


	public void setListJson(ArrayList <String> listJson) {
		this.listJson = listJson;
	}


	public List<State> getListState() {
		return listState;
	}


	public void setListState(List<State> listState) {
		this.listState = listState;
	}


	public Gson getGson() {
		return gson;
	}


	public void setGson(Gson gson) {
		this.gson = gson;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
