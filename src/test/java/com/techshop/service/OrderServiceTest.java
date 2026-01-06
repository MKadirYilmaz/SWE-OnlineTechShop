package com.techshop.service;

import com.techshop.model.*;
import com.techshop.repository.CartRepository;
import com.techshop.repository.OrderRepository;
import com.techshop.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private UserService userService;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void testAddToCart_NewItem() {
        // Arrange
        String username = "user";
        Long productId = 1L;
        Integer quantity = 2;

        User user = new User(); user.setId(1L);
        when(userService.findByUsername(username)).thenReturn(user);

        Cart cart = new Cart(); cart.setItems(new ArrayList<>());
        when(cartRepository.findByUserId(1L)).thenReturn(Optional.of(cart));

        Product product = new Product(); product.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        when(cartRepository.save(any(Cart.class))).thenReturn(cart);

        // Act
        Cart result = orderService.addToCart(username, productId, quantity);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getItems().size());
        assertEquals(quantity, result.getItems().get(0).getQuantity());
    }

    @Test
    public void testPlaceOrder_Success() {
        // Arrange
        String username = "user";
        User user = new User(); user.setId(1L);
        
        Product product = new Product(); 
        product.setId(1L); 
        product.setPrice(new BigDecimal("100.00"));
        product.setStockQuantity(10);

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(2);

        Cart cart = new Cart();
        cart.setUser(user);
        cart.getItems().add(cartItem);

        when(userService.findByUsername(username)).thenReturn(user);
        when(cartRepository.findByUserId(1L)).thenReturn(Optional.of(cart));
        
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        Order result = orderService.placeOrder(username);

        // Assert
        assertNotNull(result);
        assertEquals(OrderStatus.CREATED, result.getStatus());
        assertEquals(new BigDecimal("200.00"), result.getTotalAmount());
        assertEquals(1, result.getItems().size());
        

    }
}
