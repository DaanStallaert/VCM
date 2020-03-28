<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.model.Game" %>
<%@ page import="java.util.ArrayList" %>
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
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="library"/>
</jsp:include>
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
        <c:forEach var="game" items="${alleGames}">
        <tr>
            <td>${game.titel}</td>
            <td>${game.ontwikkelaar}</td>
            <td>${game.release}</td>
            <td>${game.score}/5.0</td>
            <td>${game.leeftijd}+</td>
            <td>€${game.prijs}</td>
            <td><a href="gameToevoegen.jsp">Pas aan</a></td>
            <td><a href="GamesInfo?command=verwijder&titel=${game.titel}">Verwijder</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="actual" value="library"/>
</jsp:include>
</body>
</html>
