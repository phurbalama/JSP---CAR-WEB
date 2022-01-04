package com.zetcode.web;

import com.zetcode.bean.Group;
import com.zetcode.service.GroupService;
import com.zetcode.util.GLOBAL;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/group")
public class GroupController extends AbstractSecurityController {

	private static final long serialVersionUID = 1L;

	@Override
    protected void securedGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
			String pageCode = request.getParameter(GLOBAL.ACTION);
			
                    Group group = new Group();
                    group.setGroupId(pageCode);
                    GroupService service = new GroupService();
                    List<Group> list = service.findBy(group);
                    
            DoubleSummaryStatistics summary = service.getSummary(list,Group::getIncome);
            request.setAttribute("groupID", pageCode);
            request.setAttribute("GroupList", list);
            request.setAttribute("average", "$"+String.format("%.02f",summary.getAverage()));
            request.setAttribute("total", "$"+String.format("%.02f",summary.getSum()));
			
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/WEB-INF/group.jsp");
	        disp.forward(request, response);
           
             

       
    }

   
}

