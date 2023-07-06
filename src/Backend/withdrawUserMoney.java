package Backend;

import java.sql.SQLException;

public class withdrawUserMoney {
    public static boolean withdraw_money(double withdraw_money,String accountNumber) throws SQLException {
        JDBC db = new JDBC();
        return db.money_withdrawl(withdraw_money,accountNumber);
    }
}
