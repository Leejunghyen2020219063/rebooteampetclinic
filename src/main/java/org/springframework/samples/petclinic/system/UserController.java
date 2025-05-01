package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping("/welcome")
	public String dashboard() {
		return "welcome"; // resources/templates/user/dashboard.html
	}
}
