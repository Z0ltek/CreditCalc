package model;

import java.io.FileOutputStream;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Created by Szymon on 2017-03-17.
 */

public class PDFcreator extends HttpServlet{



    public PDFcreator(HttpServletRequest req, HttpServletResponse resp,
                      Reader reader) {


        Document document = new Document(PageSize.A4);
        PdfWriter writer = null;
        document.open();
        Date currentDate = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");
        String dataString = dataFormat.format(currentDate);
        dataString = dataString.replace(":","_");


        try{
            writer = PdfWriter.getInstance(document, new FileOutputStream(dataString+"_Kredyt.pdf"));
            document.open();
            document.addAuthor("Szymon Zoltowski");
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, reader);
            document.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
