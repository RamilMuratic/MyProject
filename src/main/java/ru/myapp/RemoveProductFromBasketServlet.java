package ru.myapp;

import ru.myapp.shopcart.BasketService;
import ru.myapp.clothes.Clothes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/remove")
public class RemoveProductFromBasketServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

       Integer id = Integer.valueOf(request.getParameter("id"));

        Object myBasket = request.getSession().getAttribute(ServletHelper.SESSION_ATTRIBUTE_CLOTHES_SERVICE);

        BasketService.removeFromBasket((int) id, (List<Clothes>) myBasket);

        RequestDispatcher rd = request.getRequestDispatcher("/viewBasket");
        rd.include(request, response);

    }

}
