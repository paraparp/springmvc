package tt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tt.dao.EquipoDao;
import tt.dao.JugadorDao;
import tt.pojo.Equipo;
import tt.pojo.Jugador;

@Service
public class JugadorService {

	@Autowired
	private JugadorDao jugadorDao;
	@Autowired
	private EquipoDao equipoDao;

	public void save(Equipo equipo, Jugador jugador) {

		jugador.setEquipo(equipo);
		jugadorDao.save(jugador);

	}

	public Jugador finById(int id) {

		return jugadorDao.findById(id);
	}
	
	public Object findAll(int idEq) {
		Equipo equipo = equipoDao.findById(idEq);

		return jugadorDao.findAll(equipo);
	}
	
	public void saveOrUpdate(Equipo equipo, Jugador jugador) {

System.out.println("----->" + jugador.getIdJug());
		if (jugador.getIdJug() == null) {
			jugador.setEquipo(equipo);
			jugadorDao.save(jugador);
		} else {
			jugadorDao.update(jugador);
		}
	}

	public void delete(int idJug) {
		
		Jugador jugador = jugadorDao.findById(idJug);
		
		jugadorDao.delete(jugador);
		
	}

}
