package com.hanulso.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// 인증되지 않은 사용자가 리소스를 요청할 경우 Unauthorized 에러 발생하게끔
	// AuthenticationEntryPoint 구현

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "ㄲㅈㅅ");
		//response.sendRedirect("/err/401");
	}

}
