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
<main id="index">
  <p>Een overzicht van al mijn games. Ik kan ze zelf beoordelen, de prijs bijhouden, ... </p>
  <p>
    Het best beoordeelde spel is: <strong><%= ((String) request.getAttribute("besteScore")) %></strong>
  </p>
</main>
<%@include file="footer.jsp"%>
</body>
</html>