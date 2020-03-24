<%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 10/03/2020
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Game Toevoegen | Steam</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<%@include file="header.jsp"%>
<main>
    <form method="post" action="GamesInfo?command=voegToe" novalidate>
        <p>
            <label for="titel">Titel*</label>
            <input type="text" id="titel" name="titel" required>
        </p>
        <p>
            <label for="ontwikkelaar">Ontwikkelaar*</label>
            <input type="text" id="ontwikkelaar" name="ontwikkelaar" required>
        </p>
        <p>
            <label for="release">Release*</label>
            <input type="date" id="release" name="release" required>
        </p>
        <p>
            <label for="score">Score</label>
            <input type="number" id="score" name="score" placeholder="Op 5" min="1" max="5">
        </p>
        <p>
            <label for="leeftijd">Leeftijdcategorie</label>
            <input type="number" id="leeftijd" name="leeftijd">
        </p>
        <p>
            <label for="prijs">Prijs*</label>
            <input type="number" id="prijs" name="prijs" required>
        </p>
        <p>
            <input type="submit" value="Toevoegen">
        </p>
    </form>
</main>
<%@include file="footer.jsp"%>
</body>
</html>
