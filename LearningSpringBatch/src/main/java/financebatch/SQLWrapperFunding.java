package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

class SQLWrapperFunding {
    private Set<FundingPurchaseFromDB> duplicate = new HashSet<>();
        SQLWrapperFunding(String sqlStatement)throws SQLException {
        SSDS ssds = new SSDS();
        //private Set<FundingPurchaseStatementUpgrade> duplicate = new HashSet<>();

        SQLServerDataSource sqlConnection = ssds.getSqlServerDataSource();
        try (Connection con = sqlConnection.getConnection(); Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlStatement);
            while (rs.next()) {
                if(!rs.getString("LoanID").isEmpty()||rs.getString("LoanID").matches("XXX")) {
                    duplicate.add(new FundingPurchaseFromDB( rs.getString("FundingDate"),
                             rs.getString("LoanID"),
                             rs.getString("GrossFundingAmount"),
                             rs.getString("NetFundingAmount"),
                             rs.getString("OriginationFees"),
                             rs.getString("State"),
                             rs.getString("FinalGrade"),
                             rs.getString("FICOofCustomer"),
                             rs.getString("Term"),
                             rs.getString("PurchaseDate"),
                             rs.getString("InterestRate"),
                             rs.getString("NumOfDaysInterest"),
                             rs.getString("InterimInterest"),
                             rs.getString("FirstMoPI"),
                             rs.getString("ServiceFee"),
                             rs.getString("TotalPurchaseAmount")));
                }

              /*  duplicate.add(new FundingPurchaseStatementUpgrade(rs.getString("FundingDate"),
                    rs.getString("LoanID"),
                    rs.getString("GrossFundingAmount"),
                    rs.getString("NetFundingAmount"),
                    rs.getString("OriginationFees"),
                    rs.getString("State"),
                    rs.getString("FinalGrade"),
                    rs.getString("FICOofCustomer"),
                    rs.getString("Term"),
                    "",
                    rs.getString("InterestRate"),
                    rs.getString("NumOfDaysInterest"),
                    rs.getString("InterimInterest"),
                    rs.getString("FirstMoPI"),
                    rs.getString("ServiceFee"),
                    rs.getString("TotalPurchaseAmount"),
                    "",
                    "",
                    "",
                    ""));*/
        }
        }



    }
    void add(FundingPurchaseFromDB item){
            duplicate.add(item);
    }
     boolean contains(FundingPurchaseFromDB item){

        return duplicate.contains(item);
    }
}
