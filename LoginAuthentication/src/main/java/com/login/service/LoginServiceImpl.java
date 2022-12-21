package com.login.service;

import com.login.Dao.LoginDao;
import com.login.Dao.LoginDaoImpl;
import com.login.beans.User;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	
	public LoginServiceImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public User validateUser(String uname, String pass) {
		
		return loginDao.validateUser(uname,pass);
	}
	
	

}
