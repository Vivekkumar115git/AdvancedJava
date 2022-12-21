package com.demo.service;

import com.demo.beans.User;

import comn.demo.dao.LoginDao;
import comn.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	private LoginDao loginDao;
	public LoginServiceImpl() {
	    loginDao=new LoginDaoImpl();
	}
	@Override
	public User validateUser(String uname, String pass) {
		return loginDao.validateUser(uname,pass);
}
}