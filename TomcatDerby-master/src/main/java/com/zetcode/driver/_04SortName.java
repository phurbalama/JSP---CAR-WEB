package com.zetcode.driver;

import java.text.DecimalFormat;
import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;
import com.zetcode.service.CarsService;

public class _04SortName {

	public static void main(String[] args) {
		
String sql = " SELECT ID, NAME, PRICE, VENDORPRICE "
			+ " FROM APP.CARS ORDER BY NAME ";

String url = "jdbc:derby://localhost:1527/carsDB"
			+";user=app;password=password1234";

SQLExecutable<Car> exe = rs -> { 
	
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	 
	
	Long id = rs.getLong("ID");
	String name = rs.getString("NAME");
	float price = rs.getFloat("PRICE");
	float vendorPrice = rs.getFloat("VENDORPRICE");
	float profit = Float.valueOf(twoDForm.format(rs.getFloat("PRICE") - rs.getFloat("VENDORPRICE")));
	return new Car(id,name,price,vendorPrice,profit);
};

List<Car> cars = SQLUtility.execute(sql, url, ESQL.CONNECTION, exe);

cars.forEach(System.out::println);

System.out.println(cars.get(1).getProfit());

	}

	
}
