package servlets;
import credit.Credit;
import model.Repayment;

import java.io.IOException;

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
            resp.getWriter().println("Hello!POST0");
            value = Double.parseDouble(req.getParameter("formValueOfCredit"));
            pc = Double.parseDouble(req.getParameter("formNumberOfInstalments"));
            numberOf = Integer.parseInt(req.getParameter("formInterest"));
            resp.getWriter().println("Hello!POST0afterTry");

        } catch ( Exception e){
            resp.getWriter().println("Hello!POST1");
//            resp.sendRedirect("/");

        }

        if(value > 100 || numberOf > 1 || pc > 0 ){
            resp.getWriter().println("Hello!Post2");

            Credit credit = new Credit();
            credit.setNumberOfInstallments(numberOf);
            credit.setPercent(pc);
            credit.setValueOfCredit(value);

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
                    + ( req.getParameter("typeOfInstalments").equals("rowne") ?
                    repayment.enumConstansInstallment() : repayment.enumDegresInstallment())
                    + "</table>"
                    + "</body>"
                    + "</html>");

//            resp.getWriter().println(stringBuilder);


//            Reader reader = new StringReader(stringBuilder.toString());
//
//            if (request.getParameter("generate") != null){
//                new PDFcreator(request, response, reader);
//            }
//            else {
//                PrintWriter out = resp.getWriter();
//                out.println(stringBuilder);
//                out.close();
            }
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("asd");
    }

    }
