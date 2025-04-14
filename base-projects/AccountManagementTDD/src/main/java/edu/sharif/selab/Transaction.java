package edu.sharif.selab;

public class Transaction {

    private final TransactionType type;
    private final int amount;

    public Transaction(TransactionType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public TransactionType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
