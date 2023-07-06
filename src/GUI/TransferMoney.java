package GUI;

import Backend.validateUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import Backend.transferUserMoney;


public class TransferMoney extends JFrame {
    private JTextField AccountNo;

    private JTextField Amount;

    private JPasswordField passwordField;
    private JButton transferButton;

    public TransferMoney(JFrame parentFrame,String accountNumber) {
        setTitle("Transfer Money Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(325,350);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel AccountLabel = new JLabel("Deposit Account No:");
        JLabel AmountLabel = new JLabel("Amount:");
        JLabel PasswordLabel = new JLabel("Password:");


        AccountNo = new JTextField(20);
        Amount=new JTextField(20);

        passwordField = new JPasswordField(20);
        transferButton = new JButton("Transfer");

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String transferAccountNumber = AccountNo.getText();
                String input = Amount.getText();  // Assuming Amount is a text field or similar GUI component
                double transferMoney = Integer.parseInt(input);
                String password = new String(passwordField.getPassword());

                validateUser obj = new validateUser();
                boolean validation = obj.validate_user(accountNumber,password);
                if(validation)
                {
                    transferUserMoney obj1 = new transferUserMoney();
                    int result = 0;
                    try {
                        result = obj1.transfer_money(transferMoney,accountNumber,transferAccountNumber);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    if(result == 0)  // transfer account do not exists
                    {
                        JOptionPane.showMessageDialog(TransferMoney.this, "Transfer account do not exists!!");

                    }else if(result == 1)
                    {
                        JOptionPane.showMessageDialog(TransferMoney.this, "Insufficient balance!!");

                    }else
                    {
                        JOptionPane.showMessageDialog(TransferMoney.this, "Money Transferred successfully!!");
                    }

                }else
                {
                    JOptionPane.showMessageDialog(TransferMoney.this, "Incorrect Password!!");

                }
                dispose();
                parentFrame.setVisible(true);
            }
        });


        add(AccountLabel);
        add(AccountNo);

        add(AmountLabel);
        add(Amount);

        add(PasswordLabel);
        add(passwordField);

        add(transferButton);
        parentFrame.setVisible(false);
    }
}
