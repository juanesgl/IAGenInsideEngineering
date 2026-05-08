package eci.edu.byteProgramming.ejercicio.paper.util;

public class CryptoValidator implements ValidatePayment {
    private String walletAddress;
    private double walletBalance;
    private double requiredAmount;

    public CryptoValidator(String walletAddress, double walletBalance, double requiredAmount) {
        this.walletAddress = walletAddress;
        this.walletBalance = walletBalance;
        this.requiredAmount = requiredAmount;
    }

    @Override
    public boolean validatePaymentMethod() {
        return validateWalletAddress() && validateBalance();
    }
    
    private boolean validateWalletAddress() {
        return walletAddress != null && walletAddress.length() >= 26;
    }
    
    private boolean validateBalance() {
        return walletBalance >= requiredAmount;
    }
}
