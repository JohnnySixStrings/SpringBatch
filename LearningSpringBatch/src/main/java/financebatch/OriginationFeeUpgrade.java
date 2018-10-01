package financebatch;

import java.util.Date;

public class OriginationFeeUpgrade {

    private String date;
    private String originationVolume;
    private String cumulativeVolume;
    private String designatedAmount;
    private String itemCount;
    private String perLoanFee;
    private String totalOriginationVolume;
    private String borrowerOriginationFee;
    private String designatedAmount1;
    private String perLoanAmount;
    private String marketingFeeDue;
    private String marketingFeeSeasoned;

    public OriginationFeeUpgrade(){}


    public OriginationFeeUpgrade(String date, String originationVolume, String cumulativeVolume, String designatedAmount,
                                 String itemCount, String perLoanFee, String totalOriginationVolume,
                                 String borrowerOriginationFee, String designatedAmount1, String perLoanAmount,
                                 String marketingFeeDue, String marketingFeeSeasoned) {
        this.date = date;
        this.originationVolume = originationVolume;
        this.cumulativeVolume = cumulativeVolume;
        this.designatedAmount = designatedAmount;
        this.itemCount = itemCount;
        this.perLoanFee = perLoanFee;
        this.totalOriginationVolume = totalOriginationVolume;
        this.borrowerOriginationFee = borrowerOriginationFee;
        this.designatedAmount1 = designatedAmount1;
        this.perLoanAmount = perLoanAmount;
        this.marketingFeeDue = marketingFeeDue;
        this.marketingFeeSeasoned = marketingFeeSeasoned;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOriginationVolume() {
        return originationVolume;
    }

    public void setOriginationVolume(String originationVolume) {
        this.originationVolume = originationVolume;
    }

    public String getCumulativeVolume() {
        return cumulativeVolume;
    }

    public void setCumulativeVolume(String cumulativeVolume) {
        this.cumulativeVolume = cumulativeVolume;
    }

    public String getDesignatedAmount() {
        return designatedAmount;
    }

    public void setDesignatedAmount(String designatedAmount) {
        this.designatedAmount = designatedAmount;
    }

    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getPerLoanFee() {
        return perLoanFee;
    }

    public void setPerLoanFee(String perLoanFee) {
        this.perLoanFee = perLoanFee;
    }

    public String getTotalOriginationVolume() {
        return totalOriginationVolume;
    }

    public void setTotalOriginationVolume(String totalOriginationVolume) { this.totalOriginationVolume = totalOriginationVolume;}

    public String getBorrowerOriginationFee() {
        return borrowerOriginationFee;
    }

    public void setBorrowerOriginationFee(String borrowerOriginationFee) { this.borrowerOriginationFee = borrowerOriginationFee;}

    public String getDesignatedAmount1() {
        return designatedAmount1;
    }

    public void setDesignatedAmount1(String designatedAmount1) {
        this.designatedAmount1 = designatedAmount1;
    }

    public String getPerLoanAmount() {
        return perLoanAmount;
    }

    public void setPerLoanAmount(String perLoanAmount) {
        this.perLoanAmount = perLoanAmount;
    }

    public String getMarketingFeeDue() {
        return marketingFeeDue;
    }

    public void setMarketingFeeDue(String marketingFeeDue) {
        this.marketingFeeDue = marketingFeeDue;
    }

    public String getMarketingFeeSeasoned() {
        return marketingFeeSeasoned;
    }

    public void setMarketingFeeSeasoned(String marketingFeeSeasoned) { this.marketingFeeSeasoned = marketingFeeSeasoned;}

    @Override
    public String toString() {
        return "OriginationFeeUpgrade{" +
                "date='" + date + '\'' +
                ", origination='" + originationVolume + '\'' +
                ", cumulativeVolume='" + cumulativeVolume + '\'' +
                ", designatedAmount='" + designatedAmount + '\'' +
                ", itemCount='" + itemCount + '\'' +
                ", perLoanFee='" + perLoanFee + '\'' +
                ", totalOriginationVolume='" + totalOriginationVolume + '\'' +
                ", borrowerOriginationFee='" + borrowerOriginationFee + '\'' +
                ", designatedAmount1='" + designatedAmount1 + '\'' +
                ", perLoanAmount='" + perLoanAmount + '\'' +
                ", marketingFeeDue='" + marketingFeeDue + '\'' +
                ", marketingFeeSeasoned='" + marketingFeeSeasoned + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof OriginationFeeUpgrade))return false;
        OriginationFeeUpgrade comp = (OriginationFeeUpgrade) obj;
        return comp.date.equals(this.date) &&
                comp.originationVolume.equals(this.originationVolume) &&
                comp.cumulativeVolume.equals(this.cumulativeVolume) &&
                comp.designatedAmount.equals(this.designatedAmount) &&
                comp.itemCount.equals(this.itemCount) &&
                comp.perLoanFee.equals(this.perLoanFee) &&
                comp.totalOriginationVolume.equals(this.totalOriginationVolume) &&
                comp.borrowerOriginationFee.equals(this.borrowerOriginationFee) &&
                comp.perLoanAmount.equals(perLoanAmount) &&
                comp.marketingFeeDue.equals(this.marketingFeeDue);
    }
}
