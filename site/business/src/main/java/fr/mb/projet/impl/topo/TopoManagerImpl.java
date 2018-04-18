package fr.mb.projet.impl.topo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.contract.SiteDao;
import fr.mb.projet.contract.TopoDao;
import fr.mb.projet.contract.TopoManager;
import fr.mb.projet.exception.FunctionalException;
import fr.mb.projet.exception.NotFoundException;
import fr.mb.projet.exception.TechnicalException;

@Named("topoManager")
@Service
@Transactional
public class TopoManagerImpl implements TopoManager {
	
	@Inject
	TopoDao topoDao;

	@Override
	public Topo getTopo(Integer topoId) throws NotFoundException {
		Topo vTopo = topoDao.findById(topoId);

		return vTopo;
	}

	@Override
	public List<Topo> getListTopo(Integer nbPage, Integer start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Topo topo) throws FunctionalException, TechnicalException {
		if (topo == null) {
			throw new FunctionalException("Le topo est null !");
		}

		topoDao.persist(topo);
	}

	@Override
	public void update(Topo topo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getCount(Integer pageSize, Integer start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topo> getListAllTopo() {
		List<Topo> l = topoDao.findAllTopo();
		return l;
	}

	

}
