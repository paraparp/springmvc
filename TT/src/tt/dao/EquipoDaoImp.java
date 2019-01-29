package tt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tt.pojo.Equipo;


@Transactional
@Repository
public class EquipoDaoImp implements EquipoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Equipo equipo) {
		getSession().save(equipo);

	}

	@Override
	public List<Equipo> findAll() {

		Query query = getSession().createQuery("from Equipo");

		return query.list();
	}

	@Override
	public Equipo findById(int id) {
		Criteria cr = getSession().createCriteria(Equipo.class).add(Restrictions.eq("idEq", id));

		return (Equipo) cr.uniqueResult();
	}

	@Override
	public List<Equipo> finByNombre(String nombre) {
		Criteria cr = getSession().createCriteria(Equipo.class).add(Restrictions.like("nombre",  "%" + nombre + "%"));
		return cr.list();
	}

	@Override
	public void update(Equipo equipo) {
		getSession().update(equipo);

	}

	@Override
	public void delete(Equipo equipo) {
		getSession().delete(equipo);

	}

	@Override
	public List<Equipo> findByParameter(String p, String value) {
		Criteria cr = getSession().createCriteria(Equipo.class).add(Restrictions.eq(p,value)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		System.out.println("------>" + cr.list().size());
		return cr.list();
	}

	

}
