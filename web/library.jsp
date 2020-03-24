<%@ page import="domain.model.Game" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 5/03/2020
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Library | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <table>
        <thead>
        <tr>
            <th>Titel:</th>
            <th>Ontwikkelaar:</th>
            <th>Release:</th>
            <th>Score:</th>
            <th>Leeftijd:</th>
            <th>Prijs:</th>
            <th>Pas aan</th>
            <th>Verwijder</th>
        </tr>
        </thead>
        <tbody>
        <%
            ArrayList<Game> alleGames = (ArrayList<Game>) request.getAttribute("alleGames");
            for(Game game : alleGames) {
        %>
        <tr>
            <td><%=game.getTitel()%></td>
            <td><%=game.getOntwikkelaar()%></td>
            <td><%=game.getRelease()%></td>
            <td><%=game.getScore()%></td>
            <td><%=game.getLeeftijd()%></td>
            <td><%=game.getPrijs()%></td>
            <td><a href="gameToevoegen.jsp">Pas aan</a></td>
            <td><a href="GamesInfo?command=verwijder&titel=<%=game.getTitel()%>">Verwijder</a></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
