package gov.ny.its.mentor_demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	/**
	 * for smoke-testing and endpoint(s) (see test packages)
	 * @return a string
	 */
	@GetMapping("/smoke-test")
	public @ResponseBody String smokeTest() {
		return "Hello, World";
	}

	@GetMapping("/user/login")
	public String userLogin() { return "user/login"; }

	@GetMapping("/login/oauth2/code/okta")
	public String ssoLoginSucces() {
		return "redirect:/secret/place";
	}

	@GetMapping("/secret/place")
	public String secretPlace(@AuthenticationPrincipal OidcUser principal) {
		return "secret/place";
	}
}
