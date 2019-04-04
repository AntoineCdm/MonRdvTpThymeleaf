package sopra.formation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class Test {
	@GetMapping("")
	public String defaut() {
		return "redirect:/test/list";
	}

	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {

		return "test/list";
	}
}
