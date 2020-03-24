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
<%@include file="header.jsp"%>
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
        <%
            Game gevondenGame = (Game) request.getAttribute("gevondenGame");
        %>
        <tr>
            <td><%=gevondenGame.getTitel()%></td>
            <td><%=gevondenGame.getOntwikkelaar()%></td>
            <td><%=gevondenGame.getRelease()%></td>
            <td><%=gevondenGame.getScore()%></td>
            <td><%=gevondenGame.getLeeftijd()%></td>
            <td><%=gevondenGame.getPrijs()%></td>
            <td><a href="gameToevoegen.jsp">Pas aan</a></td>
            <td><a href="GamesInfo?command=verwijder&titel=<%=gevondenGame.getTitel()%>">Verwijder</a></td>
        </tr>
        </tbody>
    </table>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
