package eci.edu.byteProgramming.ejercicio.paper.util;

public class PaypalValidator implements ValidatePayment {
    private String email;
    private String authToken;

    public PaypalValidator(String email, String authToken) {
        this.email = email;
        this.authToken = authToken;
    }

    @Override
    public boolean validatePaymentMethod() {
        return validateEmail() && validateAuthToken();
    }
    
    private boolean validateEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    private boolean validateAuthToken() {
        return authToken != null && authToken.length() > 10;
    }
}
