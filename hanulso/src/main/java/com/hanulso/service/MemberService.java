package com.hanulso.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hanulso.domain.MemberVo;
import com.hanulso.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper mapper;
	private final PasswordEncoder passwordEncoder;

	public int usernameCheck(final String username) {
		return mapper.countByUsername(username);
	}

	@Transactional
	public void insertMember(MemberVo member) {

		member.setPassword(passwordEncoder.encode(member.getPassword()));

		mapper.insertMember(member);
		System.out.println(member.getId());

	}

	public MemberVo loginCheck(String username, String password) {

		MemberVo member = mapper.loginCheck(username);
		String encodePassword = (member == null) ? "" : member.getPassword();
		
		if (member == null || passwordEncoder.matches(password, encodePassword) == false) {
			return null;
		} 

		return member;
	}

}
