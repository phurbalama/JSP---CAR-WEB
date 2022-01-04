package com.zetcode.driver;


import java.util.List;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Login;

public class _loginParameter {

	public static void main(String[] args) {
		String sql = " SELECT USERID, ENCRYPTEDPASSWORD"
    			+ " FROM APP.USERIDANDENCRYPTEDPASSWORD";
		
		String url = "jdbc:derby://localhost:1527/carsDB"
				+";user=app;password=password1234";
		

    SQLExecutable<Login> exe = rs -> { 
    	
    	String username = rs.getString("USERID");
    	String password = rs.getString("ENCRYPTEDPASSWORD");
    	
		return new Login(username, password);
    };

    List<Login> logins = SQLUtility.execute(sql, url, ESQL.DATASOURCE, exe);
    	
    logins.forEach(System.out::println);
	}

}
