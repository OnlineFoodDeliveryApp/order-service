package com.onlineapp.order.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineapp.order.dto.FoodItemsDTO;
import com.onlineapp.order.dto.Restaurant;
import com.onlineapp.order.dto.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("order")
public class Order {

	private Integer orderId;
	private List<FoodItemsDTO> foodItemsList;
	private Restaurant restaurant;
	private UserDTO userDTO;

}
