package eci.edu.byteProgramming.ejercicio.paper.util;

public class CryptoPayment extends PaymentMethod {
    private String walletAddress;
    private String cryptoType;
    private String blockchainHash;
    
    public CryptoPayment(double amount, String customerId, String description,
                 String walletAddress, String cryptoType) {
        super(amount, customerId, description);
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public boolean processPayment() {
        System.out.println("Processing Cryptocurrency payment...");
        
        setStatus(PaymentStatus.PROCESSING);
        
        try {
            Thread.sleep(3000);
            this.blockchainHash = generateBlockchainHash();
            System.out.println("Transaction broadcasted to blockchain");
            System.out.println("Blockchain hash: " + blockchainHash);
            
            setStatus(PaymentStatus.COMPLETED);
            return true;
        } catch (Exception e) {
            setStatus(PaymentStatus.FAILED);
            return false;
        }
    }
    
    @Override
    public String getPaymentMethod() {
        return "CRYPTOCURRENCY";
    }
    
    private String generateBlockchainHash() {
        return "0x" + Integer.toHexString((int)(Math.random() * Integer.MAX_VALUE));
    }
    
    public String getWalletAddress() { return walletAddress; }
    public String getCryptoType() { return cryptoType; }
    public String getBlockchainHash() { return blockchainHash; }
}
