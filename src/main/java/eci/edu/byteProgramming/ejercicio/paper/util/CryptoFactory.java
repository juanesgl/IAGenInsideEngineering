package eci.edu.byteProgramming.ejercicio.paper.util;

public class CryptoFactory implements PaymentFactory {
    private String walletAddress;
    private String cryptoType;
    private String token;
    private double walletBalance;
    private double requiredAmount;
    
    public CryptoFactory(String walletAddress, String cryptoType, double walletBalance, double requiredAmount) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
        this.walletBalance = walletBalance;
        this.requiredAmount = requiredAmount;
    }

    @Override
    public PaymentMethod createPaymentMethod(double amount, String customerId, String description) {
        return new CryptoPayment(amount, customerId, description, walletAddress, cryptoType);
    }

    @Override
    public ValidatePayment createValidator() {
        return new CryptoValidator(walletAddress, walletBalance, requiredAmount);
    }
}
