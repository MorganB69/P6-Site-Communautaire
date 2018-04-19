package fr.mb.projet.impl;

import java.util.List;

import javax.inject.Named;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import fr.mb.projet.bean.spot.Site;
import fr.mb.projet.bean.topo.Topo;
import fr.mb.projet.contract.TopoDao;

@Named("topoDao")
@Transactional
public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao{

	@Override
	@Transactional
	public void persist(Topo topo) {
		template.save(topo);
		
	}

	@Override
	public void update(Topo topo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Topo findById(int id) {
		Topo e = (Topo) template.get(fr.mb.projet.bean.topo.Topo.class, id);
		return e;
	}

	@Override
	public void delete(Topo topo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Topo> findAll(Integer nbPage, Integer start) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM Topo ORDER BY id DESC");

		query.setFirstResult(start);
		query.setMaxResults(nbPage);

		List<Topo> list = query.list();

		session.close();

		return list;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long getCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String countQ = "SELECT COUNT(*) FROM Topo";
		Query countQuery = session.createQuery(countQ);
		Long countResults = (Long) countQuery.uniqueResult();

		session.close();
		return countResults;
	}

	@Override
	public List<Topo> findAllTopo() {
		List <Topo> l=template.loadAll(fr.mb.projet.bean.topo.Topo.class);
		return l;
	}

}
