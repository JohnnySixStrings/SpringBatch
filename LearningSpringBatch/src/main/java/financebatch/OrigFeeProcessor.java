package financebatch;

import org.springframework.batch.item.ItemProcessor;

import java.text.ParseException;


public class OrigFeeProcessor implements ItemProcessor<OriginationFeeUpgrade,OriginationFeeUpgrade> {

    private SQLWrapperOrigFee duplicate;

    {
        try {
            duplicate = new SQLWrapperOrigFee("SELECT Date FROM DailyOriginationFee;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public OriginationFeeUpgrade process(OriginationFeeUpgrade item) throws ParseException {
      // Need to add checking against items already contained in the database
        if(item.getDate().isEmpty()){
            return null;
        }
        else if(duplicate.contains(item.getDate())){
            return null;
        }
        duplicate.add(item.getDate());
        return item;
    }
}
