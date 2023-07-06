package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Backend.validateUser;

public class loginPage extends JFrame{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    static public JFrame parentFrame;

    public loginPage() {
        setTitle("Login Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        //deepak
//        JPanel panel = new JPanel();
//        panel.setPreferredSize(new Dimension(300,100));
//        panel.setBackground(Color.red);
//        panel.setLayout(new FlowLayout());
        //deepak

        JLabel usernameLabel = new JLabel("Account No.:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");
        JLabel registerLabel = new JLabel("Don't have an account? Register here");

        // deepak
//        panel.add(usernameLabel);
//        panel.add(usernameField);
//        panel.add(passwordLabel);
//        panel.add(passwordField);
//        panel.add(loginButton);
//        panel.add(registerLabel);
//
//        add(panel);
        //deepak

        registerLabel.setForeground(Color.BLUE);
        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                // Perform action when the link is clicked
                openRegistrationPage();
            }
        });


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // login validation
                validateUser obj1 = new validateUser();
                boolean validation = obj1.validate_user(accountNumber,password);

                if (validation) {
                    viewAccount obj=new viewAccount(parentFrame,accountNumber);
                    obj.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(loginPage.this, "Invalid username or password!");
                }
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerLabel);

        setVisible(true);
        parentFrame=this;
    }

//    public loginPage() {
//        setTitle("Login Page");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setMinimumSize(new Dimension(300, 200));
//        setLocationRelativeTo(null);
//        setLayout(new GridBagLayout());
//
//        JLabel usernameLabel = new JLabel("Account No.:");
//        JLabel passwordLabel = new JLabel("Password:");
//        usernameField = new JTextField(20);
//        passwordField = new JPasswordField(20);
//        loginButton = new JButton("Login");
//        JLabel registerLabel = new JLabel("Don't have an account? Register here");
//
//        // Set up layout constraints for components
//        GridBagConstraints constraints = new GridBagConstraints();
//        constraints.fill = GridBagConstraints.HORIZONTAL;
//        constraints.insets = new Insets(5, 5, 5, 5);
//
//        // Add components to the frame with layout constraints
//        constraints.gridx = 0;
//        constraints.gridy = 0;
//        add(usernameLabel, constraints);
//
//        constraints.gridx = 1;
//        add(usernameField, constraints);
//
//        constraints.gridx = 0;
//        constraints.gridy = 1;
//        add(passwordLabel, constraints);
//
//        constraints.gridx = 1;
//        add(passwordField, constraints);
//
//        constraints.gridx = 0;
//        constraints.gridy = 2;
//        constraints.gridwidth = 2;
//        add(loginButton, constraints);
//
//        constraints.gridy = 3;
//        add(registerLabel, constraints);
//
//        // Set additional properties for the register label
//        registerLabel.setForeground(Color.BLUE);
//        registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        registerLabel.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                // Perform action when the link is clicked
//                openRegistrationPage();
//            }
//        });
//
//        loginButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String accountNumber = usernameField.getText();
//                String password = new String(passwordField.getPassword());
//
//                // login validation
//                validateUser obj1 = new validateUser();
//                boolean validation = obj1.validate_user(accountNumber,password);
//
//                if (validation) {
//                    viewAccount obj=new viewAccount(parentFrame,accountNumber);
//                    obj.setVisible(true);
//                } else {
//                    JOptionPane.showMessageDialog(loginPage.this, "Invalid username or password!");
//                }
//            }
//        });
//
//        pack();
//        setVisible(true);
//    }

    private void openRegistrationPage() {
        newAccountCreate registrationPage = new newAccountCreate(this);
        registrationPage.setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new loginPage();
            }
        });
    }
}
