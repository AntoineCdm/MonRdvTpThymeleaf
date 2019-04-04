package sopra.formation.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sopra.formation.monRdv.model.Utilisateur;
import sopra.formation.monRdv.repository.IUtilisateur;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IUtilisateur utilisateurRepo;
	
	@GetMapping("")
	public String defaut() {
		return "redirect:/login/list";
	}
	
	@GetMapping(path = { "/", "/list" })
	public String list(Model model) {
	
		model.addAttribute("monUtilisateur", new Utilisateur());

		return "login/list";
	}
	
	@PostMapping("/sinscrire")
	public String sinscrire(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result) {
		
		if(result.hasErrors()) {
			return "login";
		}
		
		utilisateurRepo.save(utilisateur);

		return "redirect:/home";
	}
	
	@PostMapping("/sidentifier")
	public String sidentifier(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "login";
		}
		session.setAttribute("type", "admin");
		//insérer ici ce qu'il faut pour récupérer compte

		
		return "redirect:/home";
	}

}
