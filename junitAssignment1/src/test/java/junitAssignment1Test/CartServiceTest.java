package junitAssignment1Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junitAssignment1.CartService;

public class CartServiceTest {

    private CartService service;

    @BeforeEach
    void setup() {
        service = new CartService();
    }

    // ✅ Test Case 1 — Total Price
    @Test
    void testCalculateTotalPrice() {

        double total =
                service.calculateTotal(1000, 1500, 2000);

        assertEquals(4500, total);
    }

    // ✅ Test Case 2 — Discount Applied
    @Test
    void testDiscountApplied() {

        double total =
                service.calculateTotal(2000, 2000, 1000);
        // Total = 5000

        double discount =
                service.calculateDiscount(total);

        assertEquals(500, discount);
    }

    // ✅ Test Case 3 — No Discount
    @Test
    void testNoDiscount() {

        double total =
                service.calculateTotal(1000, 1000, 1000);
        // Total = 3000

        double discount =
                service.calculateDiscount(total);

        assertEquals(0, discount);
    }

    // ✅ Test Case 4 — Final Payable Amount
    @Test
    void testFinalPayableAmount() {

        double total =
                service.calculateTotal(2000, 2000, 1000);
        // 5000

        double discount =
                service.calculateDiscount(total);
        // 500

        double finalAmount =
                service.calculateFinalAmount(total, discount);

        assertEquals(4500, finalAmount);
    }
}