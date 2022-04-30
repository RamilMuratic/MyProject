package ru.first;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/midle")
public class ServletMidle extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("<p>I'm in the middle!!!!</p>");

        System.out.println("ServletMidle is running!");

        RequestDispatcher rd =  req.getRequestDispatcher("/end");
        rd.forward(req, resp);
    }
}
