package com.login.service;

import com.login.beans.User;

public interface LoginService {

	User validateUser(String uname,String pass);
}
