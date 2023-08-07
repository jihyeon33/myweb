package kr.or.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.myweb.dto.LoginDto;
import kr.or.myweb.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	
	//로그인 폼
	@GetMapping(path="/login/login.do")
	public String loginForm() {
		System.out.println("로그인폼 화면으로 이동합니다.");
		return "login/login";
	}
	//로그인 처리
	@PostMapping(path="/login/login.do")
	public String login(String id, String password, HttpSession session, RedirectAttributes rttr) {
		System.out.println("아이디는:"+id+",패스워드는:"+password);
		System.out.println("아래는 서비스 호출 결과.");
		LoginDto loginDto = loginService.getUser(id, password);
		session.setAttribute("loginDto", loginDto);
		
		if(session.getAttribute("loginDto") != null) {
			System.out.println(loginDto.getId());
			System.out.println(loginDto.getEmail());
			System.out.println(loginDto.getRegDate());	
			rttr.addFlashAttribute("msg", "로그인 되었습니다.");  
		}else {
			System.out.println("조회된 로그인정보가 없습니다.");
		}
		//return "redirect:/bank/bankMain.do";
		return "redirect:/main.do";
	}
	//로그아웃 처리

}
