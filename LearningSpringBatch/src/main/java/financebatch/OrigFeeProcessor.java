package financebatch;

import org.springframework.batch.item.ItemProcessor;

import java.util.HashSet;
import java.util.Set;

public class OrigFeeProcessor implements ItemProcessor<OriginationFeeUpgrade,OriginationFeeUpgrade> {



    @Override
    public OriginationFeeUpgrade process(OriginationFeeUpgrade item)  {
      // Need to add checking against items already contained in the database
        return null;
    }
}
