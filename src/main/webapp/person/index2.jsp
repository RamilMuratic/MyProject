<%@ page import="ru.first.product.ProductService, ru.first.product.Product, java.util.Map" %>

<html>
<body>
<%
  ProductService ps = (ProductService)application.getAttribute("productService");

   Map<String, Product> all = ps.getAll();

  Product foundP =  all.get(request.getParameter("name"));

  out.println(foundP);

   if(foundP != null)
     session.setAttribute("lastFoundProduct", foundP);

  %>

  <br><br><br>
<a href="second.jsp">second.jsp page</a>


<jsp:include page="returnBack.jsp" />



</body>
</html>