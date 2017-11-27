package edu.buffalo.cse.ood.restaurantOrdering.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.buffalo.cse.ood.restaurantOrdering.model.Order;

@RestController
@RequestMapping("/order")
public class OrderController extends Controller {

	@GetMapping("/")
	public List<Order> getAllOrders() {
		return getOrderService().getAllOrders();
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {
		return getOrderService().getOrderById(id);
	}

	@PostMapping("/")
	public Order addOrder(@RequestBody Order order) {
		return getOrderService().addOrder(order);
	}

	@PutMapping("/")
	public void updateOrder(@RequestBody Order order) {
		getOrderService().updateOrder(order);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id) {
		getOrderService().deleteOrder(id);
	}
}
