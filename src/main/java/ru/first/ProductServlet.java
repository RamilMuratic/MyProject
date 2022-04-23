package ru.first;

import ru.first.product.Product;
import ru.first.product.ProductService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String NAME = "name";

    public static final String CATEGORY = "category";
    public static final String PRICE = "price";

    private Map<String, Product> products = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        products = ProductService.getAll();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String productName = request.getParameter(NAME);
        Product foundProduct = products.get(productName);

        System.out.println(request.getSession().getId());

        ServletHelper.populateHtmlBegin(response);

        if (foundProduct != null) {
            response.getWriter().append("<p> Name: " + foundProduct.getName() + " Category " +
                    foundProduct.getCategory() + " Price: " + foundProduct.getPrice() + "</p>");

            response.getWriter().append("<p><a href=\"./addToBasket?name="  + foundProduct.getName() + "\">Add to basket</a></p>");
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

        Product product = new Product(pName, Double.valueOf(pPrice), pCategory);
        ProductService.add(product);

        ServletHelper.populateHtmlBegin(response);
        response.getWriter().append("<p>New product added!</p>");
        ServletHelper.populateHtmlEnd(response);
    }


}
