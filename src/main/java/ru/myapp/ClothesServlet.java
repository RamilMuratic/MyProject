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
import java.util.Map;


@WebServlet(urlPatterns = {"/clothes"})
public class ClothesServlet extends HttpServlet {

    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    private static final String SIZE = "size";
    private static final String COLOR = "color";
    private static final String PRODUCING_COUNTRY = "producingCountry";

    private ClothesService clothesInit = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        clothesInit = (ClothesService) getServletContext().getAttribute(ServletHelper.SC_ATTRIBUTE_CLOTHES_SERVICE);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String clothesName = request.getParameter(NAME);

            Clothes foundClothes = clothesInit.getAll().get(clothesName);

            ServletHelper.populateHtmlBegin(response);

            if (foundClothes != null) {
                response.getWriter().append("<p> Name: " + foundClothes.getName() + " Category " +
                        foundClothes.getCategory() + " Price: " + foundClothes.getPrice() + "</p>");
                response.getWriter().append("<p><a href=\"./addToBasket?name=" + foundClothes.getName() + "\">Add to basket</a></p>");
            } else {
                response.getWriter().append("<p>Unknown product<p>");
            }

            ServletHelper.populateHtmlEnd(response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String pName = request.getParameter(NAME);
        String pCategory = request.getParameter(CATEGORY);
        String pPrice = request.getParameter(PRICE);
        String pSize = request.getParameter(SIZE);
        String pColor = request.getParameter(COLOR);
        String pProducingCountry = request.getParameter(PRODUCING_COUNTRY);

        Clothes clothes = new Clothes(pName, Double.valueOf(pPrice), pCategory, pSize, pColor, pProducingCountry);
        clothesInit.add(clothes);

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>New product added!</p>");
        response.getWriter().append("<p><a href=\"./clothesAdd.html\">HA3AD</a></p>");

        ServletHelper.populateHtmlEnd(response);
    }

}
