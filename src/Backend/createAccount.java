package Backend;

import java.util.Random;

public class createAccount {
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String phoneNo;
    private String password;
    private double balance;

    // Constructor
    public createAccount(String firstName, String lastName,String phoneNo,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        passwordEncrypt obj = new passwordEncrypt();
        this.password = obj.encrypt_password(password);
        this.phoneNo = phoneNo;
        this.balance = 0.0;
        this.accountNumber = generateAccountNumber();

        JDBC dbconnection = new JDBC();
        dbconnection.setDetails(firstName,lastName,phoneNo,this.password,balance,accountNumber);
    }

     public static String generateAccountNumber() {
            Random random = new Random();
            StringBuilder accountNumber = new StringBuilder();

            // Generate a random 9-digit account number
            for (int i = 0; i < 9; i++) {
                int digit = random.nextInt(10);
                accountNumber.append(digit);
            }
            return accountNumber.toString();
        }
}
