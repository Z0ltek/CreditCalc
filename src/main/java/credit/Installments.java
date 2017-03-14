package credit;

/**
 * Created by Szymon on 2017-03-14.
 * update
 */
public class Installments {

    public int numberOfInstallment;
    public double valueNett;
    public double valueGross;
    public double percentage;
    public double fee;

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getValueNett() {
        return valueNett;
    }

    public void setValueNett(double valueNett) {
        this.valueNett = valueNett;
    }

    public double getValueGross() {
        return valueGross;
    }

    public void setValueGross(double valueGross) {
        this.valueGross = valueGross;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }


    public int getNumberOfInstallment() {
        return numberOfInstallment;
    }

    public void setNumberOfInstallment(int numberOfInstallment) {
        this.numberOfInstallment = numberOfInstallment;
    }
}
