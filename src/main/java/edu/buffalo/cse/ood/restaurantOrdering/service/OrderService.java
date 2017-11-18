package edu.buffalo.cse.ood.restaurantOrdering.service;

import java.util.List;

import edu.buffalo.cse.ood.restaurantOrdering.model.Order;

public interface OrderService {
	public void addOrder(Order Order);

	public Order getOrder(Order Order);

	public List<Order> getAllOrders();

	public void updateOrder(Order Order);

	public void deleteOrder(Order Order);

}
