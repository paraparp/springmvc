package tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tt.pojo.Equipo;
import tt.services.EquipoService;

@Controller
public class EquipoController {

	@Autowired
	private EquipoService equipoService;

	@RequestMapping("/index")
	public String showindex() {


		return "index";
	}
	
	@RequestMapping("/equipos")
	public String showEquipos(Model model) {

		
		List<Equipo> lequipos = equipoService.findAll();
		Equipo equipo = new Equipo();
		model.addAttribute("equipo", equipo);
		model.addAttribute("lequipos", lequipos);

		return "equipos";
	}
	



	@RequestMapping(value = "/equipos/save", method = RequestMethod.POST)
	public String handleEquipo(
			@ModelAttribute("equipo") Equipo equipoform, 
			Model model) {

//		equipoService.save(equipoform);
		equipoService.saveOrUpdate(equipoform);

		return "redirect:/equipos";
	}
	
	
	@RequestMapping("/equipos/{idEq}/update")
	public String update(Model model, @PathVariable("idEq")  int idEq ) {
		
		Equipo equipo = equipoService.finById(idEq);
		
		model.addAttribute("equipo", equipo);
		
		return "equipos";
	}
	
	
	@RequestMapping("/equipos/{idEq}/delete")
	public String delete(@PathVariable("idEq") int idEq) {
		

		equipoService.delete(idEq);
		
		return "redirect:/equipos";
	}
}
