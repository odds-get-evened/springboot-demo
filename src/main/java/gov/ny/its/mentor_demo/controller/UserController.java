package gov.ny.its.mentor_demo.controller;

import gov.ny.its.mentor_demo.entity.User;
import gov.ny.its.mentor_demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/user/add")
	public String addUser(Model model) {
		model.addAttribute("user", new User());

		return "user/add";
	}

	@PostMapping("/user/add")
	public String postAddUser(@ModelAttribute("user") User user, Model model) {
		String shaP = passwordEncoder.encode(user.getPasswd());
		user.setPasswd(shaP);
		userRepo.save(user);
		model.addAttribute("user", user);

		return "user/add-success";
	}

	@GetMapping("/user/login")
	public String userLogin(Model m) {
		m.addAttribute("user", new User());

		return "user/login";
	}

	@PostMapping("/user/login")
	public String procUserLogin(@ModelAttribute("user") User u, Model m) {
		String encPass = passwordEncoder.encode(u.getPasswd());
		u.setPasswd(encPass);

		userRepo.save(u);

		return "user/login-success";
	}
}
