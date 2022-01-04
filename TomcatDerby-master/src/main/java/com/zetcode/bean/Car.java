package com.zetcode.bean;


public class Car {
    
    private Long id;
    private String name;
    private float price;
    private float vendorPrice;
    private float profit;

   

	
    public float getProfit() {
		return profit;
	}

	public void setProfit(float profit) {
		this.profit = profit;
	}

	public Car(Long id, String name, float price, float vendorPrice) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendorPrice = vendorPrice;
		
	}
    
	public Car(Long id, String name, float price, float vendorPrice, float profit) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.vendorPrice = vendorPrice;
		this.profit = profit;
	}
	
	

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + ", vendorPrice=" + vendorPrice + ", profit="
				+ profit + "]";
	}



	public float getVendorPrice() {
		return vendorPrice;
	}

	public void setVendorPrice(float vendorPrice) {
		this.vendorPrice = vendorPrice;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
   
}

