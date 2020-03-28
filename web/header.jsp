<%--
  Created by IntelliJ IDEA.
  User: daans
  Date: 23/03/2020
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <h1>
        <a href="GamesInfo?command=index">Steam</a>
    </h1>
    <nav>
        <ul>
            <li ${param.actual eq 'index'?"id = actual":""}>
                <a href="GamesInfo?command=index">Home</a></li>
            <li ${param.actual eq 'gameToevoegen'?"id = actual":""}>
                <a href="GamesInfo?command=gameToevoegen">Game toevoegen</a></li>
            <li ${param.actual eq 'library'?"id = actual":""}>
                <a href="GamesInfo?command=library">Library</a></li>
            <li ${param.actual eq 'zoek'?"id = actual":""}>
                <a href="GamesInfo?command=zoekPagina">Zoek</a></li>
        </ul>
    </nav>
</header>
