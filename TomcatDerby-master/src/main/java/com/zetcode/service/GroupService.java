package com.zetcode.service;

import com.jbbwebsolutions.dao.IQuery;
import com.jbbwebsolutions.service.IService;
import com.jbbwebsolutions.service.IStatisticsService;
import com.zetcode.bean.Group;
import com.zetcode.persistence.GroupDAO;
import java.util.List;

public class GroupService implements IService<Group>, IStatisticsService<Group> {

    @Override
    public List<Group> findAll() {

        IQuery<Group> GroupDAO = new GroupDAO();
        return GroupDAO.findAll();
    }
    @Override
    public List<Group> findBy(Group model) {
    	IQuery<Group> GroupDAO = new GroupDAO();
    	
		return GroupDAO.findBy(model);
	}

    @Override
    public Group findOne(Group group) {

        IQuery<Group> GroupDAO = new GroupDAO();
        
        return GroupDAO.findOne(group);
    }



	
}
