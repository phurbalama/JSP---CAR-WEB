package com.zetcode.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.zetcode.service.MonthlyMortgage;

public class montlyMortgage {
	
	 public static float getMonthlyPayment(float annualRate, float terms, float financeAmount)
	    {	if(annualRate == 0 )
	    {
	    	return financeAmount/terms;
	    }
	    	double fv=financeAmount * Math.pow((1 + annualRate/12), terms);
	    	double monthlyPayment = (fv * annualRate/12) / (Math.pow((1 + annualRate/12), terms) -1);
			return (float) monthlyPayment;
	    	
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float annualRate = .0f;float term = 36f;float financeAmount = 61_500f;
		
		System.out.println(getMonthlyPayment(annualRate,term,financeAmount));
		//List<MonthlyMortgage> all = 
//		List<MonthlyMortgage> all = new ArrayList<MonthlyMortgage>();
//		
//			IntStream.range(1, 26)
//					 .forEach(e-> {
//						 all.add(new MonthlyMortgage(1,2,3,e)); 
//					 });
//			
//			all.forEach(System.out::println);
//			System.out.println(5.0/100);
			
	}

}
