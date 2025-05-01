package org.springframework.samples.petclinic.system;  // 패키지는 프로젝트 구조에 맞게 수정!

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "admin123";  // 여기 원하는 비밀번호 입력
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);
	}
}
