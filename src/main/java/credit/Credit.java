package credit;

/**
 * Created by Szymon on 2017-03-14.
 * update
 */
public class Credit {

    private double valueOfCredit;
    private double percent;
    private double numberOfInstallments;
    private double FixedFee;
    private int typeOfInstallments;
    private double totalAmountOfInterest;
    private double totalAmountOfFixedFee;
    private double totalAmount;

    public double getValueOfCredit() {
        return valueOfCredit;
    }

    public void setValueOfCredit(double valueOfCredit) {
        this.valueOfCredit = valueOfCredit;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public double getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(double numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public double getFixedFee() {
        return FixedFee;
    }

    public void setFixedFee(double fixedFee) {
        FixedFee = fixedFee;
    }

    public int getTypeOfInstallments() {
        return typeOfInstallments;
    }

    public void setTypeOfInstallments(int typeOfInstallments) {
        this.typeOfInstallments = typeOfInstallments;
    }

    public double getTotalAmountOfInterest() {
        return totalAmountOfInterest;
    }

    public void setTotalAmountOfInterest(double totalAmountOfInterest) {
        this.totalAmountOfInterest = totalAmountOfInterest;
    }

    public double getTotalAmountOfFixedFee() {
        return totalAmountOfFixedFee;
    }

    public void setTotalAmountOfFixedFee(double totalAmountOfFixedFee) {
        this.totalAmountOfFixedFee = totalAmountOfFixedFee;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
