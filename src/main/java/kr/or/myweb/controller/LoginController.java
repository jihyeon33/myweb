package kr.or.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	//로그인 폼
	@GetMapping(path="/member/login.do")
	public String loginForm() {
		System.out.println("로그인폼 화면으로 이동합니다.");
		return "member/login";
	}
	//로그인 처리
	@PostMapping(path="/member/login.do")
	public String login(String id, String password, HttpSession session) {
		System.out.println("아이디는:"+id+",패스워드는:"+password);
		return "redirect:/index.jsp";
	}
	//로그아웃 처리

}
