import java.util.Date;
import java.util.Map;

public class PaymentProcessor {
    private Map<String, String> config;

    public PaymentProcessor(Map<String, String> config) {
        this.config = config;
    }

    public Map<String, String> processPayment(String paymentType, double amount, String currency,
                                              Map<String, String> customerInfo, Map<String, String> paymentDetails) {
        if (!validatePayment(paymentType, amount, currency, customerInfo, paymentDetails)) {
            return Map.of("status", "failed", "message", "Validation error");
        }

        Map<String, String> result;
        switch (paymentType) {
            case "credit_card":
                result = processCreditCard(amount, currency, customerInfo, paymentDetails);
                break;
            case "digital_wallet":
                result = processDigitalWallet(amount, currency, customerInfo, paymentDetails);
                break;
            case "bank_transfer":
                result = processBankTransfer(amount, currency, customerInfo, paymentDetails);
                break;
            default:
                return Map.of("status", "failed", "message", "Unknown payment type");
        }

        logTransaction(paymentType, amount, currency, customerInfo, paymentDetails, result);
        return result;
    }

    private boolean validatePayment(String paymentType, double amount, String currency,
                                    Map<String, String> customerInfo, Map<String, String> paymentDetails) {
        if (amount <= 0) {
            return false;
        }
        if (!currency.equals("USD") && !currency.equals("EUR") && !currency.equals("GBP")) {
            return false;
        }
        if (!customerInfo.containsKey("email")) {
            return false;
        }

        switch (paymentType) {
            case "credit_card":
                if (paymentDetails.getOrDefault("card_number", "").length() < 12) {
                    return false;
                }
                break;
            case "digital_wallet":
                if (!paymentDetails.containsKey("wallet_id")) {
                    return false;
                }
                break;
            case "bank_transfer":
                if (!paymentDetails.containsKey("account_number")) {
                    return false;
                }
                break;
        }

        return true;
    }

    private Map<String, String> processCreditCard(double amount, String currency,
                                                  Map<String, String> customerInfo, Map<String, String> paymentDetails) {
        System.out.println("Connecting to Credit Card API at " + config.get("credit_card_endpoint"));
        String transactionId = "CC" + new Date().getTime();
        System.out.println("Processing credit card payment for " + customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", transactionId);
    }

    private Map<String, String> processDigitalWallet(double amount, String currency,
                                                     Map<String, String> customerInfo, Map<String, String> paymentDetails) {
        System.out.println("Connecting to Digital Wallet API at " + config.get("digital_wallet_endpoint"));
        String transactionId = "DW" + new Date().getTime();
        System.out.println("Processing digital wallet payment for " + customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", transactionId);
    }

    private Map<String, String> processBankTransfer(double amount, String currency,
                                                    Map<String, String> customerInfo, Map<String, String> paymentDetails) {
        System.out.println("Connecting to Bank Transfer API at " + config.get("bank_transfer_endpoint"));
        String transactionId = "BT" + new Date().getTime();
        System.out.println("Processing bank transfer payment for " + customerInfo.get("name"));
        return Map.of("status", "success", "transaction_id", transactionId);
    }

    private void logTransaction(String paymentType, double amount, String currency,
                                Map<String, String> customerInfo, Map<String, String> paymentDetails,
                                Map<String, String> result) {
        String logEntry = String.format("%s - %s payment of %.2f %s for %s: %s",
                new Date(), paymentType, amount, currency, customerInfo.get("name"), result);
        System.out.println("LOG: " + logEntry);
    }

    public static void main(String[] args) {
        Map<String, String> config = Map.of(
                "credit_card_endpoint", "https://api.creditcard.com/process",
                "digital_wallet_endpoint", "https://api.digitalwallet.com/process",
                "bank_transfer_endpoint", "https://api.banktransfer.com/process"
        );

        PaymentProcessor processor = new PaymentProcessor(config);
        Map<String, String> customer = Map.of("name", "John Doe", "email", "john@example.com");
        Map<String, String> paymentDetails = Map.of("card_number", "123456789012", "expiry", "12/25", "cvv", "123");

        Map<String, String> result = processor.processPayment("credit_card", 100, "USD", customer, paymentDetails);
        System.out.println("Final Result: " + result);
    }
}
