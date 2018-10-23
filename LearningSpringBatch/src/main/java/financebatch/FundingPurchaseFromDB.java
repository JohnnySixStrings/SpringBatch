package financebatch;

import java.util.Objects;

public class FundingPurchaseFromDB { private String fundingDate;
    private String loanId;
    private String grossFundingAmount;
    private String netFundingAmount;
    private String originationFees;
    private String state;
    private String finalGrade;
    private String ficoOfCustomer;
    private String term;
    private String purchaseDate;
    private String interestRate;
    private String numberOfDaysOfInterest;
    private String interimInterest;
    private String firstMonthPAndI;
    private String serviceFee;
    private String totalPurchaseAmount;
    FundingPurchaseFromDB(){}
    FundingPurchaseFromDB(String fundingDate,
                                 String loanId,
                                 String grossFundingAmount,
                                 String netFundingAmount,
                                 String originationFees,
                                 String state,
                                 String finalGrade,
                                 String ficoOfCustomer,
                                 String term,
                                 String purchaseDate,
                                 String interestRate,
                                 String numberOfDaysOfInterest,
                                 String interimInterest,
                                 String firstMonthPAndI,
                                 String serviceFee,
                                 String totalPurchaseAmount)
    {
        this.fundingDate = fundingDate;
        this.loanId = loanId;
        this.grossFundingAmount = grossFundingAmount;
        this.netFundingAmount = netFundingAmount;
        this.originationFees = originationFees;
        this.state = state;
        this.finalGrade = finalGrade;
        this.ficoOfCustomer = ficoOfCustomer;
        this.term = term;
        this.purchaseDate = purchaseDate;
        this.interestRate = interestRate;
        this.numberOfDaysOfInterest = numberOfDaysOfInterest;
        this.interimInterest = interimInterest;
        this.firstMonthPAndI = firstMonthPAndI;
        this.serviceFee = serviceFee;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }
    public String getFundingDate() { return fundingDate; }

    public void setFundingDate(String fundingDate) { this.fundingDate = fundingDate; }

    public String getLoanId() { return loanId; }

    public void setLoanId(String loanId) { this.loanId = loanId; }

    public String getGrossFundingAmount() { return grossFundingAmount; }

    public void setGrossFundingAmount(String grossFundingAmount) { this.grossFundingAmount = grossFundingAmount; }

    public String getNetFundingAmount() { return netFundingAmount; }

    public void setNetFundingAmount(String netFundingAmount) { this.netFundingAmount = netFundingAmount; }

    public String getOriginationFees() { return originationFees; }

    public void setOriginationFees(String originationFees) { this.originationFees = originationFees; }

    public String getState() { return state; }

    public void setState(String state) { this.state = state; }

    public String getFinalGrade() { return finalGrade; }

    public void setFinalGrade(String finalGrade) { this.finalGrade = finalGrade; }

    public String getFicoOfCustomer() { return ficoOfCustomer; }

    public void setFicoOfCustomer(String ficoOfCustomer) { this.ficoOfCustomer = ficoOfCustomer; }

    public String getTerm() { return term; }

    public void setTerm(String term) { this.term = term; }

    public String getPurchaseDate() { return purchaseDate; }

    public void setPurchaseDate(String purchaseDate) { this.purchaseDate = purchaseDate; }

    public String getInterestRate() { return interestRate; }

    public void setInterestRate(String interestRate) { this.interestRate = interestRate; }

    public String getNumberOfDaysOfInterest() { return numberOfDaysOfInterest; }

    public void setNumberOfDaysOfInterest(String numberOfDaysOfInterest) { this.numberOfDaysOfInterest = numberOfDaysOfInterest; }

    public String getInterimInterest() { return interimInterest; }

    public void setInterimInterest(String interimInterest) { this.interimInterest = interimInterest; }

    public String getFirstMonthPAndI() { return firstMonthPAndI; }

    public void setFirstMonthPAndI(String firstMonthPAndI) { this.firstMonthPAndI = firstMonthPAndI; }

    public String getServiceFee() { return serviceFee; }

    public void setServiceFee(String serviceFee) { this.serviceFee = serviceFee; }

    public String getTotalPurchaseAmount() { return totalPurchaseAmount; }

    public void setTotalPurchaseAmount(String totalPurchaseAmount) { this.totalPurchaseAmount = totalPurchaseAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FundingPurchaseFromDB that = (FundingPurchaseFromDB) o;
        return Objects.equals(fundingDate, that.fundingDate) &&
                Objects.equals(loanId, that.loanId) &&
                Objects.equals(grossFundingAmount, that.grossFundingAmount) &&
                Objects.equals(netFundingAmount, that.netFundingAmount) &&
                Objects.equals(originationFees, that.originationFees) &&
                Objects.equals(state, that.state) &&
                Objects.equals(finalGrade, that.finalGrade) &&
                Objects.equals(ficoOfCustomer, that.ficoOfCustomer) &&
                Objects.equals(term, that.term) &&
                Objects.equals(purchaseDate, that.purchaseDate) &&
                Objects.equals(interestRate, that.interestRate) &&
                Objects.equals(numberOfDaysOfInterest, that.numberOfDaysOfInterest) &&
                Objects.equals(interimInterest, that.interimInterest) &&
                Objects.equals(firstMonthPAndI, that.firstMonthPAndI) &&
                Objects.equals(serviceFee, that.serviceFee) &&
                Objects.equals(totalPurchaseAmount, that.totalPurchaseAmount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fundingDate, loanId,
                grossFundingAmount, netFundingAmount,
                originationFees, state, finalGrade,
                ficoOfCustomer, term, purchaseDate,
                interestRate, numberOfDaysOfInterest,
                interimInterest, firstMonthPAndI,
                serviceFee, totalPurchaseAmount);
    }
}
