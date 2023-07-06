package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Backend.depositUserMoney;


public class depositMoney extends JFrame {
    private JTextField Amount;
    private JButton depositButton;

    public depositMoney(JFrame parentFrame,String accountNumber) {
        setTitle("Deposit Money Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(325,350);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel AmountLabel = new JLabel("Amount:");

        Amount=new JTextField(20);
        depositButton = new JButton("Deposit");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Amount.getText();  // Assuming Amount is a text field or similar GUI component
                double deposit_amount = Integer.parseInt(input);

                try {
                    depositUserMoney obj = new depositUserMoney(deposit_amount,accountNumber);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(depositMoney.this, "Money Deposited successfully!");

                dispose();
                parentFrame.setVisible(true);
            }
        });



        add(AmountLabel);
        add(Amount);
        add(depositButton);
        parentFrame.setVisible(false);
    }
}
