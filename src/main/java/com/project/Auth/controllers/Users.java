package com.project.Auth.controllers;

import com.project.Auth.models.User;
import com.project.Auth.repositories.RoleRepository;
import com.project.Auth.repositories.UserRepository;
import com.project.Auth.services.UserService;
import com.project.Auth.validators.UserValidator;

import java.security.Principal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import com.project.Auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.project.Auth.models.Role;


@Controller
public class Users {
	private UserService userService;
	private UserValidator userValidator;

	
	
	public Users(UserService userService, UserValidator userValidator){
		this.userService= userService;
		this.userValidator=userValidator;
	}


	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			
			return "loginPage";
		}else{
			userService.saveWithUserRole(user);
				
			return "redirect:/";
		}
	}	

			
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String username = principal.getName();
		
		model.addAttribute("currentUser", userService.findByUsername(username));
		model.addAttribute("users", userService.findAll());
		model.addAttribute("users_roles", userService.findAlls());
		
		return "adminPage";
	}
	

// renders page
	@RequestMapping("/loginuser")
	public String login(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successfull!");
		}
		return "loginPage";	
	}
	


	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		User currentuser = userService.findByUsername(principal.getName());
		for(Role role: currentuser.getRoles()){
			if(role.getName().equals("ROLE_ADMIN")){
				return "redirect:/admin";
			}else{
			
			}
		}return "homePage";
	}


	@RequestMapping(path ="admin/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}


	
	@RequestMapping(path ="/admin/upgrade/{id}")
	public String promote(@PathVariable("id") Long id) {
		userService.saveUserWithAdminRole(userService.get(id));
		return "redirect:/admin";
	}


	}
