package com.zetcode.persistence;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.utility.ESQL;
import com.jbbwebsolutions.utility.SQLExecutable;
import com.jbbwebsolutions.utility.SQLUtility;
import com.zetcode.bean.Group;
import java.util.List;

import static com.zetcode.util.GLOBAL.DATA_SOURCE;

public class GroupDAO implements IQuery<Group>{


	@Override
    public List<Group> findAll() {

    	String sql = " SELECT GROUPID, Name, CITYID, PURCHASEMONTH, MONTHNUMBER" 
    			+", SUM(PRICEPAID) AS pricePaid, SUM(VENDORPRICE) AS vendorPrice"
    			+", SUM(INCOME) AS income FROM APP.VW_TRANSACTIONS" 
    			+" WHERE QUARTER = 4 GROUP BY GROUPID, Name, CITYID" 
    			+", PURCHASEMONTH, MONTHNUMBER";
    		

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

    List<Group> groups = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, exe);

        return groups;
    }
	@Override
    public List<Group> findBy(Group model) {

    	String sql = " SELECT GROUPID, Name, CITYID, PURCHASEMONTH, MONTHNUMBER" 
    			+", SUM(PRICEPAID) AS pricePaid, SUM(VENDORPRICE) AS vendorPrice"
    			+", SUM(INCOME) AS income FROM APP.VW_TRANSACTIONS" 
    			+" WHERE QUARTER = 4 AND GROUPID = ? GROUP BY GROUPID, Name, CITYID" 
    			+", PURCHASEMONTH, MONTHNUMBER";
    		

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

    List<Group> groups = SQLUtility.execute(sql, DATA_SOURCE, ESQL.DATASOURCE, exe,model.getGroupId());

        return groups;
    }
	
    


}
