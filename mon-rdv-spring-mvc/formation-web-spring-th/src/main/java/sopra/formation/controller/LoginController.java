package sopra.formation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String list(Model model, HttpSession session) {
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();

		model.addAttribute("mesUtilisateurs", utilisateurs);

		return "login/list";
	}

}
