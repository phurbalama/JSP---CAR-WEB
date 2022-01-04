package com.zetcode.driver;

import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;
import com.zetcode.bean.Group;

public class _SelectGroup {

	public static void main(String[] args) {

		
String sql = " SELECT GROUPID, Name, CITYID, PURCHASEMONTH, MONTHNUMBER" 
			+", SUM(PRICEPAID) AS pricePaid, SUM(VENDORPRICE) AS vendorPrice"
			+", SUM(INCOME) AS income FROM APP.VW_TRANSACTIONS" 
			+" WHERE QUARTER = 4 AND GROUPID = 'AB' GROUP BY GROUPID, Name, CITYID" 
			+", PURCHASEMONTH, MONTHNUMBER";
		
		

String url = "jdbc:derby://localhost:1527/carsDB"
			+";user=app;password=password1234";

SQLExecutable<Group> exe = rs -> { 
	
	  String groupId = rs.getString("GROUPID");
	  String name =rs.getString("Name");
	  String  cityId= rs.getString("CITYID");
	  String purchaseMonth = rs.getString("PURCHASEMONTH");
	  int monthNumber = rs.getInt("MONTHNUMBER");
	  float pricePaid = rs.getFloat("pricePaid");
	  float vendorPrice = rs.getFloat("vendorPrice");
	  float income = rs.getFloat("income");
	
	return new Group(groupId,name,cityId,purchaseMonth,monthNumber,pricePaid,vendorPrice,income);
};

List<Group> groups = SQLUtility.execute(sql, url, ESQL.CONNECTION, exe);

groups.forEach(System.out::println);
	}

}
