<%
String name = request.getParameter("uname");
out.print("Welcome! " + name);
%>

<jsp:include page="returnBack.jsp" />

