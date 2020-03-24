<%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 24/03/2020
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zoek | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <form action="GamesInfo" method="get" novalidate>
        <p>
            <label for="titel">Titel: </label>
            <input type="text" id="titel" name="titel" required>
        </p>
        <input type="hidden" name="command" value="zoek">
        <p>
            <input type="submit" value="Zoek Game">
        </p>
    </form>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
