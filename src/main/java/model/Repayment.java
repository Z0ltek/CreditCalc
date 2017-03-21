package model;
import credit.Credit;

/**
 * Created by Szymon on 2017-03-17.
 */
public class Repayment {

    private double valueOfCredit;
    private double percent;
    private int numberOfInstallments;


    private double saldo;
    private double capital;
    private double interest;
    private double left;
    private int n;
    private double installment;


    private StringBuilder stringBuilder = new StringBuilder();

    private String headers = "<tr>"
            + "<th>Miesiac</th>"
            + "<th>Saldo</th>"
            + "<th>Czesc odsetkowa</th>"
            + "<th>Czesc kapitalowa</th>"
            + "<th>Rata</th>"
            + "<th>Pozostalo</th>"
            + "</tr>";


    public Repayment(Credit credit) {

        this.valueOfCredit = credit.getValueOfCredit();
        this.numberOfInstallments = credit.getNumberOfInstallments();
        this.percent = credit.getPercent() / 100 / 12;

        installment = valueOfCredit * Math.pow(1 + percent, numberOfInstallments)
                * percent / (Math.pow(1 + percent, numberOfInstallments) - 1);

    }

    public StringBuilder enumConstansInstallment(){

        saldo = valueOfCredit;

        for(n=1; n<=numberOfInstallments; n++){
            capital = valueOfCredit * percent * Math.pow(1+percent, n-1)
                    /(Math.pow(1+percent, numberOfInstallments)-1);

            interest = installment-capital;

            left = saldo - capital;
            if(installment>saldo){
                installment = saldo;
                capital = installment - interest;
            }

            stringBuilder.append("<tr><td>"+n+"</td><td>"+round2(saldo)
                    +"</td><td>"+round2(interest)
                    +"</td><td>"+round2(capital)
                    +"</td><td>"+round2(installment)
                    +"</td><td>"+round2(left)
                    +"</td></tr>");

            saldo = left;

            if(n%50==0 && n!=numberOfInstallments){
                stringBuilder.append(headers);
            }
        }
        return stringBuilder;
    }

    public StringBuilder enumDegresInstallment(){

        saldo = valueOfCredit;
        capital = valueOfCredit / numberOfInstallments;


        for(n=1; n<=numberOfInstallments; n++){

            interest = saldo * percent;
            installment = capital+interest;
            left = saldo - capital;

            if(installment>=saldo){
                valueOfCredit = saldo - interest;
            }

            stringBuilder.append("<tr><td>"+n+"</td><td>"+round2(saldo)
                    +"</td><td>"+round2(interest)
                    +"</td><td>"+round2(capital)
                    +"</td><td>"+round2(installment)
                    +"</td><td>"+round2(left)
                    +"</td></tr>");

            saldo = left;

            if(n%50==0 && n!=numberOfInstallments){
                stringBuilder.append(headers);
            }
        }
        return stringBuilder;
    }

    public double round2(double a){
        a = Math.round(a*100d)/100d;
        return a;
    }

}
