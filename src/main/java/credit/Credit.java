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

    public void setValueOfCredit(String arg) {
        try {
            this.valueOfCredit = Double.parseDouble(arg);
        }catch( Exception e ){
            this.valueOfCredit = 0;
        }
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

    public void setNumberOfInstallments(String arg) {
        try {
            this.numberOfInstallments = Double.parseDouble(arg);
        }catch( Exception e ){
            this.numberOfInstallments = 0;
        }
    }

    public double getFixedFee() {
        return FixedFee;
    }

    public void setFixedFee(String arg) {
        try {
            this.FixedFee= Double.parseDouble(arg);
        }catch( Exception e ){
            this.FixedFee = 0;
        }
    }

    public int getTypeOfInstallments() {
        return typeOfInstallments;
    }

    public void setTypeOfInstallments(int arg) {
        this.typeOfInstallments = arg;
    }


    public double interest(double arg, double prc) {
        return (arg * prc) / 100;
    }

    public double getTotalAmountOfInterest() {
        return totalAmountOfInterest;
    }

    public void setTotalAmountOfInterest(double totalAmountOfInterest) {
        this.totalAmountOfInterest = (interest(this.valueOfCredit, this.percent));
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
