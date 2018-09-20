package financebatch;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import org.springframework.batch.item.ItemProcessor;

import java.util.HashSet;
import java.util.Set;

public class FundingProcessor implements ItemProcessor <FundingPurchaseStatementUpgrade,FundingPurchaseStatementUpgrade> {



    
    @Override
    public FundingPurchaseStatementUpgrade process(FundingPurchaseStatementUpgrade item) {
        //Need to set up the check against current items in the Database

       return item;
    }
}
