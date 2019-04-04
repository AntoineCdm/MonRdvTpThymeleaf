package sopra.formation.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sopra.formation.monRdv.model.TodoItem;

@Controller
public class SessionAttributeController {
	
	
	@GetMapping("/form") 
	public String add(Model model) {
		//This method will be responsible for initializing the form and rendering the form view. 
		//The method will prepopulate the form with the most recently added TodoItem if the TodoList is not empty.
		model.addAttribute("monTodoItem", new TodoItem());

		return "todoIdem/form";
	}
	
	
	
	
	@PostMapping("/form")
	public String save(@Valid @ModelAttribute("monTodoItem") TodoItem todoItem, BindingResult result) {
	//This method will be responsible for adding the submitted TodoItem to the TodoList and redirecting to the list URL.
	if(result.hasErrors()) {
		return "matiere/form";
	}
	
	todoItemRepo.save(todoItem);

	return "redirect:/todoItem/list";
	}
	
	@GetMapping("/todos.html")
	//This method will simply add the TodoList to the Model for display and render the list view.

}
