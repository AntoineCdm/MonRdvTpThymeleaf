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

import sopra.formation.monRdv.model.Patient;
import sopra.formation.monRdv.repository.IPatient;

	@Controller
	@RequestMapping("/patient")
	public class PatientController {

		@Autowired
		private IPatient patientRepo;

		@GetMapping("")
		public String defaut() {
			return "redirect:/patient/list";
		}

		@GetMapping(path = { "/", "/list" })
		public String list(Model model) {
			List<Patient> patients = patientRepo.findAll();

			model.addAttribute("mesPatients", patients);

			return "patient/list";
		}

		@GetMapping("/add")
		public String add(Model model) {
			model.addAttribute("monPatient", new Patient());

			return "patient/form";
		}

		@GetMapping("/edit")
		public String edit(@RequestParam("id") Long id, Model model) {
			Optional<Patient> opt = patientRepo.findById(id);

			if (opt.isPresent()) {
				model.addAttribute("monPatient", opt.get());
			}

			return "patient/form";
		}

		@PostMapping("/save")
		public String save(@Valid @ModelAttribute("monPatient") Patient patient, BindingResult result) { // indique au controller de vérifier sur monPatient est conforme au fomrulaire. 
			if (result.hasErrors()) { // si il ne l'est pas affiche une erreur selon le th:error dans form
				return "patient/form";
			}

			patientRepo.save(patient);

			return "redirect:/patient/list";
		}

		@GetMapping("/remove")
		public String remove(@RequestParam("id") Long id) {
			patientRepo.deleteById(id);

			return "forward:/patient/list";
		}

		@GetMapping("/cancel")
		public String cancel() {

			return "forward:/patient/list";
		}
}
