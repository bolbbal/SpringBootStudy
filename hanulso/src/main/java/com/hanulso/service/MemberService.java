package com.hanulso.service;

import org.springframework.stereotype.Service;

import com.hanulso.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberMapper member;
	// private final password

	public int usernameCheck(final String username) {
		return member.countByUsername(username);
	}

}
