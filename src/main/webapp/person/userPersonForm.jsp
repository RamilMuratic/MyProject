<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>User Info</title>
</head>
<body>
<p>Name: <%= request.getParameter("name") %></p>
<p>Age: <%= request.getParameter("age") %></p>

<p><a href=".\userPersonSendForm.jsp">Return back!</a></p>
</body>
</html>
