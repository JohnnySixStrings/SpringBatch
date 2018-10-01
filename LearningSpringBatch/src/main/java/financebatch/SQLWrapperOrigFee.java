package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class SQLWrapperOrigFee {

    private Set<OriginationFeeUpgrade> duplicate = new HashSet<>();
    private SQLServerDataSource sqlConnection;

    public SQLWrapperOrigFee(String sqlStatement) throws  SQLException {
        // SSDS  is the private information of the db connection not included in the commit.
        SSDS ssds = new SSDS();
        this.sqlConnection =ssds.getSqlServerDataSource();
        try (Connection con = sqlConnection.getConnection(); Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                duplicate.add(new OriginationFeeUpgrade(rs.getString("Date"),rs.getString("OriginationVolume"),
                        rs.getString("CumulativeVolume"),rs.getString("DesignatedVolume"),
                        rs.getString("ItemCount"), rs.getString("PerLoanFee"), rs.getString("TotalOriginationVolume"),
                        rs.getString("BorrowerOriginationFee"), "",rs.getString("PerLoanAmount"),
                        rs.getString("MarketingFeeDue"),""));
            }
        }


    }

   public boolean contains(OriginationFeeUpgrade item){

       return duplicate.contains(item);
   }
}
