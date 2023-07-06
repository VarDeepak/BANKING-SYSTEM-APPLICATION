package Backend;

import java.sql.SQLException;

public class transferUserMoney {
    public static int transfer_money(double transfer_money,String accountNumber,String transferAccountNumber) throws SQLException {
        JDBC db = new JDBC();
        return db.transfer_money(transfer_money,accountNumber,transferAccountNumber);
    }
}
