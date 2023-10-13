package com.onlineapp.order.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private Integer orderId;
	private List<FoodItemsDTO> foodItemsList;
	private Integer userId;
	private Restaurant restaurant;

}
