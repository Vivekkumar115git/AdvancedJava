package com.login.Dao;

import com.login.beans.User;

public interface LoginDao {

	User validateUser(String uname,String pass);
}
