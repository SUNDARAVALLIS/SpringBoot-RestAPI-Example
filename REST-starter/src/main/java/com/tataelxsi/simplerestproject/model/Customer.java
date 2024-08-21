package com.tataelxsi.simplerestproject.model;

public class Customer {

	
	private Long customerId;
	private String customerName;
	private String productName;
	
	
	public Customer() {
	
	}


	public Customer(Long customerId, String customerName, String productName) {
		
		this.customerId = customerId;
		this.customerName = customerName;
		this.productName = productName;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", productName=" + productName
				+ "]";
	}
	
	
	
	
	
	
}
