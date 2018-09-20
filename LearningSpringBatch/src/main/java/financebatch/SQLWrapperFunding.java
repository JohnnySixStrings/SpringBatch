package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class SQLWrapperFunding {

    private Set<FundingPurchaseStatementUpgrade> duplicate = new HashSet<>();
    private SQLServerDataSource sqlConnection;

    public SQLWrapperFunding(String sqlStatement)throws SQLException {
        SSDS ssds = new SSDS();
        this.sqlConnection =ssds.getSqlServerDataSource();
        try (Connection con = sqlConnection.getConnection(); Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                //Empty till
            }
        }



    }
}
