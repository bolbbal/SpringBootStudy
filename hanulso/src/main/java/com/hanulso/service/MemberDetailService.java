package com.hanulso.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanulso.domain.MemberVo;
import com.hanulso.mapper.MemberMapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
@Builder
// 생성자를 통해 객체 생성할 수 있지만 객체를 생성할 수 있는 빌더를 build() 함수를 통해 얻고,
// 해당 객체에 세팅하고자 하는 값을 세팅한 후 마지막으로 build(). 를 통해 빌더 작동시켜 객체를 생성
public class MemberDetailService implements UserDetailsService {
	// UserDetailsService
	// DB에서 회원 정보를 가져오는 역할을 하는 인터페이스

	private final MemberMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// UserDetails
		// 회원 정보를 담기위해 사용하는 인터페이스
		MemberVo member = mapper.loginCheck(username);

		String encodePassword = (member == null) ? "" : member.getPassword();

		if (member == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder()
				.username(member.getUsername())
				.password(encodePassword)
				.authorities(member.getRole())
				.build();
		// User Userdetails 인터페이스 구현
	}

}
