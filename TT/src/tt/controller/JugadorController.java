package tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tt.pojo.Equipo;
import tt.pojo.Jugador;
import tt.services.EquipoService;
import tt.services.JugadorService;

@Controller
@SessionAttributes("equipo")
public class JugadorController {

	@Autowired
	private JugadorService jugadorService;

	@Autowired
	private EquipoService equipoService;


	
	@RequestMapping("/jugadores/{idEq}")
	public String getAll(Model model, @PathVariable("idEq") int idEq) {

		Equipo equipo = equipoService.finById(idEq);
		Jugador jugador = new Jugador();

		model.addAttribute("equipo", equipo);
		model.addAttribute("jugador", new Jugador());
		model.addAttribute("jugadores", jugadorService.findAll(idEq));

		return "jugadores";
	}
	
	
	@RequestMapping("/jugador/{idJug}")
	public String verjugador(
			Model model, @PathVariable("idJug") int idJug)
			 {
		
		List<Equipo> lequipos = equipoService.findAll();
		//Equipo equipo = new Equipo();
	
		model.addAttribute("lequipos", lequipos);
		
		Jugador jugador = jugadorService.finById(idJug);
	model.addAttribute("jugador", jugador);
		
		return "jugador";
	}
	

	@RequestMapping("/jugadores/save")
	public String handleJugadores(Model model, @ModelAttribute("jugador") Jugador jugador, // para recoger lo que sale del form
			@ModelAttribute("equipo") Equipo equipo) { // para recoger el equio de la sessionAttribute

		jugadorService.saveOrUpdate(equipo, jugador);

		return "redirect:/jugadores/" + equipo.getIdEq();// redireccionamos al controlador inicial getAll
	}
	
	@RequestMapping("/jugadores/{idjug}/update")
	public String update(Model model, @PathVariable("idJug")  int idJug,@ModelAttribute("equipo") Equipo equipo ) {
		
		Jugador jugador = jugadorService.finById(idJug);
		
		model.addAttribute("jugador", jugador);
		
		return "redirect:/jugadores/" + equipo.getIdEq();
	}
	
	@RequestMapping("/jugadores/{idJug}/delete")
	public String delete(@PathVariable("idJug") int idJug, @ModelAttribute("equipo") Equipo equipo) {
		
		jugadorService.delete(idJug);
		
		return "redirect:/jugadores/" + equipo.getIdEq();
	}

}
