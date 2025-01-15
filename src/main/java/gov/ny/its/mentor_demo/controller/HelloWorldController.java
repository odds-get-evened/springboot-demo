package gov.ny.its.mentor_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/another_place_to_go")
	public String anotherPlaceToGo() {
		return "another_place_to_go";
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="world") String name, Model model) {
		model.addAttribute("name", name);

		return "greeting";
	}
}
