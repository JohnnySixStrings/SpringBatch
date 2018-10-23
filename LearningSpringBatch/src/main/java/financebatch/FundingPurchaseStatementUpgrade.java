package financebatch;

public class FundingPurchaseStatementUpgrade {
    public FundingPurchaseStatementUpgrade() {
    }

    public FundingPurchaseStatementUpgrade(String fundingDate, String loanId, String grossFundingAmount, String netFundingAmount,
                                           String originationFees, String state, String finalGrade, String ficoOfCustomer,
                                           String term, String purchaseDate, String interestRate, String numberOfDaysOfInterest,
                                           String interimInterest, String firstMonthPAndI, String serviceFee,
                                           String totalPurchaseAmount, String segment, String isSeasoned,
                                           String marketingFee, String allocatedId) {
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
        this.segment = segment;
        this.isSeasoned = isSeasoned;
        this.marketingFee = marketingFee;
        this.allocatedId = allocatedId;
    }

    private String fundingDate;
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
    private String segment;
    private String isSeasoned;
    private String marketingFee;
    private String allocatedId;

    public String getFundingDate() {
        return fundingDate;
    }

    public void setFundingDate(String fundingDate) {
        this.fundingDate = fundingDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getGrossFundingAmount() {
        return grossFundingAmount;
    }

    public void setGrossFundingAmount(String grossFundingAmount) {
        this.grossFundingAmount = grossFundingAmount;
    }

    public String getNetFundingAmount() {
        return netFundingAmount;
    }

    public void setNetFundingAmount(String netFundingAmount) {
        this.netFundingAmount = netFundingAmount;
    }

    public String getOriginationFees() {
        return originationFees;
    }

    public void setOriginationFees(String originationFees) {
        this.originationFees = originationFees;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(String finalGrade) {
        this.finalGrade = finalGrade;
    }

    public String getFicoOfCustomer() {
        return ficoOfCustomer;
    }

    public void setFicoOfCustomer(String ficoOfCustomer) {
        this.ficoOfCustomer = ficoOfCustomer;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(String interestRate) {
        this.interestRate = interestRate;
    }

    public String getNumberOfDaysOfInterest() {
        return numberOfDaysOfInterest;
    }

    public void setNumberOfDaysOfInterest(String numberOfDaysOfInterest) {
        this.numberOfDaysOfInterest = numberOfDaysOfInterest;
    }

    public String getInterimInterest() {
        return interimInterest;
    }

    public void setInterimInterest(String interimInterest) {
        this.interimInterest = interimInterest;
    }

    public String getFirstMonthPAndI() {
        return firstMonthPAndI;
    }

    public void setFirstMonthPAndI(String firstMonthPAndI) {
        this.firstMonthPAndI = firstMonthPAndI;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getTotalPurchaseAmount() {
        return totalPurchaseAmount;
    }

    public void setTotalPurchaseAmount(String totalPurchaseAmount) {
        this.totalPurchaseAmount = totalPurchaseAmount;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getIsSeasoned() {
        return isSeasoned;
    }

    public void setIsSeasoned(String isSeasoned) {
        this.isSeasoned = isSeasoned;
    }

    public String getMarketingFee() {
        return marketingFee;
    }

    public void setMarketingFee(String marketingFee) {
        this.marketingFee = marketingFee;
    }

    public String getAllocatedId() {
        return allocatedId;
    }

    public void setAllocatedId(String allocatedId) {
        this.allocatedId = allocatedId;
    }


    @Override
    public String toString() {
        return "FundingPurchaseStatementUpgrade{" +
                "fundingDate='" + fundingDate + '\'' +
                ", loanId='" + loanId + '\'' +
                ", grossFundingAmount='" + grossFundingAmount + '\'' +
                ", netFundingAmount='" + netFundingAmount + '\'' +
                ", originationFees='" + originationFees + '\'' +
                ", state='" + state + '\'' +
                ", finalGrade='" + finalGrade + '\'' +
                ", ficoOfCustomer='" + ficoOfCustomer + '\'' +
                ", term='" + term + '\'' +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", interestRate='" + interestRate + '\'' +
                ", numberOfDaysOfInterest='" + numberOfDaysOfInterest + '\'' +
                ", interimInterest='" + interimInterest + '\'' +
                ", firstMonthPAndI='" + firstMonthPAndI + '\'' +
                ", serviceFeel='" + serviceFee + '\'' +
                ", totalPurchaseAmount='" + totalPurchaseAmount + '\'' +
                ", segment='" + segment + '\'' +
                ", isSeasoned='" + isSeasoned + '\'' +
                ", marketingFee='" + marketingFee + '\'' +
                ", allocatedId='" + allocatedId + '\'' +
                '}';
    }
    // need to test override equals with junit
    // overriding the equals method because the fields in the database have less fields than the original document
    // in order for my check against duplicate data I need to compare only certain fields from the object.
   /* @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof FundingPurchaseStatementUpgrade)) return false;
        FundingPurchaseStatementUpgrade comp = (FundingPurchaseStatementUpgrade) obj;
        return comp.fundingDate.equals(this.fundingDate) &&
                comp.loanId.equals(this.loanId) &&
                comp.grossFundingAmount.equals(this.grossFundingAmount) &&
                comp.originationFees.equals(this.originationFees) &&
                comp.state.equals(this.state) &&
                comp.finalGrade.equals(this.finalGrade) &&
                comp.ficoOfCustomer.equals(this.ficoOfCustomer) &&
                comp.term.equals(this.term) &&
                comp.interestRate.equals(this.interestRate) &&
                comp.numberOfDaysOfInterest.equals(this.numberOfDaysOfInterest) &&
                comp.interimInterest.equals(this.interimInterest) &&
                comp.firstMonthPAndI.equals(this.firstMonthPAndI) &&
                comp.serviceFee.equals(this.serviceFee) &&
                comp.totalPurchaseAmount.equals(totalPurchaseAmount);
    }*/

}
