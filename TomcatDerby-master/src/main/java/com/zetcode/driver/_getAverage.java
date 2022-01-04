package com.zetcode.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.jbbwebsolutions.service.IStatisticsService;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;

public class _getAverage implements IStatisticsService<String> {
	public static void main(String[] args) {
		
		_getAverage avg = new _getAverage();
		
		
		/*float average = 0;
		String url = "jdbc:derby://localhost:1527/carsDB"
				+";user=app;password=password1234";
ResultSet resultSet = null;

try (Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();) {

    // Create and execute a SELECT SQL statement.
    String selectSql = " SELECT AVG(PRICE-VENDORPRICE) AS AVERAGE "
    		+" FROM APP.CARS ";
    resultSet = statement.executeQuery(selectSql);

    // Print results from select statement
    while (resultSet.next()) {
        average = resultSet.getFloat(1);
    }
}
catch (SQLException e) {
    e.printStackTrace();
}
System.out.println(average);
	}
*/
}
}
