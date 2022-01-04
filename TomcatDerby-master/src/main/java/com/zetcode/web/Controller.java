package com.zetcode.web;

import com.zetcode.bean.Car;
import com.zetcode.service.CarsService;
import com.zetcode.util.ValidateParameter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends AbstractSecurityController {

    private static final String ACTION_KEY = "action";
    private static final String All_CITIES_VIEW = "/WEB-INF/allCities.jsp";
    
    private static final String UNKNOWN_VIEW = "/WEB-INF/unknown.jsp";

    private static final String All_CITIES_ACTION = "allCities";

    @Override
    protected void securedGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String actionName = request.getParameter(ACTION_KEY);
        String page = UNKNOWN_VIEW;

        
        
            

        
        if (All_CITIES_ACTION.equals(actionName)) {
            page = All_CITIES_VIEW;
        }      

        RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + page);
        disp.forward(request, response);
    }

    @Override
    protected void securedPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");

        String page = UNKNOWN_VIEW;        
        
          
        
        response.sendRedirect(page);
    }
}

