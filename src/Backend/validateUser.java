package Backend;

public class validateUser {
    public static boolean validate_user(String accountNumber, String password)
    {
        JDBC db = new JDBC();
        return db.checkAccountAndPassword(accountNumber,password);
    }
}
