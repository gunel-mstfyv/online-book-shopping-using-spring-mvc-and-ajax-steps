package az.developia.bookshoppinggunelm.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import az.developia.bookshoppinggunelm.model.User;

@Controller
public class UserController {

	@GetMapping(path={"/show-login"})
	public String showLoginPage() {
		return "my-custom-login";
	}

	@GetMapping(path={"/create-account"})
	public String showCreateAccountPage(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "create-account";
	}
	
	@PostMapping(path="/create-account-process")
	public String saveUser(@Valid @ModelAttribute(name="user") User user,
			BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "create-account";
		}
		System.out.println(user);
	    return "redirect:/show-user";
	}

}
