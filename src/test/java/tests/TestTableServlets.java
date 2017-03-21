package tests;

import org.junit.Test;
import org.mockito.Mockito;
import servlets.TableServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Szymon on 2017-03-21.
 */
public class TestTableServlets extends Mockito {

    @Test
    public void servlets_should_not_show_table_when__all_value_is_null() throws IOException, ServletException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        TableServlet servlet = new TableServlet();

        when(request.getParameter("value")).thenReturn(null);
        when(request.getParameter("pc")).thenReturn(null);
        when(request.getParameter("numberOf")).thenReturn(null);

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlets_should_not_show_table_when_value_of_credit_is_null() throws IOException, ServletException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        TableServlet servlet = new TableServlet();

        when(request.getParameter("value")).thenReturn(null);
        when(request.getParameter("pc")).thenReturn("5");
        when(request.getParameter("numberOf")).thenReturn("57");

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlets_should_not_show_table_when_percent_is_null() throws IOException, ServletException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        TableServlet servlet = new TableServlet();

        when(request.getParameter("value")).thenReturn("80000");
        when(request.getParameter("pc")).thenReturn(null);
        when(request.getParameter("numberOf")).thenReturn("57");

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

    @Test
    public void servlets_should_not_show_table_when_number_of_installemnts_is_null() throws IOException, ServletException{
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        TableServlet servlet = new TableServlet();

        when(request.getParameter("value")).thenReturn("80000");
        when(request.getParameter("pc")).thenReturn("5");
        when(request.getParameter("numberOf")).thenReturn(null);

        servlet.doPost(request, response);

        verify(response).sendRedirect("/");
    }

}
