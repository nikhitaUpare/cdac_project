package com.tiffin_wala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiffin_wala.dto.CustomerOrderDto;
import com.tiffin_wala.service.CustomerOrderService;

@RestController
@RequestMapping("/order")
public class CustomerOrderController {
	@Autowired
	CustomerOrderService CustomerorderService;
	
	@PostMapping
	public ResponseEntity<?> createOrder(CustomerOrderDto order){
		return new ResponseEntity<>(CustomerorderService.createOrder(order), HttpStatus.CREATED) ;
	}
	
	@GetMapping
	public ResponseEntity<?> getAllOrders(){
		return new ResponseEntity<>(CustomerorderService.getAllCustomerOrders(), HttpStatus.OK) ;
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderById(@PathVariable int orderId){
		return new ResponseEntity<>(CustomerorderService.getCustomerOrderById(orderId),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> deleteOrderById(@PathVariable int orderId){
		return new ResponseEntity<>(CustomerorderService.deleteOrderById(orderId), HttpStatus.OK) ;
	}
	
	@GetMapping("/tiffin/{tiffinId}")
	public ResponseEntity<?> getOrdersByTiffinId(@PathVariable int tiffinId){
		return new ResponseEntity<>(CustomerorderService.getOrdersByTiffinId(tiffinId), HttpStatus.OK) ;
	}
	
	
}
