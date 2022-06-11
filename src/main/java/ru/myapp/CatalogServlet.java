package ru.myapp;

import ru.myapp.clothes.Clothes;
import ru.myapp.clothes.ClothesService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import static ru.myapp.ViewBasketServlet.TABLE_BEGIN;
import static ru.myapp.ViewBasketServlet.TABLE_END;

@WebServlet(urlPatterns = "/catalog")
public class CatalogServlet extends HttpServlet {
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String PRICE = "price";
    private static final String SIZE = "size";
    private static final String COLOR = "color";
    private static final String PRODUCING_COUNTRY = "producingCountry";

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        ClothesService aaa = new ClothesService();
        Map<String, Clothes> s =  aaa.getAll();

        ServletHelper.populateHtmlBegin(response);

      response.getWriter().append("<p>CATALOG:</p>");

      response.getWriter().append(TABLE_BEGIN);
        for (Map.Entry<String, Clothes> str: s.entrySet()) {
            Clothes p = str.getValue();

            response.getWriter().append("<tr>\n" +
                    "    <td>  " + p.getName() + "       </td>\n" +
                    "    <td>  " + p.getCategory() + "  </td> \n" +
                    "    <td>  " + p.getPrice() + "     </td>\n" +
                    "    <td>  " + p.getSize() + "      </td>\n" +
                    "    <td>  " + p.getColor() + "     </td>\n" +
                    "    <td>  " + p.getProducingCountry() + "      </td>\n" +
                    "    <td><a href= \"./addToBasket?name=" + p.getName()  + "\">Add</a></td>\n" +
                    "  </tr>");

        }
      response.getWriter().append(TABLE_END);

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
        ClothesService cl = new ClothesService();
        cl.add(clothes);

        ServletHelper.populateHtmlBegin(response);

        response.getWriter().append("<p>New product added!</p>");
        response.getWriter().append("<p><a href=\"./clothesAdd.html\">HA3AD</a></p>");

        ServletHelper.populateHtmlEnd(response);
    }

}
