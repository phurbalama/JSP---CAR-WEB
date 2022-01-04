package com.zetcode.service;

import com.citytech.basicsecurity.SimpleEncryption;
import com.zetcode.bean.Login;
import com.zetcode.persistence.LoginDAO;
public class LoginService {

	
public static boolean login(String userId, String password) {
		
		String encryptedPassword = SimpleEncryption.encrypt(password);
		Login user_pass = new Login(userId, encryptedPassword);
		int data = LoginDAO.exists(user_pass);
    
		if(data == 1) {
			return true;
		}
		return false;
	}


}
