package sopra.formation.controller;


import java.util.List;

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
	
	@GetMapping(path ="/logout")
	public String logout(Model model, HttpSession session) {
		
		session.setAttribute("type", null);

		return "redirect:/home";
	}
	
	@PostMapping("/sinscrire")
	public String sinscrire(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result) {
		
		if(result.hasErrors()) {
			return "login/list";
		}

		utilisateurRepo.save(utilisateur);

		return "redirect:/home";
	}

	@PostMapping("/sidentifier")
	public String sidentifier(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {			
			return "login/list";
		}
		
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
		for (Utilisateur user : utilisateurs) {

			if (utilisateur.getUsername().contentEquals(user.getUsername())
					&& utilisateur.getMdp().contentEquals(user.getMdp())) {

		
				session.setAttribute("type", user.getType());
				session.setAttribute("username", user.getUsername());
				session.setMaxInactiveInterval(600);
				return "redirect:/home";
			}
		}
		

		return "login/list";

	}

}
