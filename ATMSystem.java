import java.util.*;

class ATM {
    private double balance = 10000; // initial balance
    private List<String> transactionHistory = new ArrayList<>();

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("✅ Amount deposited successfully!");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("✅ Please collect your cash!");
        }
    }

    public void transfer(double amount, String receiver) {
        if (amount > balance) {
            System.out.println("❌ Insufficient Balance!");
        } else {
            balance -= amount;
            transactionHistory.add("Transferred ₹" + amount + " to " + receiver);
            System.out.println("✅ Transfer successful!");
        }
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("\n📜 Transaction History:");
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

class User {
    private String userId = "user123";
    private String pin = "1234";

    public boolean login(String uid, String upin) {
        return userId.equals(uid) && pin.equals(upin);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        ATM atm = new ATM();

        System.out.println("🏦 Welcome to ATM");

        // Login
        System.out.print("Enter User ID: ");
        String uid = sc.nextLine();

        System.out.print("Enter PIN: ");
        String upin = sc.nextLine();

        if (!user.login(uid, upin)) {
            System.out.println("❌ Invalid Credentials!");
            return;
        }

        System.out.println("✅ Login Successful!");

        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.showTransactionHistory();
                    break;

                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    atm.withdraw(w);
                    break;

                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    atm.deposit(d);
                    break;

                case 4:
                    sc.nextLine(); // clear buffer
                    System.out.print("Enter receiver name: ");
                    String receiver = sc.nextLine();
                    System.out.print("Enter amount to transfer: ");
                    double t = sc.nextDouble();
                    atm.transfer(t, receiver);
                    break;

                case 5:
                    System.out.println("💰 Current Balance: ₹" + atm.getBalance());
                    break;

                case 6:
                    System.out.println("👋 Thank you for using ATM!");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
    }
}