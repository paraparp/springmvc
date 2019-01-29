package tt.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tt.pojo.Equipo;
import tt.pojo.Jugador;

@Transactional
@Repository
public class JugadorDaoImp implements JugadorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Jugador jugador) {
		getSession().save(jugador);

	}

	@Override
	public List<Jugador> findAll(Equipo equipo) {
		Criteria cr = getSession().createCriteria(Jugador.class).setFetchMode("jugador", FetchMode.JOIN)
				.add(Restrictions.eq("equipo.idEq", equipo.getIdEq()))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return cr.list();
	}

	@Override
	public Jugador findById(int id) {
		Criteria cr = getSession().createCriteria(Jugador.class).add(Restrictions.eq("idJug", id));
		return (Jugador) cr.uniqueResult();
	}

	@Override
	public List<Jugador> finByNombre(String jugador) {
		
	
		
		return null;
	}

	@Override
	public void update(Jugador jugador) {
		getSession().update(jugador);

	}

	@Override
	public void delete(Jugador jugador) {

		getSession().delete(jugador);

	}

}
