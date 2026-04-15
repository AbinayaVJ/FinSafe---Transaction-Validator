package transactionProcessor;
import java.util.ArrayList;

class Account {
    private String accHolder;
    private double balance;
    private ArrayList<Double> transactions = new ArrayList<>();

    public Account(String accHolder, double balance) {
        this.accHolder = accHolder;
        this.balance = balance;
    }

    /*to view balance 
    public double getBalance() {
        return balance;
    }*/

    
    public void processTransaction(double amt) throws InSuffFundsException {
        if (amt == 0) return;
        if (amt < 0) {
            throw new IllegalArgumentException("Amount cant be negative");
        }if (amt > balance) {
            throw new InSuffFundsException("Insufficient balance!");
        }
        balance -= amt;
        addTransaction(-amt); 
    }

    public void deposit(double rupees) {
        if (rupees < 0) {
            throw new IllegalArgumentException("Amount cant be negative");
        }
        balance += rupees;
        addTransaction(rupees);
    }

    private void addTransaction(double amount) {
        if (transactions.size() == 5) {
            transactions.remove(0); 
        }
        transactions.add(amount);
    }

    public void printMiniStmt() {
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
