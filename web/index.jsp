<!DOCTYPE html>
<html lang="nl">
<head>
  <meta charset="UTF-8">
  <title>Home | Steam</title>
  <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp">
  <jsp:param name="actual" value="index"/>
</jsp:include>
<main id="index">
  <p>Een overzicht van al mijn games. Ik kan ze zelf beoordelen, de prijs bijhouden, ... </p>
  <p>
    Het best beoordeelde spel is: <strong>${besteScore}</strong>
  </p>
</main>
<jsp:include page="footer.jsp">
  <jsp:param name="actual" value="index"/>
</jsp:include>
</body>
</html>