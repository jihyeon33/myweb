package kr.or.myweb.service;

import kr.or.myweb.dto.LoginDto;

public interface LoginService {
	public LoginDto getUser(String userId, String password);
}
