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
    <form method="post" action="library.jsp" novalidate>
        <p>
            <label for="title">Titel*</label>
            <input type="text" id="title" required>
        </p>
        <p>
            <label for="ontwikkelaar">Ontwikkelaar*</label>
            <input type="text" id="ontwikkelaar" required>
        </p>
        <p>
            <label for="releasedate">Release*</label>
            <input type="date" id="releasedate" required>
        </p>
        <p>
            <label for="score">Beoordeling</label>
            <input type="number" id="score" placeholder="Op 5" min="1" max="5">
        </p>
        <p>
            <label for="age">Leeftijdcategorie</label>
            <input type="number" id="age">
        </p>
        <p>
            <label for="prijs">Prijs*</label>
            <input type="number" id="prijs" required>
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
