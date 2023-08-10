import java.util.ArrayList;

public class ATM {
    private ArrayList<BankAccount> bankAccounts;

    public ATM() {
        bankAccounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        bankAccounts.add(account);
    }

    public BankAccount searchAccount(String id) {
        for (BankAccount account : bankAccounts) {
            if (account.getId().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public void withdraw(String id, double amount) {
        BankAccount account = searchAccount(id);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.withdraw(amount);
                System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient balance for withdrawal.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void deposit(String id, double amount) {
        BankAccount account = searchAccount(id);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String id) {
        BankAccount account = searchAccount(id);
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
}
