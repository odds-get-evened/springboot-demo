package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@GetMapping("/account/register")
	public String registration(Model model) {
		model.addAttribute("user", new UserEntity());

		return "account/register";
	}

	@PostMapping("/account/register")
	public String procRegistration(@ModelAttribute UserEntity user, Model model) {
		model.addAttribute("user", user);

		return "account/register-success";
	}
}
