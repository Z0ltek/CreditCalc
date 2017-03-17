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
            + "<th>Miesiąc</th>"
            + "<th>Saldo</th>"
            + "<th>Część odsetkowa</th>"
            + "<th>Część kapitałowa</th>"
            + "<th>Rata</th>"
            + "<th>Pozostało</th>"
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

            stringBuilder.append("<tr><td>"+n+"</td><td>"+saldo
                                +"</td><td>"+interest
                                +"</td><td>"+capital
                                +"</td><td>"+installment
                                +"</td><td>"+left
                                +"</td><td>");

            saldo = left;

            if(n%12==0 && n!=numberOfInstallments){
                stringBuilder.append(headers);
            }


        }
        return stringBuilder;
    }

    public StringBuilder enumDegresInstallment(){

        saldo = valueOfCredit;

        capital = valueOfCredit / numberOfInstallments;
        interest = valueOfCredit * percent;
        installment = valueOfCredit = interest;
        left = saldo - valueOfCredit;


        stringBuilder.append("<tr><td>"+n+"</td><td>"+saldo
                +"</td><td>"+interest
                +"</td><td>"+capital
                +"</td><td>"+installment
                +"</td><td>"+left
                +"</td><td>");

        saldo = left;


        for(n=2; n<=numberOfInstallments; n++){

            interest = left = valueOfCredit;

            left = saldo - valueOfCredit;

            if(installment>=saldo){
                valueOfCredit = saldo - interest;
            }

            installment = valueOfCredit+interest;


            stringBuilder.append("<tr><td>"+n+"</td><td>"+saldo
                    +"</td><td>"+interest
                    +"</td><td>"+capital
                    +"</td><td>"+installment
                    +"</td><td>"+left
                    +"</td><td>");

            saldo = left;

            if(n%12==0 && n!=numberOfInstallments){
                stringBuilder.append(headers);
            }

        }

        return stringBuilder;
    }

}
