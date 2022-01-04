package com.zetcode.persistence;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.dao.IUpdate;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Car;
import java.text.DecimalFormat;
import java.util.List;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

public class CarDAO implements IQuery<Car>, IUpdate<Car> {


    @Override
    public int save(Car car) {
    	
    	String sql = " UPDATE CARS "
				+ " SET PRICE = ? "
				+ " WHERE ID = ? ";



	int status = SQLUtility.update(sql, DATA_SOURCE, ESQL.DATASOURCE, car.getPrice(),car.getId());
	return status;

	
    }

    @Override
    public Car findOne(Car model) {

    	String sql = " SELECT ID, NAME, PRICE, VENDORPRICE"
    			+ " FROM APP.CARS"
    			+ " Where ID = ?";

    SQLExecutable<Car> exe = rs -> { 
    	
    	Long id = rs.getLong("ID");
    	String name = rs.getString("NAME");
    	float price = rs.getFloat("PRICE");
    	float vendorPrice = rs.getFloat("VENDORPRICE");
		return new Car(id,name,price, vendorPrice);
    };

    List<Car> cars = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, exe, model.getId());
    	
    

        return cars.get(0);
    }

    @Override
    public List<Car> findAll() {

    	String sql = " SELECT ID, NAME, PRICE, VENDORPRICE " + 
    			" FROM APP.CARS ORDER BY NAME ";

    SQLExecutable<Car> exe = rs -> { 
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	Long id = rs.getLong("ID");
    	String name = rs.getString("NAME");
    	float price = rs.getFloat("PRICE");
    	float vendorPrice = rs.getFloat("VENDORPRICE");
    	float profit = Float.valueOf(twoDForm.format(price - vendorPrice));
    	return new Car(id,name,price, vendorPrice, profit);
    };

    List<Car> cars = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, exe);

        return cars;
    }
    
    
    
  


}
