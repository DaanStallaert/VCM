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
    <title>Verwijder | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="library"/>
</jsp:include>
<main id="verwijder">
    <p>Weet je zeker dat je <strong>${titel}</strong> wilt verwijderen?</p>
    <form action="GamesInfo?command=bevestigVerwijder" method="post">
        <input type="hidden" value="${titel}" name="titel">
        <input type="submit" value="Ja" name="submit">
        <input type="submit" value="Nee" name="submit">
    </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="actual" value="library"/>
</jsp:include>
</body>
</html>
