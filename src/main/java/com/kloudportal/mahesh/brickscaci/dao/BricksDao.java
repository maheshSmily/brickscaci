package com.kloudportal.mahesh.brickscaci.dao;

import java.util.List;

import com.kloudportal.mahesh.brickscaci.dto.BricksOrderDTO;

public interface BricksDao {

	boolean createOrder(BricksOrderDTO bricksOrderDTO);
	
	List<BricksOrderDTO> getAll();
	
	BricksOrderDTO getOrdersById(String orderId);
	
	String updateOrder(BricksOrderDTO bricksOrderDTO);

	boolean isOrderDispatched(String orderId);
	
	String fullfilOrder(String orderId);
}
