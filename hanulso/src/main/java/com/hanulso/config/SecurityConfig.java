package com.hanulso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 사용자 계정 생성
	@Bean
	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
		UserDetails user = User.withUsername("admin") // 사용자 이름
				.password(passwordEncoder.encode("password")) // 비밀번호 암호화
				.roles("USER") // 사용자 권한
				.build();

		return new InMemoryUserDetailsManager(user); // 메모리에서 관리
	}

	// 책 150 페이지에 있긴 한데 똑같이는 ㄴㄴ (틀딱버전임)
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable() // CSRF 보호 비활성화 (테스트 용도로만)
//				.authorizeHttpRequests().requestMatchers("/", "/main", "/port/*").permitAll() // 인증 없이 접근 가능
//				.requestMatchers("/mem/*").authenticated() // 인증 필요
//				.anyRequest().authenticated() // 나머지 요청은 인증 필요
//				.and().formLogin().loginPage("/login") // 커스텀 로그인 페이지
//				.permitAll().and().logout().permitAll();
//		http.csrf().disable() // CSRF 보호 비활성화 (테스트용)
//				.authorizeHttpRequests().requestMatchers("/mem/mail.do").permitAll() // 인증 없이 접근 허용
//				.anyRequest().authenticated(); // 나머지 요청은 인증 필요
		return http.build();
	}

	@Bean
	public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
//		StrictHttpFirewall firewall = new StrictHttpFirewall();
//		firewall.setAllowUrlEncodedSlash(true); // 인코딩된 슬래시 허용
//		firewall.setAllowSemicolon(true); // 세미콜론 허용
//		firewall.setAllowUrlEncodedPercent(true); // 퍼센트 인코딩 허용
//		firewall.setAllowUrlEncodedDoubleSlash(true);
		return new DefaultHttpFirewall();
	}

}
