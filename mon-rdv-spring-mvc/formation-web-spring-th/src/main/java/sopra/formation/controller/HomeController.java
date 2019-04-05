package sopra.formation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping(path = { "/home" })
	public String home(Model model) {

		return "home";
	}

	@PostMapping("pratician-list")
	public String searchPraticien(Model model, @RequestParam("nom") String nom) {

		List<Praticien> praticiens_tmp = praticienRepo.findAll();
		List<Praticien> praticiens = new ArrayList<Praticien>();

		for (Praticien praticien : praticiens_tmp) {
			if (praticien.getNom().matches("(.*)"+nom+"(.*)")) {
				praticiens.add(praticien);
			}
		}

		model.addAttribute("mesPraticiens", praticiens);

		return "/search-pratician/pratician-list";
	}
}
