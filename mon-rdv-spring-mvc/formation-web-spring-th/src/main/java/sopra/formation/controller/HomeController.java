package sopra.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("")
	public String defaut() {
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/", "/home" })
	public String home(Model model) {

		return "home";
	}
	
	@GetMapping("pratician-list")
	public String getPratician(Model model) {

		return "/search-pratician/pratician-list";
	}
}
