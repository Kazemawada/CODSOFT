import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private static ATM atm;

    public static void main(String[] args) {
        atm = new ATM();
        atm.addAccount(new BankAccount("1", 1000.0));
        atm.addAccount(new BankAccount("2", 500.0));

        JFrame frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("Enter ID:");
        JTextField idField = new JTextField();

        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField();

        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton addButton = new JButton("Add Account");

        panel.add(idLabel);
        panel.add(idField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(addButton);

        frame.add(panel);

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String amountText = amountField.getText();
                if (validateInput(id, amountText)) {
                    double amount = Double.parseDouble(amountText);
                    atm.withdraw(id, amount);
                    showOutput("Withdrawal successful.");
                } else {
                    showError("Please enter valid ID and amount.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String amountText = amountField.getText();
                if (validateInput(id, amountText)) {
                    double amount = Double.parseDouble(amountText);
                    atm.deposit(id, amount);
                    showOutput("Deposit successful.");
                } else {
                    showError("Please enter valid ID and amount.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (!id.isEmpty()) {
                    atm.checkBalance(id);
                    showOutput("Balance checked.");
                } else {
                    showError("Please enter a valid ID.");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                if (!id.isEmpty()) {
                    atm.addAccount(new BankAccount(id, 0.0));
                    showOutput("Account added.");
                } else {
                    showError("Please enter a valid ID.");
                }
            }
        });

        frame.setVisible(true);
    }

    private static boolean validateInput(String id, String amountText) {
        return !id.isEmpty() && !amountText.isEmpty();
    }

    private static void showOutput(String message) {
        System.out.println(message);
        JOptionPane.showMessageDialog(null, message, "ATM Output", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void showError(String message) {
        System.err.println(message);
        JOptionPane.showMessageDialog(null, message, "ATM Error", JOptionPane.ERROR_MESSAGE);
    }
}
