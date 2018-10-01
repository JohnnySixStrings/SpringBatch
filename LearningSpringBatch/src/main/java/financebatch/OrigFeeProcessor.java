package financebatch;

import org.springframework.batch.item.ItemProcessor;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class OrigFeeProcessor implements ItemProcessor<OriginationFeeUpgrade,OriginationFeeUpgrade> {

    SQLWrapperOrigFee duplicate;

    {
        try {
            duplicate = new SQLWrapperOrigFee("SELECT * FROM DailyOriginationFee;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public OriginationFeeUpgrade process(OriginationFeeUpgrade item)  {
      // Need to add checking against items already contained in the database
        if(duplicate.contains(item)){
            return null;
        }
        return item;
    }
}
