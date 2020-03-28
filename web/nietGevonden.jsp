<%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 23/03/2020
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Niet Gevonden | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="zoek"/>
</jsp:include>
<body>
<main>
    <p>
        Helaas, <strong>${titel}</strong> werd niet gevonden. <a href="GamesInfo?command=opnieuwZoeken">Opnieuw zoeken.</a>
    </p>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="actual" value="zoek"/>
</jsp:include>
</body>
</html>
