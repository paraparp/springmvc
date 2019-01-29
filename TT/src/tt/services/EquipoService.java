package tt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tt.dao.EquipoDao;
import tt.pojo.Equipo;

@Service
public class EquipoService {

	@Autowired
	private EquipoDao equipoDao;

	public void save(Equipo equipo) {

		equipoDao.save(equipo);
	}

	public List<Equipo> findAll() {

		return equipoDao.findAll();
	}

	public Equipo finById(int id) {

		return equipoDao.findById(id);
	}

	public void saveOrUpdate(Equipo equipo) {
		
		System.out.println("----> " + equipo.toString());
		if (equipo.getIdEq() == null) {
			equipoDao.save(equipo);
		} else {
			equipoDao.update(equipo);
		}
	}

	public void delete(int idEq) {

		Equipo equipo = equipoDao.findById(idEq);

		equipoDao.delete(equipo);
	}

	public List<Equipo> findByParameter(String p, String value) {
		
		return equipoDao.findByParameter(p,value);
	}
	
}
