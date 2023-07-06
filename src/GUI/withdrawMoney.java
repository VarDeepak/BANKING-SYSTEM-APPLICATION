package GUI;

import Backend.depositUserMoney;
import Backend.withdrawUserMoney;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class withdrawMoney extends JFrame {
    private JTextField Amount;
    private JButton withdrawButton;

    public withdrawMoney(JFrame parentFrame,String accountNumber) {
        setTitle("Withdraw Money Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(325,350);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel AmountLabel = new JLabel("Amount:");

        Amount=new JTextField(20);
        withdrawButton = new JButton("Withdraw");

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Amount.getText();  // Assuming Amount is a text field or similar GUI component
                double withdraw_amount = Integer.parseInt(input);
                    withdrawUserMoney obj = new withdrawUserMoney();
                try {
                    if(obj.withdraw_money(withdraw_amount,accountNumber))
                    {
                        JOptionPane.showMessageDialog(withdrawMoney.this, "Money Withdrawn successfully!");

                    }else
                    {
                        JOptionPane.showMessageDialog(withdrawMoney.this, "Insufficient Balance!!");

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                dispose();
                parentFrame.setVisible(true);
            }
        });



        add(AmountLabel);
        add(Amount);
        add(withdrawButton);
        parentFrame.setVisible(false);
    }
}
