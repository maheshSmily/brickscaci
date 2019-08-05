package com.kloudportal.mahesh.brickscaci.rest;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kloudportal.mahesh.brickscaci.dao.BricksDao;
import com.kloudportal.mahesh.brickscaci.dto.BricksOrderDTO;

@RestController
public class BricksOrderController {

	@Autowired
	BricksDao bricksDao;

	Logger logger = LoggerFactory.getLogger(BricksOrderController.class);

	//Stage 1
	@PostMapping("/createOrder")
	public ResponseEntity<String> createOrder(@RequestBody BricksOrderDTO bricksOrderDTO){
		bricksOrderDTO.setOrderID("BO"+(new Date()).getTime());
		bricksOrderDTO.setDispatched(false);
		bricksDao.createOrder(bricksOrderDTO);

		return  new ResponseEntity<>("Order created successfully with order ID "+bricksOrderDTO.getOrderID(), HttpStatus.CREATED);

	}
	//Stage 1
	@GetMapping("/getOrders")
	public ResponseEntity<List<BricksOrderDTO> > getAllOrders(){
		List<BricksOrderDTO>  details = bricksDao.getAll();
		if(details!=null && !details.isEmpty()) 
			return  new ResponseEntity<>(details, HttpStatus.OK);
		else
			return new ResponseEntity<>(details, HttpStatus.NO_CONTENT);

	}

	//Stage 1
	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<BricksOrderDTO> getOrder(@PathVariable("orderId") String orderId){
		BricksOrderDTO  details = bricksDao.getOrdersById(orderId);
		if(details!=null) {
			return  new ResponseEntity<>(details, HttpStatus.OK);
		}else {
			return  new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
		}

	}

	//Stage 2
	@PutMapping("/updateOrder")
	public ResponseEntity<String> updatetOrder(@RequestBody BricksOrderDTO bricksOrderDTO){
		//Stage 4 condition
		if(!bricksDao.isOrderDispatched(bricksOrderDTO.getOrderID())) {


			String  orderId = bricksDao.updateOrder(bricksOrderDTO);
			if(orderId!=null) {
				return  new ResponseEntity<>(orderId, HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
			}
		}else{
			return  new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
		}

	}
	//Stage 3
	@PutMapping("/fulfillOrder/{orderId}")
	public ResponseEntity<String> fulfillOrder(@PathVariable("orderId") String orderId){
		
		//Stage 4 condition
		if(!bricksDao.isOrderDispatched(orderId)) {

			orderId = bricksDao.fullfilOrder(orderId);
			if(orderId!=null) {
				return  new ResponseEntity<>(orderId+" order dispatched successfully", HttpStatus.OK);
			}else {
				return  new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
			}
		
		}else{
			return  new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
		}

	}

}
