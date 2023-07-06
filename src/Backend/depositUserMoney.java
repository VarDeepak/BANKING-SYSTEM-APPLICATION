package Backend;

import java.sql.SQLException;

public class depositUserMoney {
    public depositUserMoney(double deposit_money,String accountNumber) throws SQLException {
        JDBC db = new JDBC();
        db.deposit_money(deposit_money,accountNumber);
    }
}
