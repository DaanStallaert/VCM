<%@ page import="domain.model.Game" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 23/03/2020
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gevonden | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="zoek"/>
</jsp:include>
<body>
<main>
    <table>
        <thead>
        <tr>
            <th>Titel</th>
            <th>Ontwikkelaar</th>
            <th>Release</th>
            <th>Score</th>
            <th>Leeftijd</th>
            <th>Prijs</th>
            <th>Pas aan</th>
            <th>Verwijder</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${gevondenGame.titel}</td>
            <td>${gevondenGame.ontwikkelaar}</td>
            <td>${gevondenGame.release}</td>
            <td>${gevondenGame.score}</td>
            <td>${gevondenGame.leeftijd}</td>
            <td>${gevondenGame.prijs}</td>
            <td><a href="gameToevoegen.jsp">Pas aan</a></td>
            <td><a href="GamesInfo?command=verwijder&titel=${gevondenGame.titel}">Verwijder</a></td>
        </tr>
        </tbody>
    </table>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="actual" value="zoek"/>
</jsp:include>
</body>
</html>
