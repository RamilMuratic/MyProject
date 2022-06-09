package ru.myapp;

import ru.myapp.clothes.Clothes;
import ru.myapp.clothes.ClothesService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = "/addToBasket")
public class AddBasketClothesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";

    private ClothesService ps = null;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ps  = (ClothesService)getServletContext().getAttribute(ServletHelper.SC_ATTRIBUTE_CLOTHES_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);

        Clothes selectClothes = ps.get(pName);

        Object myBasket = request.getSession().getAttribute(ServletHelper.SESSION_ATTRIBUTE_CLOTHES_SERVICE);
        if (myBasket !=null) {
            List<Clothes> list = (List<Clothes>)myBasket;
            list.add(selectClothes);
        } else {
            List<Clothes> list = new ArrayList();
            list.add(selectClothes);
            request.getSession().setAttribute(ServletHelper.SESSION_ATTRIBUTE_CLOTHES_SERVICE, list);
        }

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>Product Added to basket!<p>");
        ServletHelper.populateHtmlEnd(response);
    }

}
