package com.techshop.controller;

import com.techshop.model.Cart;
import com.techshop.model.Order;
import com.techshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/cart/add")
    public ResponseEntity<Cart> addToCart(@RequestParam Long productId, @RequestParam Integer quantity, @RequestParam String username) {
        return ResponseEntity.ok(orderService.addToCart(username, productId, quantity));
    }

    @DeleteMapping("/cart/remove")
    public ResponseEntity<Cart> removeFromCart(@RequestParam Long productId, @RequestParam String username) {
        return ResponseEntity.ok(orderService.removeFromCart(username, productId));
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> getCart(@RequestParam String username) {
        return ResponseEntity.ok(orderService.getCart(username));
    }

    @PostMapping("/checkout")
    public ResponseEntity<Order> checkout(@RequestParam String username) {
        return ResponseEntity.ok(orderService.placeOrder(username));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(@RequestParam String username) {
        return ResponseEntity.ok(orderService.getUserOrders(username));
    }
}
