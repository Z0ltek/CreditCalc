package credit;

/**
 * Created by Szymon on 2017-03-14.
 * update
 */
public class Credit {

    private double valueOfCredit;
    private double percent;
    private int numberOfInstallments;

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

    public int getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }
}