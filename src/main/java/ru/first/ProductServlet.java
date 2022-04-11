package ru.first;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Random;

@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {

        System.out.println(">>>>>>Starting HelloServlet");
    }

    public ProductServlet() {
        System.out.println("Running");
    }

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String productName = request.getParameter("name");

        response.setContentType("text/html");
        response.setCharacterEncoding("Cp1251");

        if ("kefir".equals(productName)) {
            response.getWriter().append("<html><head>\n" +

                    "    <meta charset=\"UTF-8\">\n" +
                    "</head><body><p>Kefir price 100р</p><p><a href=\"./\">Return back</a></p></body></html>");
        } else if ("milk".equals(productName)) {
            response.getWriter().append("<html><head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "</head><body>Milk price 90р<p><a href=\"./\">Return back</a></p></body></html>");
        } else {
            response.getWriter().append("<html><head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "</head><body>Unknown product<p><a href=\"./\">Return back</a></p></body></html>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Random r = new Random();

        System.out.println("HelloServlet is invoking");
        response.getWriter().append("Hello! This random number: " + r.nextInt());
    }
}
