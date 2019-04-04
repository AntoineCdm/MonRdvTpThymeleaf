//package sopra.formation.controller;
//
//
//
//import javax.servlet.http.Cookie;
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import sopra.formation.monRdv.model.Utilisateur;
//import sopra.formation.monRdv.repository.IUtilisateur;
//
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//	
//	@Autowired
//	private IUtilisateur utilisateurRepo;
//	
//	@GetMapping("")
//	public String defaut() {
//<<<<<<< HEAD
//		return "redirect:/login/login";
//=======
//		return "redirect:/login/list";
//>>>>>>> master
//	}
//	
//	@GetMapping(path = { "/", "/list" })
//	public String list(Model model) {
//		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();
//
//		model.addAttribute("mesUtilisateurs", utilisateurs);
//
//		return "login/list";
//	}
//	
//	@PostMapping("/sinscrire")
//	public String sinscrire(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result) {
//		if(result.hasErrors()) {
//			return "login/login";
//		}
//		
//		utilisateurRepo.save(utilisateur);
//
//		return "redirect:/home";
//	}
//	
//	@PostMapping("/sidentifier")
//	public String sidentifier(@Valid @ModelAttribute("monUtilisateur") Utilisateur utilisateur, BindingResult result) {
//		if(result.hasErrors()) {
//			return "login/login";
//		}
//		
//		Cookie cookie = new Cookie("type", utilisateur.getType().toString());
//
//		
//		return "redirect:/home";
//	}
//
//}
