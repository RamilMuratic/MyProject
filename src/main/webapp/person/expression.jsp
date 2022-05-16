<%@ page pageEncoding="UTF-8" %>

<%!

int square(int m) {
 return m * m;
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Подсчет площади</title>
</head>
<body>

Всем привет!!!

<jsp:include page="returnBack.jsp" />


<ul>
<%
for(int i=0 ; i < 100; i++) {
out.println("<li> Square for " + i  + " = " + square(i)  + "</li>");
}
%>
</ul>
</body>
</html>
