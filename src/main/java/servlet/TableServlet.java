package servlet;
import credit.Credit;
import model.Repayment;
import model.PDFcreator;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by Szymon on 2017-03-17.
 */

@WebServlet("/tablaaaaa")
public class TableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private double valueOfCredit;
    private double percent;
    private int numberOfInstallments;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            valueOfCredit = Double.parseDouble(req.getParameter("formValueOfCredit").replace(",","."));
            percent = Double.parseDouble(req.getParameter("formNumberOfInstalments").replace(",","."));
            numberOfInstallments = Integer.parseInt(req.getParameter("formInterest"));

        } catch ( Exception e){
            resp.sendRedirect("/");
        }

        if(valueOfCredit > 100 || numberOfInstallments > 1 || percent > 0 ){
            resp.sendRedirect("/");

            Credit credit = new Credit();
            credit.setNumberOfInstallments(numberOfInstallments);
            credit.setPercent(percent);
            credit.setValueOfCredit(valueOfCredit);

            Repayment repayment = new Repayment(credit);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");

            StringBuilder stringBuilder = new StringBuilder();


            stringBuilder.append(""
                    + "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" "
                    + "\"http://www.w3.org/TR/html4/loose.dtd\">"
                    + "<html>"
                    + "<head>"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>"
                    + "<title>Credit Calc</title>"
                    + "</head>"
                    + "<body>"
                    + "<br/><br/>"
                    + "<table class='t'>"
                    + "<tr>"
                    + "<th>Miesiąc</th>"
                    + "<th>Saldo</th>"
                    + "<th>Część odsetkowa</th>"
                    + "<th>Część kapitałowa</th>"
                    + "<th>Rata</th>"
                    + "<th>Pozostało</th>"
                    + "</tr>"
                    + ( req.getParameter("typeOfInstalments").equals("constans") ?
                    repayment.enumConstansInstallment() : repayment.enumDegresInstallment())
                    + "</table>"
                    + "</body>"
                    + "</html>");

//            Reader reader = new StringReader(stringBuilder.toString());
//
//            if (request.getParameter("generate") != null){
//                new PDFcreator(request, response, reader);
//            }
//            else {
//                PrintWriter out = response.getWriter();
//                out.println(stringBuilder);
//                out.close();
            }
        }

    }
