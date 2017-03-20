package servlets;
import credit.Credit;
import model.Repayment;
import model.PDFcreator;

import java.io.IOException;
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

@WebServlet("/tabela")
public class TableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private double value;
    private double pc;
    private int numberOf;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
//            resp.getWriter().println("Hello!POST0");
            value = Double.parseDouble(req.getParameter("formValueOfCredit").replace(",", "."));
            pc = Double.parseDouble(req.getParameter("formInterest").replace(",", "."));
            numberOf = Integer.parseInt(req.getParameter("formNumberOfInstalments"));
//            resp.getWriter().println("Hello!POST0afterTry");

        } catch ( Exception e){
//            resp.getWriter().println("Hello!POST1");
            resp.sendRedirect("/");

        }

        if(value > 100 || numberOf > 1 || pc > 0 ){
//            resp.getWriter().println("Hello!Post2");

            Credit credit = new Credit();
            credit.setNumberOfInstallments(numberOf);
            credit.setPercent(pc);
            credit.setValueOfCredit(value);

            Repayment repayment = new Repayment(credit);

            resp.setContentType("text/html");
            resp.setCharacterEncoding("ISO-8859-2");

            StringBuilder stringBuilder = new StringBuilder();


            stringBuilder.append(""
                    + "<html>"
                    + "<head>"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-2\"/>"
                    + "<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\" />"
                    + "<title>Kalkulator kredytowy</title>"
                    + "<title>Credit Calc</title>"
                    + "</head>"
                    + "<body>"
                    + "<br/><br/>"
                    + "<table class='t'>"
                    + "<tr>"
                    + "<th>Miesiac</th>"
                    + "<th>Saldo</th>"
                    + "<th>Czesc odsetkowa</th>"
                    + "<th>Czesc kapitalowa</th>"
                    + "<th>Rata</th>"
                    + "<th>Pozostalo</th>"
                    + "</tr>"
                    + ( req.getParameter("typeOfInstalments").equals("malejace") ?
                    repayment.enumConstansInstallment() : repayment.enumDegresInstallment())
                    + "</table>"
                    + "</body>"
                    + "</html>");

            resp.getWriter().println(stringBuilder);


            Reader reader = new StringReader(stringBuilder.toString());

            if (req.getParameter("generate") != null){
                new PDFcreator(req, resp, reader);
            }
            else {

            }
                resp.getWriter().close();
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Prosze podaj dane...");
    }

    }
