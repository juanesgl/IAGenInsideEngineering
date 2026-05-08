package eci.edu.byteProgramming.ejercicio.paper.util;

public class PaypalFactory implements PaymentFactory {
    private String email;
    private String authToken;
    
    public PaypalFactory(String email, String authToken) {
        this.email = email;
        this.authToken = authToken;
    }

    @Override
    public PaymentMethod createPaymentMethod(double amount, String customerId, String description) {
        return new PaypalPayment(amount, customerId, description, email, authToken);
    }

    @Override
    public ValidatePayment createValidator() {
        return new PaypalValidator(email, authToken);
    }
}
