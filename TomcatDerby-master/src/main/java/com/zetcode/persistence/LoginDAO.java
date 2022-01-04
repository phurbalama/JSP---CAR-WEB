package com.zetcode.persistence;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Login;
import java.util.List;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

public class LoginDAO {


    
	
   
    public static int exists(Login model) {

    	String sql = " SELECT COUNT(*) AS EXIST"
    			+ " FROM APP.USERIDANDENCRYPTEDPASSWORD"
    			+ " WHERE USERID = ?"
    			+" AND ENCRYPTEDPASSWORD = ? ";

    	SQLExecutable<Integer> exe = rs -> { 
        	
        	int data = rs.getInt("EXIST");
    		return data;
        };

        List<Integer> login = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, exe, model.getUsername(),model.getPassword());
        return login.get(0);
    }


	


    
    
  


}
