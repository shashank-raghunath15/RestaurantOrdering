package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Order;
import edu.buffalo.cse.ood.restaurantOrdering.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl implements OrderService {

	@Override
	public List<Order> getAllOrders() {
		return getOrderRepository().findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		return getOrderRepository().getOne(id);
	}

	@Override
	public Order addOrder(Order order) {
		return getOrderRepository().save(order);
	}

	@Override
	public void updateOrder(Order order) {
		getOrderRepository().save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		getOrderRepository().delete(id);
	}
}
