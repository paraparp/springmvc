package tt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import tt.pojo.Equipo;
import tt.services.EquipoService;

 
@Controller
@SessionAttributes("division")
public class CompeticionController {

	@Autowired
	private EquipoService equipoService;


	@RequestMapping("/competicion")
	public String showindex() {


		return "competicion";
	}
	
	@RequestMapping("/competicion/{division}")
	public String showCompeticion(Model model,@PathVariable("division")  String division) {

		
		List<Equipo> equiposDiv = equipoService.findByParameter("division", division);
		model.addAttribute("equiposDiv", equiposDiv);

		return "competicion";
	}



}
