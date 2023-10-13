package com.onlineapp.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onlineapp.order.dto.OrderDTO;
import com.onlineapp.order.dto.OrderDTOFromFE;
import com.onlineapp.order.dto.UserDTO;
import com.onlineapp.order.entity.Order;
import com.onlineapp.order.mapper.OrderMapper;
import com.onlineapp.order.repo.OrderRepo;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	SequenceGenerator sequenceGenerator;
	
	@Autowired
	RestTemplate restTemplate;
	
	public OrderDTO saveOrderInDb(OrderDTOFromFE orderDetails) {
		Integer newOrderID = sequenceGenerator.generateNextOrderId();
		UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
		Order orderToBeSaved = new Order(newOrderID, orderDetails.getFoodItemsList(), orderDetails.getRestaurant(),
				userDTO);
		orderRepo.save(orderToBeSaved);
		return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
	}
	
	private UserDTO fetchUserDetailsFromUserId(Integer userId) {
		return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
	}

}
