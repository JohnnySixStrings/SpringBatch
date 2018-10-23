package financebatch;


import org.springframework.batch.item.ItemProcessor;

import java.sql.SQLException;


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
        if (item.getLoanId().isEmpty()){
            return null;
        }
        if(item.getLoanId().contains("X")){
            String current = new StringBuilder(item.getLoanId()).replace(0,3,"000").toString(); // "000"+item.getLoanId().substring(2);
            item.setLoanId(current);

        }

        if(duplicate.contains(new FundingPurchaseFromDB(item.getFundingDate(),
                item.getLoanId(),
                item.getGrossFundingAmount(),
                item.getNetFundingAmount(),
                item.getOriginationFees(),
                item.getState(),
                item.getFinalGrade(),
                item.getFicoOfCustomer(),
                item.getTerm(),
                item.getPurchaseDate(),
                item.getInterestRate(),
                item.getNumberOfDaysOfInterest(),
                item.getInterimInterest(),
                item.getFirstMonthPAndI(),
                item.getServiceFee(),
                item.getTotalPurchaseAmount()))){
            return null;
        }

            return item;

    }
}
