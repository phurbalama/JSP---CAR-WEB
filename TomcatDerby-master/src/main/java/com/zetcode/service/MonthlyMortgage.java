package com.zetcode.service;

public class MonthlyMortgage {
	int scene;
	float annualRate;
	float term;
	float financeAmount;
	String image = "./images/placeholder.png";
	
	public MonthlyMortgage(float annualRate, float term, float financeAmount, int scene) {
		super();
		this.annualRate = annualRate;
		this.term = term;
		this.financeAmount = financeAmount;
		this.scene = scene;
		
	}
	public float getAnnualRate() {
		return annualRate;
	}
	public void setAnnualRate(float annualRate) {
		this.annualRate = annualRate;
	}
	public int getScene() {
		return scene;
	}
	public void setScene(int scene) {
		this.scene = scene;
	}
	public float getTerm() {
		return term;
	}
	public void setTerm(float term) {
		this.term = term;
	}
	public float getFinanceAmount() {
		return financeAmount;
	}
	public void setFinanceAmount(float financeAmount) {
		this.financeAmount = financeAmount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public float getMonthlyPayment(float annualRate, float terms, float financeAmount)
    {	
			if(annualRate == 0 )
	    {
	    	return financeAmount/terms;
	    }
		
    	double fv=financeAmount * Math.pow((1 + annualRate/12), terms);
    	double monthlyPayment = (fv * annualRate/12) / (Math.pow((1 + annualRate/12), terms) -1);
    	
		return (float) monthlyPayment;
    	
    }
	
	public String getMonthlyPaymentTwoDecimalpt()
    {
		
		if(this.annualRate == 0 )
	    {
	    	float val =  this.financeAmount/this.term;
	    	return String.format("%.02f",val);
	    }
    	double fv=this.financeAmount * Math.pow((1 + this.annualRate/12), this.term);
    	double monthlyPayment = (fv * this.annualRate/12) / (Math.pow((1 + this.annualRate/12), this.term) -1);
    	
    	
		return String.format("%.02f",monthlyPayment);
    	
    }
	public float getMonthlyPayment()
    {
		
		if(this.annualRate == 0 )
	    {
	    	return  this.financeAmount/this.term;
	    }
    	double fv=this.financeAmount * Math.pow((1 + this.annualRate/12), this.term);
    	double monthlyPayment = (fv * this.annualRate/12) / (Math.pow((1 + this.annualRate/12), this.term) -1);
		return (float)monthlyPayment;
    	
    }
	@Override
	public String toString() {
		return "MonthlyMortgage [scene=" + scene + ", annualRate=" + annualRate + ", term=" + term + ", financeAmount="
				+ financeAmount + "]";
	}
	
}
