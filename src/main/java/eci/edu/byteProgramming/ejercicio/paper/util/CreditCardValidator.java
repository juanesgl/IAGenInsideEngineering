package eci.edu.byteProgramming.ejercicio.paper.util;

public class CreditCardValidator implements ValidatePayment {
    private String number;
    private String cvv;
    private String expirationDate;

    public CreditCardValidator(String number, String cvv, String expirationDate) {
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean validatePaymentMethod() {
        return validateCardNumber() && validateCVV() && validateExpirationDate();
    }
    
    private boolean validateCardNumber() {
        return number != null && number.length() >= 13 && number.length() <= 19;
    }
    
    private boolean validateCVV() {
        return cvv != null && cvv.length() >= 3 && cvv.length() <= 4;
    }
    
    private boolean validateExpirationDate() {
        // Formato MM/YY
        return expirationDate != null && expirationDate.matches("\\d{2}/\\d{2}");
    }
}
