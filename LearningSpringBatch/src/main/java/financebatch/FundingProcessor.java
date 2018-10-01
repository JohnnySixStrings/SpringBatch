package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.batch.item.ItemProcessor;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FundingProcessor implements ItemProcessor <FundingPurchaseStatementUpgrade,FundingPurchaseStatementUpgrade> {

private SQLWrapperFunding duplicate;

    {
        try {
            duplicate = new SQLWrapperFunding("SELECT * FROM FundingStatement;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public FundingPurchaseStatementUpgrade process(FundingPurchaseStatementUpgrade item) {
        //Need to set up the check against current items in the Database
        if(duplicate.contains(item)){
            return null;
        }
       return item;
    }
}
