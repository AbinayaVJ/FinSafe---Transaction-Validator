package transactionProcessor;
import java.util.ArrayList;


class Account {
    private String accountHolder;
    private double balance;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    /*to view balance 
    public double getBalance() {
        return balance;
    }*/

    // Core validation logic
    public void processTransaction(double amount) throws InSufficientFundsException {
        if (amount == 0) return;

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        if (amount > balance) {
            throw new InSufficientFundsException("Insufficient balance!");
        }

        balance -= amount;
        addTransaction(-amount); // withdrawal stored as negative
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        balance += amount;
        addTransaction(amount);
    }

    private void addTransaction(double amount) {
        if (transactions.size() == 5) {
            transactions.remove(0); // keep only last 5
        }
        transactions.add(amount);
    }

    public void printMiniStatement() {
        
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        System.out.println("Last 5 Transactions:");
        for (double t : transactions) {
        	
            if (t > 0)
                System.out.println("Deposited: Rs." + t);
            else
                System.out.println("Withdrawn: Rs." + Math.abs(t));
        }
    }
}