package org.springframework.samples.petclinic.system;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/dashboard")
	public String dashboard(Authentication authentication) {
		if (authentication != null && authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			return "admin/dashboard"; // admin/dashboard.html 반환
		} else {
			return "welcome"; // 권한 없으면 다른 페이지로 리다이렉트
		}
	}
}
