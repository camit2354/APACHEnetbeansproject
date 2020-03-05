package com.eshop.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private Map<Items,Integer> currentOrder = new HashMap<Items,Integer>();
	private String status = "order accepted";
	
	public void addToOrder(Items item, int quantity) {
		int currentQuantity = 0;
		if (currentOrder.get(item) != null) currentQuantity = currentOrder.get(item);
		currentOrder.put(item, currentQuantity + quantity);
	}
	
	public Double getOrderTotal() {
		double d = 0d;
		for (Items item : currentOrder.keySet()) {
			d += currentOrder.get(item) * item.getPrice();
		}
		return d;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
		System.out.println("status set to " + status);
	}
	
	//added ch14
	public String toString() {
		StringBuilder sb = new StringBuilder();
			for (Items item : currentOrder.keySet()) {
				sb.append(item.getName() + " : " + currentOrder.get(item) + "<br/>");
			}
		return sb.toString();
	}
}
