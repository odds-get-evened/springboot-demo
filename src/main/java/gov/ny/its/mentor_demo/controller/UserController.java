package gov.ny.its.mentor_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/account/register")
	public String registration() {
		return "account/register";
	}
}
