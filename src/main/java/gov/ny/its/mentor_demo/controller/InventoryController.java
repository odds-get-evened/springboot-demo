package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {
	@Autowired
	private InventoryRepo inventoryRepo;

	@GetMapping("/inv")
	public String invList(Model model) {
		model.addAttribute("items", inventoryRepo.findAll());

		return "inventory";
	}
}
