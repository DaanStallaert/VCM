<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="gameToevoegen"/>
</jsp:include>
<main>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>
    <form method="post" action="GamesInfo?command=voegToe" novalidate>
        <p>
            <label for="titel">Titel*</label>
            <input type="text" id="titel" name="titel" value="${vorigeTitel}" required>
        </p>
        <p>
            <label for="ontwikkelaar">Ontwikkelaar*</label>
            <input type="text" id="ontwikkelaar" name="ontwikkelaar" value="${vorigeOntwikkelaar}" required>
        </p>
        <p>
            <label for="release">Release*</label>
            <input type="date" id="release" name="release" value="${vorigeRelease}" required>
        </p>
        <p>
            <label for="score">Score</label>
            <input type="number" id="score" name="score" value="${vorigeScore}" placeholder="Op 5" min="1" max="5">
        </p>
        <p>
            <label for="leeftijd">Leeftijdcategorie*</label>
            <input type="number" id="leeftijd" name="leeftijd" value="${vorigeLeeftijd}" required>
        </p>
        <p>
            <label for="prijs">Prijs*</label>
            <input type="number" id="prijs" name="prijs" value="${vorigePrijs}" required>
        </p>
        <p>
            <input type="submit" id="toevoegen" value="Toevoegen">
        </p>
    </form>
</main>
<jsp:include page="footer.jsp">
    <jsp:param name="actual" value="gameToevoegen"/>
</jsp:include>
</body>
</html>
