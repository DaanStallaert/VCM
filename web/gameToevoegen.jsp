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
<header>
    <h1>
        <a href="index.jsp">Steam</a>
    </h1>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a id="markeer" href="gameToevoegen.jsp">Game toevoegen</a></li>
            <li><a href="GamesInfo">Library</a></li>
        </ul>
    </nav>
</header>
<main>
    <form method="post" action="GamesInfo" novalidate>
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
<footer>
    <p>Webontwikkeling 2 - 2020 || Copyright © 2019 Daan Stallaert</p>
</footer>
</body>
</html>
