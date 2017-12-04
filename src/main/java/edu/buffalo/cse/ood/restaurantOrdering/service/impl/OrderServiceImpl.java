package edu.buffalo.cse.ood.restaurantOrdering.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.buffalo.cse.ood.restaurantOrdering.model.Item;
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
		return getOrderRepository().findOne(id);
	}

	@Override
	public Order addOrder(Order order) {
		order.setCustomer(getCustomerRepository().findOne(order.getCustomer().getId()));
		if (order.getDeal() != null) {
			order.setDeal(getDealRepository().findOne(order.getDeal().getId()));
		}
		order.setRestaurant(getRestaurantRepository().findOne(order.getRestaurant().getId()));
		List<Item> items = new ArrayList<>();
		for (Item item : order.getItems()) {
			items.add(getItemRepository().findOne(item.getId()));
		}
		order.setItems(items);
		return getOrderRepository().saveAndFlush(order);
	}

	@Override
	public void updateOrder(Order order) {
		getOrderRepository().save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		getOrderRepository().delete(id);
	}

	@Override
	public Order reOrder(Order order) {
		order = getOrderRepository().findOne(order.getId());
		Order order2 = getApplicationContext().getBean(Order.class);
		order2.setCustomer(getCustomerRepository().findOne(order.getCustomer().getId()));
		List<Item> items = new ArrayList<>();
		for (Item item : order.getItems()) {
			items.add(getItemRepository().findOne(item.getId()));
		}
		order2.setItems(items);
		order2.setTotalPrice(order.getTotalPrice());
		order2.setDeal(getDealRepository().findOne(order.getDeal().getId()));
		order2.setRestaurant(getRestaurantRepository().findOne(order.getRestaurant().getId()));
		return getOrderRepository().saveAndFlush(order2);
	}
}
