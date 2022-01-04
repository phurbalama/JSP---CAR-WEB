package com.zetcode.driver;

import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;

public class _02SelectWithParameter {

	public static void main(String[] args) {

String sql = " SELECT ID, NAME, PRICE, VENDORPRICE"
			+ " FROM APP.CARS"
			+ " Where ID = ?";

String url = "jdbc:derby://localhost:1527/carsDB"
			+";user=app;password=password1234";

SQLExecutable<Car> exe = rs -> { 
	
	Long id = rs.getLong("ID");
	String name = rs.getString("NAME");
	float price = rs.getFloat("PRICE");

	float vendorPrice = rs.getFloat("PRICE");
	return new Car(id,name,price, vendorPrice);
};

List<Car> cars = SQLUtility.execute(sql, url, ESQL.CONNECTION, exe, 9);

cars.forEach(System.out::println);
	}

}
