package fr.mb.projet.contract;

import java.util.List;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

public interface TopoManager {
	
	public Topo getTopo (Integer topoId) throws NotFoundException;
	
	public List<Topo> getListTopo(Integer nbPage,Integer start);
	
	public List<Topo> getListAllTopo();
	
	public void insert(Topo topo) throws FunctionalException, TechnicalException;

	public void update(Topo topo);

	public Integer getCount(Integer pageSize, Integer start);

}
