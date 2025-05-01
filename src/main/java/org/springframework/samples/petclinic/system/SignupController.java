package org.springframework.samples.petclinic.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.samples.petclinic.model.UserDto;

@Controller
public class SignupController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/signup")
	public String signupForm(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "signup";
	}

	@PostMapping("/signup")
	public String processSignup(@ModelAttribute UserDto userDto, RedirectAttributes redirectAttributes) {
		// username 중복 체크
		Integer count = jdbcTemplate.queryForObject(
			"SELECT COUNT(*) FROM users WHERE username = ?", Integer.class, userDto.getUsername());

		if (count != null && count > 0) {
			redirectAttributes.addFlashAttribute("errorMessage", "이미 존재하는 아이디입니다.");
			return "redirect:/signup";
		}

		// 비밀번호 암호화 후 저장
		String encodedPassword = passwordEncoder.encode(userDto.getPassword());
		jdbcTemplate.update("INSERT INTO users (username, password, enabled) VALUES (?, ?, true)",
			userDto.getUsername(), encodedPassword);

		// 권한 저장
		jdbcTemplate.update("INSERT INTO authorities (username, authority) VALUES (?, 'ROLE_USER')",
			userDto.getUsername());

		// (추가) 이메일, 이름 저장하려면 users 테이블에 컬럼이 필요 (현재 구조에선 따로 저장 X)

		redirectAttributes.addFlashAttribute("signupSuccess", "회원가입이 완료되었습니다. 로그인 해주세요!");
		return "redirect:/login?signupSuccess";
	}
}
