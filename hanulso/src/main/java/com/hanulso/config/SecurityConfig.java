package com.hanulso.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) //security 6.x 이상
public class SecurityConfig {

	// 비밀번호 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 사용자 계정 생성
//	@Bean
//	public UserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
//		UserDetails user = User.withUsername("admin") // 사용자 이름
//				.password(passwordEncoder.encode("password")) // 비밀번호 암호화
//				.roles("USER") // 사용자 권한
//				.build();
//
//		return new InMemoryUserDetailsManager(user); // 메모리에서 관리
//	}

	// 책 150 페이지에 있긴 한데 똑같이는 ㄴㄴ (틀딱버전임)
	// 인증, 인가를 처리함
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//책 169페이지에서 로그인
		// 3.x 버전 이상은 lamda 식으로 표현해야함
		http
		.formLogin((formlogin) -> formlogin
				.loginPage("/mem/login") //로그인 페이지 url 요청 주소
				.usernameParameter("username") //로그인 시 사용할 파라미터 이름 설정
				.defaultSuccessUrl("/") //로그인 성공 시 redirect
				.failureUrl("/mem/login") //로그인 실패 시 redirect
				)
		.logout((logout) -> logout
				.logoutRequestMatcher(new AntPathRequestMatcher("/mem/logout"))
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				)
		.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/error").permitAll()
				.requestMatchers("/index").permitAll()
				.requestMatchers("/", "/mem/**", "/port/**").permitAll()
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll() //이 위에 설정되지 않은 요청은 차단
				)
		.exceptionHandling(handling -> handling
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
				)
		;
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
