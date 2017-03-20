package model;

import java.io.FileOutputStream;
import java.io.Reader;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by Szymon on 2017-03-17.
 */

public class PDFcreator extends HttpServlet{

    public PDFcreator(HttpServletRequest req, HttpServletResponse resp,
                      Reader reader) {

        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = null;
        resp.setContentType("application/pdf");
        document.open();


        try{
            writer = PdfWriter.getInstance(document, resp.getOutputStream());
            document.open();
            document.add(new Paragraph(new Date().toString()));
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, reader);

        }catch(Exception e){

            e.printStackTrace();
        }
        document.close();
    }

}
