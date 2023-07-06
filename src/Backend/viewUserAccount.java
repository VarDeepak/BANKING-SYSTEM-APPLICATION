package Backend;

public class viewUserAccount {
    public String[] userDetails(String accountNumber)
    {
        JDBC db = new JDBC();
        String[] user_details = db.getAccountDetails(accountNumber);
        // returning a string array storing the detials of user as firstname, secondname,phonenumber,balance
        return user_details;
    }
}
