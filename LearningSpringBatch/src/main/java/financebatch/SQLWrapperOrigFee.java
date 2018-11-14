package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
class SQLWrapperOrigFee {

    private Set<String> duplicate = new HashSet<>();
    SQLWrapperOrigFee(String sqlStatement) throws  SQLException, ParseException {
        // SSDS  is the private information of the db connection not included in the commit.
        SSDS ssds = new SSDS();
        //private Set<OriginationFeeUpgrade> duplicate = new HashSet<>();
        SQLServerDataSource sqlConnection = ssds.getSqlServerDataSource();
        try (Connection con = sqlConnection.getConnection(); Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                if(!rs.getString("Date").isEmpty()) {
                    duplicate.add(rs.getString("Date"));
                }


              /*  duplicate.add(new OriginationFeeUpgrade(rs.getString("Date"),
                        rs.getString("OriginationVolume"),
                        rs.getString("CumulativeVolume"),
                        rs.getString("DesignatedAmount"),
                        rs.getString("ItemCount"),
                        rs.getString("PerLoanFee"),
                        rs.getString("TotalOriginationVolume"),
                        rs.getString("BorrowerOriginationFee"),
                        "",
                        rs.getString("PerLoanAmount"),
                        rs.getString("MarketingFeeDue"),
                        ""));*/
            }
        }


    }
    void add(String item){
        duplicate.add(item);
    }
    boolean contains(String item){

        return duplicate.contains(item);
   }
}
