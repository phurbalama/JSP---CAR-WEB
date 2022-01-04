package com.zetcode.driver;

import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Login;

public class _01Select {

	public static void main(String[] args) {

String sql = " SELECT USERID, ENCRYPTEDPASSWORD"
			+ " FROM APP.USERIDANDENCRYPTEDPASSWORD";

String url = "jdbc:derby://localhost:1527/carsDB"
			+";user=app;password=password1234";

SQLExecutable<Login> exe = rs -> { 
	
	String name = rs.getString("USERID");
	String pass = rs.getString("ENCRYPTEDPASSWORD");
	return new Login(name, pass);
};

List<Login> cars = SQLUtility.execute(sql, url, ESQL.CONNECTION, exe);

cars.forEach(System.out::println);
	}

}
