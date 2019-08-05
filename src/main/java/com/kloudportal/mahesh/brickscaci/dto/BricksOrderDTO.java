package com.kloudportal.mahesh.brickscaci.dto;

public class BricksOrderDTO {

	
	private String orderID;
	private String customerName;
	private String customerAddress;
	private int quantity;
	private boolean isDispatched;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isDispatched() {
		return isDispatched;
	}
	public void setDispatched(boolean isDispatched) {
		this.isDispatched = isDispatched;
	}
	
	@Override
	public String toString() {
		return "BricksOrderDTO [orderID=" + orderID + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", quantity=" + quantity + ", isDispatched=" + isDispatched + "]";
	}
	
}

