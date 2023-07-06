package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Backend.viewUserAccount;

public class viewAccount extends JFrame {
    private JButton depositmoneyButton;
    private JButton transferButton;
    private JButton WithdrawButton;
    private static JFrame parentFrame;

    public viewAccount(JFrame parFrame,String accountNumber) {
        setTitle("Account View Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(325,200);
        setLocationRelativeTo(null);
        // setLayout(new FlowLayout(FlowLayout.CENTER));
        setLayout(new BorderLayout());

        //getting the account details
        viewUserAccount obj = new viewUserAccount();
        // storing the details of the user in form af an String array in sequence
        String[] details = obj.userDetails(accountNumber);


        //top panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.GRAY);
        topPanel.setPreferredSize(new Dimension(30, 30));
        JLabel AccountLabel = new JLabel("Account No:" + accountNumber);
        topPanel.add(AccountLabel,BorderLayout.WEST);
        JLabel BalanceLabel = new JLabel("Balance:"+details[3]);
        topPanel.add(BalanceLabel,BorderLayout.EAST);


        //center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout());
        JLabel NameLabel = new JLabel("Name:"+ details[0] + " " + details[1]);
        JLabel phonenoLabel = new JLabel("Phone No:" + details[2]);
        centerPanel.add(phonenoLabel,FlowLayout.LEFT);
        centerPanel.add(NameLabel,FlowLayout.LEFT);

        // bottom panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        transferButton = new JButton("Transfer Money");
        WithdrawButton = new JButton("Withdraw Money");
        depositmoneyButton = new JButton("Deposit Money");

        buttonPanel.add(transferButton);
        buttonPanel.add(WithdrawButton);
        buttonPanel.add(depositmoneyButton);

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TransferMoney obj=new TransferMoney(parentFrame,accountNumber);
                obj.setVisible(true);
               // JOptionPane.showMessageDialog(viewAccount.this, "Money Transferred successfully!");
            }
        });

        WithdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                withdrawMoney obj=new withdrawMoney(parentFrame,accountNumber);
                obj.setVisible(true);
               // JOptionPane.showMessageDialog(viewAccount.this, "Money Withdrawn successfully!");

            }
        });

        depositmoneyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                depositMoney obj=new depositMoney(parentFrame,accountNumber);
                obj.setVisible(true);
//                viewAccount obj1 =new viewAccount(parentFrame,accountNumber);
//                obj1.setVisible(true);
                //JOptionPane.showMessageDialog(viewAccount.this, "Money Deposited successfully!");

            }
        });

        add(topPanel,BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);

        add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);
        parentFrame=this;
        parFrame.setVisible(false);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new viewAccount(parentFrame,);
//            }
//        });
//    }
}
