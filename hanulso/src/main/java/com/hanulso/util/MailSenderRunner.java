package com.hanulso.util;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MailSenderRunner {

	private final JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String from;

	public String sendMail(String mail) {

		Random random = new Random();

		int checkNum = random.nextInt(888888) + 111111;
		System.out.println("인증번호 : " + checkNum);

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(mail);
		message.setSubject("하늘소 회원가입");
		String content = "이런 귀한 곳에 누추한 분이 가입하시다니 영광입니다." + "<br><br>" + "인증 번호는 " + checkNum + " 입니다." + "<br><br>"
				+ "인증 번호를 입력란에 입력해주세요.";
		message.setText(content);
		message.setSentDate(new Date());

		mailSender.send(message);

		String num = Integer.toString(checkNum);

		return num;
	}
}
