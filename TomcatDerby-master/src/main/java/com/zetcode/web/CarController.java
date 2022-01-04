package com.zetcode.web;

import com.zetcode.bean.Car;
import com.zetcode.bean.EPages;
import com.zetcode.service.CarsService;
import com.zetcode.util.GLOBAL;

import java.io.IOException;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cars")
public class CarController extends AbstractSecurityController {

	private static final long serialVersionUID = 1L;

	@Override
    protected void securedGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
			String pageCode = request.getParameter(GLOBAL.ACTION);
			EPages epage = EPages.find(pageCode);
			
			if(epage == EPages.CAR_LIST)
			{
            CarsService service = new CarsService();
            List<Car> list = service.findAll();
            
            
            DoubleSummaryStatistics summary = service.getSummary(list,Car::getProfit);
            
            request.setAttribute("carList", list);
            request.setAttribute("average", "$"+String.format("%.02f",summary.getAverage()));
            request.setAttribute("total", "$"+String.format("%.02f",summary.getSum()));
			}
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + epage.getPageName());
	        disp.forward(request, response);
           
             

       
    }

   
}

