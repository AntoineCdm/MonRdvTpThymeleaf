package sopra.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sopra.formation.monRdv.model.Praticien;
import sopra.formation.monRdv.repository.IPraticien;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private IPraticien praticienRepo;
	
	@GetMapping("")
	public String defaut() {
		return "redirect:/home";
	}
	
	@GetMapping(path = {"/home" })
	public String home(Model model) {

		return "home";
	}
	
	@GetMapping("pratician-list")
	public String searchPraticien(Model model) {
		
		List<Praticien> praticiens_tmp = praticienRepo.findAll();
		List<Praticien> praticiens = praticienRepo.findAll();
		
		for( Praticien praticien: praticiens_tmp) {
			if(praticien.getNom().matches("(.*)Caumes(.*)"));
			praticiens.add(praticien);
		}
		
		model.addAttribute("mesPraticiens", praticiens);



		return "/search-pratician/pratician-list";
	}
}
