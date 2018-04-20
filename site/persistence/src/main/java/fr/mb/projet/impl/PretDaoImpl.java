package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.topo.Pret;
import fr.mb.projet.contract.PretDao;

@Named("pretDao")
@Transactional
public class PretDaoImpl extends AbstractDaoImpl implements PretDao {

	@Override
	public void persist(Pret pret) {
		template.save(pret);
		
	}

	@Override
	public void update(Pret pret) {
		template.saveOrUpdate(pret);
		
	}

	@Override
	public Pret findById(int id) {
		Pret e = (Pret) template.get(fr.mb.projet.bean.topo.Pret.class, id);
		return e;
	}

	@Override
	public void delete(Pret pret) {
		template.delete(pret);
		
	}

	@Override
	public List<Pret> findAllPret() {
		List <Pret> l=template.loadAll(fr.mb.projet.bean.topo.Pret.class);
		return l;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return null;
	}

}
