package com.zetcode.driver;

import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;

public class _03UpdateWithParameter {

	public static void main(String[] args) {

		String sql = " UPDATE CARS "
				+ " SET VENDORPRICE = ? "
				+ " WHERE ID = ? ";

	String url = "jdbc:derby://localhost:1527/carsDB"
				+";user=app;password=password1234";


	int status = SQLUtility.update(sql, url, ESQL.CONNECTION, 34_000,7);

	System.out.println(status);
	}

}
