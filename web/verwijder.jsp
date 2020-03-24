<%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 23/03/2020
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Home | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="header.jsp"%>
<main id="verwijder">
    <p>Weet je zeker dat je <strong><%= request.getParameter("titel")%></strong> wilt verwijderen?</p>
    <form action="GamesInfo?command=bevestigVerwijder" method="post">
        <input type="hidden" value="<%= request.getParameter("titel")%>" name="titel">
        <input type="submit" value="Ja" name="submit">
        <input type="submit" value="Nee" name="submit">
    </form>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
