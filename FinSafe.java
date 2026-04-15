package transactionProcessor;
import java.util.Scanner;
public class FinSafe {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
    	Account acc = new Account("Abinaya", 0);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nBANKING PROGRAM");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Mini Statement");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                    	System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        acc.deposit(dep);
                        System.out.println("Deposit successful");
                        break;

                    case 2:
                    	System.out.print("Enter withdraw amount: ");
                        double wd = sc.nextDouble();
                        acc.processTransaction(wd);
                        System.out.println("Withdrawal successful");
                        break;

                    case 3:
                    	acc.printMiniStmt();
                        break;

                    case 4:
                    	isRunning = false;
                        break;

                   /* case 5:
                    
                        System.out.printf("Balance: Rs.%.2f\n", acc.getBalance());
                        break;*/
                    
                        
                    default:
                        System.out.println("Invalid");
                }

            } catch (InSuffFundsException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Thank you!");
        sc.close();
    }
}
