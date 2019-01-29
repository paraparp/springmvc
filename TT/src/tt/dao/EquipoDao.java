package tt.dao;

import java.util.List;

import tt.pojo.Equipo;

public interface EquipoDao {

	
	public void save (Equipo equipo);
	public List<Equipo> findAll();
	public Equipo findById(int id);
	public List <Equipo> finByNombre(String equipo);
	public void update(Equipo equipo);
	public void delete(Equipo equipo);
	public List<Equipo> findByParameter(String p, String value);
}
