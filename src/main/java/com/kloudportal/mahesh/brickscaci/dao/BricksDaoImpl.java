package com.kloudportal.mahesh.brickscaci.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kloudportal.mahesh.brickscaci.dto.BricksOrderDTO;

@Repository("bricksDao")
public class BricksDaoImpl  implements BricksDao{

	private static HashMap<String, BricksOrderDTO> ordersRepo = new HashMap<>();

	@Override
	public boolean createOrder(BricksOrderDTO bricksOrderDTO) {
		ordersRepo.put(bricksOrderDTO.getOrderID(), bricksOrderDTO);
		return true;
	}

	@Override
	public List<BricksOrderDTO> getAll() {
		return new ArrayList<>(ordersRepo.values());
	}

	@Override
	public BricksOrderDTO getOrdersById(String orderId) {
		return ordersRepo.get(orderId);
	}

	@Override
	public String updateOrder(BricksOrderDTO bricksOrderDTO) {

		if(ordersRepo.containsKey(bricksOrderDTO.getOrderID())) {

			BricksOrderDTO bricksOrderDTO1 = ordersRepo.get(bricksOrderDTO.getOrderID());
			bricksOrderDTO1.setQuantity(bricksOrderDTO.getQuantity());

			ordersRepo.put(bricksOrderDTO.getOrderID(), bricksOrderDTO1);
			return bricksOrderDTO.getOrderID();
		}
		return null;
	}

	@Override
	public boolean isOrderDispatched(String orderId) {
		BricksOrderDTO bricksOrderDTO = ordersRepo.get(orderId);
		if(bricksOrderDTO!=null && bricksOrderDTO.isDispatched())
			return true;
		return false;
	}

	@Override
	public String fullfilOrder(String orderId) {
		if(ordersRepo.containsKey(orderId)) {

			BricksOrderDTO bricksOrderDTO = ordersRepo.get(orderId);
			bricksOrderDTO.setDispatched(true);

			ordersRepo.put(orderId, bricksOrderDTO);
			return orderId;
		}
		return null;
	}


}
