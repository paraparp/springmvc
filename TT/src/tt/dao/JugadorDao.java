package tt.dao;

import java.util.List;

import tt.pojo.Equipo;
import tt.pojo.Jugador;

public interface JugadorDao {
	
	public void save (Jugador jugador);
	public List<Jugador> findAll(Equipo equipo);
	public Jugador findById(int id);
	public List <Jugador> finByNombre(String jugador);
	public void update(Jugador jugador);
	public void delete(Jugador jugador);

}
