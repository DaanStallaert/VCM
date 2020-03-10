package ui.controller;

import domain.db.GameDB;
import domain.model.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/GamesInfo")
public class GamesInfo extends HttpServlet {

    GameDB games = new GameDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("games", games.getGames());
        request.setAttribute("berekenWaarde", games.berekenBesteGame());

        RequestDispatcher view = request.getRequestDispatcher("library.jsp");
        view.forward(request, response);
    }
}
