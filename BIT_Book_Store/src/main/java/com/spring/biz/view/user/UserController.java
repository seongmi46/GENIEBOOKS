package com.spring.biz.view.user;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.biz.email.DM;
import com.spring.biz.user.UserService;

@Controller
@SessionAttributes("user") 
public class UserController {
	@Autowired
	private UserService userService;
//	@Autowired
//	private EmailSender emailSender;
	
	public UserController() {
		System.out.println("--->> UserController() 객체생성");
	}
	
	@RequestMapping("/test.do")
	public String goSignup() {
		
		return "/Jungha/mem_Signup.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ID_Check.do", produces="text/plain")
	public String ID_Check(@RequestBody String paramData) {
		String id = paramData.trim();
		return Integer.toString(userService.ID_Check(id));
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/emailAuth.do", produces="text/plain")
//	public String emailAuth(@RequestBody String paramData) {
//		String email = paramData.trim();
//		System.out.println(email);
//		
//		EmailSend es = new EmailSend();
//		return es.emailSend(email, emailSender);
//	}
	
	@ResponseBody
	@RequestMapping(value = "/emailAuth.do", produces="text/plain")
	public String sendEmail(@RequestBody String email) throws AddressException, MessagingException {
		//6자리 인증코드 생성
		int rand = (int) (Math.random() * 899999) + 100000;
		  
		//보내는 사람 이메일 사이트
		String host = "smtp.gmail.com";
		  
		final String hostName = "geniebooks168";
		final String hostPwd = "wlslansrh168";
		int port = 465;//구글일 경우 465 네이버일 경우 587
		  
		//메일 내용
		String recieverEmail = email;
		String subject = "[지니문고] 회원가입 이메일 인증번호 인증";
		String body = DM.dmCertification(rand);
		  
		Properties props = System.getProperties();//정보를 담기 위한 객체 생성
		  
		//SMTP 서버 정보 설정
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		  
		  
		//session 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un = hostName;
			String pw = hostPwd;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(un, pw);
			}
		});
		  
		session.setDebug(true);
		  
		MimeMessage mimeMessage = new MimeMessage(session);//MimeMessage생성
		mimeMessage.setFrom(new InternetAddress("geniebooks168@gmail.com"));//발신자 세팅
		mimeMessage.setRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(recieverEmail));//수신자 세팅
		  
		mimeMessage.setSubject(subject);//제목세팅
		mimeMessage.setContent(body, "text/html;charset=utf-8");//내용세팅
		Transport.send(mimeMessage);
		  
		return rand + "";
	}
	
	
	
	
}
