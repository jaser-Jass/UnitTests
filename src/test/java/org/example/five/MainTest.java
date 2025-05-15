package org.example.five;

import org.example.five.order.OrderService;
import org.example.five.order.PaymentService;
import org.example.five.user.UserRepository;
import org.example.five.user.UserService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
    // 5.2.
    @Test
    public void testGetUserName() {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        String result = userService.getUserName(1);
        assertEquals("User 1", result);
    }
    // 5.3.
    @Test
    public void testPlaceorder() {
        PaymentService paymentService = new PaymentService();
        OrderService orderService = new OrderService(paymentService);

        boolean result = orderService.placeOrder("order1", 100);
        assertTrue(result);
    }
}
