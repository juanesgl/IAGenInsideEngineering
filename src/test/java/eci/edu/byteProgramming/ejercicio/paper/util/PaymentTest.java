package eci.edu.byteProgramming.ejercicio.paper.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    void testCreditCardPaymentSuccess() {
        PaymentFactory factory = new CreditCardFactory("1234567890123", "Juan Perez", "12/25", "123", "Calle Falsa 123");
        ECIPayment eciPayment = new ECIPayment();
        
        Inventory inventory = new Inventory();
        Facturation facturation = new Facturation();
        Notification notification = new Notification();
        
        PaymentEventObserver observer = new PaymentEventObserver(inventory, facturation, notification);
        eciPayment.addObserver(observer);
        
        boolean success = eciPayment.processPayment(factory, 100.0, "CUST01", "Test Product", "Juan Perez", "juan@example.com", "PROD01");
        
        assertTrue(success, "Payment should be successful");
    }

    @Test
    void testCreditCardValidationFailure() {
        // Invalid CVV to force validation failure
        PaymentFactory factory = new CreditCardFactory("1234567890123", "Juan Perez", "12/25", "12", "Calle Falsa 123");
        ECIPayment eciPayment = new ECIPayment();
        
        boolean success = eciPayment.processPayment(factory, 100.0, "CUST01", "Test Product", "Juan Perez", "juan@example.com", "PROD01");
        
        assertFalse(success, "Payment should fail validation due to invalid CVV");
    }
}
