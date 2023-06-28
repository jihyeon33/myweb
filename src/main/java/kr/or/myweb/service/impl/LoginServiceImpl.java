package kr.or.myweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.myweb.dao.LoginDao;
import kr.or.myweb.dto.LoginDto;
import kr.or.myweb.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDao loginDao;
	@Override
	public LoginDto getUser(String userId, String password) {
		return loginDao.getUser(userId, password);
	}

}
