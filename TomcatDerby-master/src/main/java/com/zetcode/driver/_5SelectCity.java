package com.zetcode.driver;
import java.util.List;

import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;
import com.zetcode.bean.City;

import static com.zetcode.util.GLOBAL.DB_URL;

public class _5SelectCity {

	public static void main(String[] args) {

String sql = " SELECT CITYID, REGIONNAME, INCOME "
			+ " FROM APP.VW_CITYSALES ";


SQLExecutable<City> exe = rs -> { 
	
	 
	
	String cityId = rs.getString("CITYID");
	String regionName = rs.getString("REGIONNAME");
	float income = rs.getFloat("INCOME");
	
	
			return new City(cityId,regionName,income);
};

List<City> cars = SQLUtility.execute(sql, DB_URL, ESQL.CONNECTION, exe);

cars.forEach(System.out::println);
	}

}
