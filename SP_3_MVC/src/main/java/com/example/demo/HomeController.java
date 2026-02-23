package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		User user = new User(101,"John","Punjab");
		model.addAttribute("user",user);
		return "home";
	}
	@GetMapping("/login")
	public String loginMapper() {
		return "login";
	}
}