package eci.edu.byteProgramming.ejercicio.paper.util;

public class CreditCardPayment extends PaymentMethod {
    private String number;
    private String name;
    private String expirationDate;
    private String cvv;
    private String cardType;
    private String address;
    
    public CreditCardPayment(double amount, String customerID, String description,
                     String number, String name, String expirationDate, String cvv, String address) {
        super(amount, customerID, description);
        this.number = number;
        this.name = name;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.address = address;
        this.cardType = determineCardType(number);
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing Credit Card payment...");
        
        setStatus(PaymentStatus.PROCESSING);
        
        // Simulación del procesamiento
        try {
            Thread.sleep(2000);
            System.out.println("Contacting bank for card: " + maskCardNumber());
            System.out.println("Payment authorized by bank");
            
            setStatus(PaymentStatus.COMPLETED);
            return true;
        } catch (Exception e) {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "CREDIT_CARD";
    }
    
    private String determineCardType(String cardNumber) {
        if (cardNumber.startsWith("4")) return "VISA";
        if (cardNumber.startsWith("5")) return "MASTERCARD";
        if (cardNumber.startsWith("3")) return "AMEX";
        return "UNKNOWN";
    }
    
    public String maskCardNumber() {
        return "**** **** **** " + number.substring(number.length() - 4);
    }
    
    public String getCardHolderName() { return name; }
    public String getCardType() { return cardType; }
}
