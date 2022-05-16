<%@ page import="ru.first.product.Product" %>
<html>
<body>
<%

Product product = (Product)session.getAttribute("lastFoundProduct");
out.print("Last found product: "+product);

%>
</body>
</html>
