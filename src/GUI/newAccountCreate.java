package GUI;

// check phonr number and if invalid return to register page
// check if all feilds are input
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Backend.createAccount;

public class newAccountCreate extends JFrame {
        private JTextField firstnameField;
        private JTextField lastnameField;
        private JTextField phonenoField;
        private JPasswordField passwordField;
        private JButton registerButton;

    public newAccountCreate(JFrame parent) {
            setTitle("Registration Page");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(325,350);
            setLocationRelativeTo(parent);
            setLayout(new FlowLayout());

            JLabel FirstNameLabel = new JLabel("First Name:");
            JLabel LastNameLabel = new JLabel("Last Name:");
            JLabel PhoneNoLabel = new JLabel("Phone No:");
            JLabel PasswordLabel = new JLabel("Password:");


            firstnameField = new JTextField(20);
            lastnameField=new JTextField(20);
            phonenoField=new JTextField(20);
            passwordField = new JPasswordField(20);
            registerButton = new JButton("Register");

            registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String Firstname = firstnameField.getText();
                    if(Firstname.isEmpty())
                    {
                        JOptionPane.showMessageDialog(newAccountCreate.this,"Please enter the First Name");
                        newAccountCreate registrationPage = new newAccountCreate(parent);
                        return;
                    }
                    String Lastname=lastnameField.getText();
                    if(Lastname.isEmpty())
                    {
                        JOptionPane.showMessageDialog(newAccountCreate.this,"Please enter the Last Name");
                        newAccountCreate registrationPage = new newAccountCreate(parent);
                        return;
                    }
                    String phoneno = phonenoField.getText();
                    if(phoneno.length() != 10) {
                        JOptionPane.showMessageDialog(newAccountCreate.this,"Invalid Phone Number");
                        newAccountCreate registrationPage = new newAccountCreate(parent);
                        return;
                    }
                    String password = new String(passwordField.getPassword());
                    if(password.isEmpty())
                    {
                        JOptionPane.showMessageDialog(newAccountCreate.this,"Please enter the Password");
                        newAccountCreate registrationPage = new newAccountCreate(parent);
                        return;
                    }


                    createAccount obj = new createAccount(Firstname,Lastname,phoneno,password);

                    JOptionPane.showMessageDialog(newAccountCreate.this, "Registration successful!");
                    parent.setVisible(true);
                    dispose();
                }
            });

            add(FirstNameLabel);
            add(firstnameField);

            add(LastNameLabel);
            add(lastnameField);

            add(PhoneNoLabel);
            add(phonenoField);

            add(PasswordLabel);
            add(passwordField);

            add(registerButton);
        }
    }
