package eci.edu.byteProgramming.ejercicio.paper.util;

public class PaypalPayment extends PaymentMethod {
    private String email;
    private String paypalTransactionId;
    private String authToken;
    
    public PaypalPayment(double amount, String customerId, String description,
                 String email, String authToken) {
        super(amount, customerId, description);
        this.email = email;
        this.authToken = authToken;
    }
    
    @Override
    public boolean processPayment() {
        System.out.println("Processing PayPal payment...");
        
        setStatus(PaymentStatus.PROCESSING);
        
        try {
            Thread.sleep(1500);
            this.paypalTransactionId = "PP" + System.currentTimeMillis();
            System.out.println("PayPal payment authorized for: " + email);
            
            setStatus(PaymentStatus.COMPLETED);
            return true;
        } catch (Exception e) {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "PAYPAL";
    }
    
    public String getEmail() { return email; }
    public String getPaypalTransactionId() { return paypalTransactionId; }
}
