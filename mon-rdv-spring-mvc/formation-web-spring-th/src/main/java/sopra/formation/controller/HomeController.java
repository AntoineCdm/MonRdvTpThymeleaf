package sopra.formation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sopra.formation.monRdv.repository.IPraticien;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	private IPraticien praticienRepo;
	
	@GetMapping("")
	public String defaut() {
		return "redirect:/home";
	}
}
