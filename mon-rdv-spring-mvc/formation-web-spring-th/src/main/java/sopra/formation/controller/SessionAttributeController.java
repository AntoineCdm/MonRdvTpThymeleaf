//package sopra.formation.controller;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.springframework.web.servlet.view.RedirectView;
//
//import sopra.formation.monRdv.model.TodoItem;
//import sopra.formation.monRdv.model.TodoList;
//import sopra.formation.monRdv.repository.ITodoItem;
//
//
//@Controller
//@RequestMapping("/todoItem")
//@SessionAttributes("todos")
//public class SessionAttributeController {
//	
//	@Autowired
//	private ITodoItem todoItemRepo;
//	
//	//Ajout Session
//	@ModelAttribute("todos")
//	public TodoList todos() {
//	    return new TodoList();
//	}
//	
//	//Ajout Session
//	@GetMapping("/form")
//	public String showForm(
//	  Model model,
//	  @ModelAttribute("todos") TodoList todos) {
//	  
//	    if (!todos.isEmpty()) {
//	        model.addAttribute("todo", todos.peekLast());
//	    } else {
//	        model.addAttribute("todo", new TodoItem());
//	    }
//	    return "todoItem/form";
//	}
//	
//	//Ajout Session
//	@PostMapping("/form")
//	public RedirectView create(
//	  @ModelAttribute TodoItem todo, 
//	  @ModelAttribute("todos") TodoList todos, 
//	  RedirectAttributes attributes) {
//	    todo.setCreateDate(LocalDateTime.now());
//	    todos.add(todo);
//	    attributes.addFlashAttribute("todos", todos);
//	    return new RedirectView("/todoItem/list.html");
//	}
//
//	@GetMapping("")
//	public String defaut() {
//		return "redirect:/todoItem/list";
//	}
//
//	@GetMapping(path = { "/", "/list" })
//	public String list(Model model) {
//		List<TodoItem> todoItems = todoItemRepo.findAll();
//
//		model.addAttribute("mesTodoItems", todoItems);
//
//		return "todoItem/list";
//	}
//
//	@GetMapping("/add")
//	public String add(Model model) {
//		model.addAttribute("monTodoItem", new TodoItem());
//
//		return "todoItem/form";
//	}
//
//	@GetMapping("/edit")
//	public String edit(@RequestParam("id") Long id, Model model) {
//		Optional<TodoItem> opt = todoItemRepo.findById(id);
//
//		if (opt.isPresent()) {
//			model.addAttribute("monTodoItem", opt.get());
//		}
//
//		return "todoItem/form";
//	}
//
//	@PostMapping("/save")
//	public String save(@Valid @ModelAttribute("maTodoItem") TodoItem todoItem, BindingResult result) {
//		if(result.hasErrors()) {
//			return "todoItem/form";
//		}
//		
//		todoItemRepo.save(todoItem);
//
//		return "redirect:/todoItem/list";
//	}
//	
//	@GetMapping("/remove")
//	public String remove(@RequestParam("id") Long id) {
//		todoItemRepo.deleteById(id);
//
//		return "forward:/todoItem/list";
//	}
//
//	@GetMapping("/cancel")
//	public String cancel() {
//
//		return "forward:/todoItem/list";
//	}
//
//}
