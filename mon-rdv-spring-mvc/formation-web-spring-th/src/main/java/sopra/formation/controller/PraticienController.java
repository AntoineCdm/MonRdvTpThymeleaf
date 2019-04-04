package sopra.formation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sopra.formation.monRdv.model.Praticien;
import sopra.formation.monRdv.repository.IPraticien;

@Controller
@RequestMapping("/praticien")
public class PraticienController {

	@Autowired
	private IPraticien praticienRepo;

	@GetMapping("")
	public String defaut() {
		return "redirect:/praticien/list";
	}

	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {
		List<Praticien> praticiens = praticienRepo.findAll();

		model.addAttribute("mesPraticiens", praticiens);

		return "praticien/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("monPraticien", new Praticien());

		return "praticien/form";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") Long id, Model model) {
		Optional<Praticien> opt = praticienRepo.findById(id);

		if (opt.isPresent()) {
			model.addAttribute("monPraticien", opt.get());
		}

		return "praticien/form";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("monPraticien") Praticien praticien, BindingResult result) {
		if (result.hasErrors()) {
			return "praticien/form";
		}

		praticienRepo.save(praticien);

		return "redirect:/praticien/list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam("id") Long id) {
		praticienRepo.deleteById(id);

		return "forward:/praticien/list";
	}

	@GetMapping("/cancel")
	public String cancel() {

		return "forward:/praticien/list";
	}
}
