package com.designerclau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController {
	
	  @Autowired
      private IngredientsService service;
      
	  @RequestMapping("/")
	  public String viewHomePage(Model model) {
		  List<Ingredients> listIngredients = service.listAll();
		  model.addAttribute("listIngredients", listIngredients);
		  return "index";
	  }
	  
	  @RequestMapping("/new")
	  public String showNewIngredientForm(Model model) {
		  Ingredients ingredients = new Ingredients();
		  model.addAttribute("ingredients", ingredients);
		  return "new_ingredients";
	  }
	  
	  @RequestMapping(value = "/save", method=RequestMethod.POST)
	  public String saveIngredient(@ModelAttribute("ingredients") Ingredients ingredients) {
		  service.save(ingredients);
		  return  "redirect:/";
	  }
	  
	  @RequestMapping("/edit/{id}")
	  public ModelAndView showEditIngredientForm(@PathVariable(name = "id") Long id) {
		  ModelAndView mod = new ModelAndView("edit_ingredients");
		  
		  Ingredients ingredients = service.get(id);
		  mod.addObject("ingredients", ingredients);
		  return mod;
	  }
	  
	  @RequestMapping("/delete/{id}")
		public String deleteProduct(@PathVariable(name="id") Long id) {
			service.delete(id);
			return "redirect:/";
	 }
	  
}
