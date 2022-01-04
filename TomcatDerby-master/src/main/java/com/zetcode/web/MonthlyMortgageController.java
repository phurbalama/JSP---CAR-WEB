package com.zetcode.web;

import com.zetcode.bean.EPages;
import com.zetcode.service.MonthlyMortgage;
import com.zetcode.util.GLOBAL;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/carLoan")
public class MonthlyMortgageController extends AbstractSecurityController {

	private static final long serialVersionUID = 1L;

	@Override
    protected void securedGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
			String pageCode = request.getParameter(GLOBAL.ACTION);
			EPages epage = EPages.find(pageCode);
			
			String financeAmount = "1000000";
			String interestRate =  "5";
			String scene = "10";
			int scene_val = Integer.parseInt(scene);
			float f_financeAmount = Float.parseFloat(financeAmount);
			float f_interestRate = Float.parseFloat( interestRate)/100;
			float term = 360;
			String money = "./images/money.png";
			String hundred = "./images/100-Bucks.jpg";
			
			
			if(epage == EPages.CAR_LOAN)
			{
				List<MonthlyMortgage> loanLists = new ArrayList<MonthlyMortgage>();
				IntStream.range(1, scene_val + 1)
						 .forEach(e-> {
							 
							 loanLists.add(new MonthlyMortgage(f_interestRate,term,(f_financeAmount + ((e-1)*500)),e));
							 
						 });
				
				float greaterthan50 = loanLists.get(0).getMonthlyPayment()+50;
				float greaterthan100 = loanLists.get(0).getMonthlyPayment()+100;
				
				loanLists.stream()
						 
				         .forEach(e->
				         {
				        	 if(e.getMonthlyPayment()>= greaterthan50)
				        	 {
				        		 e.setImage(money);
				        	 }
				        	 if(e.getMonthlyPayment()>= greaterthan100)
				        	 {
				        		 e.setImage(hundred);
				        	 }
				        	 
				        	 
				         });
				
				request.setAttribute("scene", scene); 
				request.setAttribute("loanList", loanLists);
				request.setAttribute("financeAmount",financeAmount);
				request.setAttribute("interestRate", interestRate);
			}
			
            RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + epage.getPageName());
	        disp.forward(request, response);
	        
           
             

       
    }
	@Override
	protected void securedPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String financeAmount = request.getParameter("financeAmount");
		String interestRate =  request.getParameter("interestRate");
		String scene =  request.getParameter("scene");
		
		int scene_val = Integer.parseInt(scene);
		float f_financeAmount = Float.parseFloat(financeAmount);
		float f_interestRate = Float.parseFloat( interestRate)/100;
		float term = 60;
		String money = "./images/money.png";
		String hundred = "./images/100-Bucks.jpg";
		
	List<MonthlyMortgage> loanLists = new ArrayList<MonthlyMortgage>();

		
		IntStream.range(1, scene_val+1)
				 .forEach(e-> {
					 
					 loanLists.add(new MonthlyMortgage(f_interestRate,term,(f_financeAmount + ((e-1)*500)),e));
					 
				 });

		float greaterthan50 = loanLists.get(0).getMonthlyPayment()+50;
		float greaterthan100 = loanLists.get(0).getMonthlyPayment()+100;
		loanLists.stream()
		         .forEach(e->
					        {
							       	 if(e.getMonthlyPayment()>= greaterthan50)
							       	 {
							       		 e.setImage(money);
							       	 }
							       	 if(e.getMonthlyPayment()>= greaterthan100)
							       	 {
							       		 e.setImage(hundred);
							       	 }
					        });
		request.setAttribute("scene", scene);
		request.setAttribute("loanList", loanLists);
		request.setAttribute("financeAmount",financeAmount);
		request.setAttribute("interestRate", interestRate);
		
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/" + EPages.CAR_LOAN.getPageName());
		disp.forward(request, response);
		
		
	}

   
}

