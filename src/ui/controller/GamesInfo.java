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

    private GameDB games = new GameDB();

    public GamesInfo(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("alleGames", games.getGames());
        request.setAttribute("berekenWaarde", games.berekenBesteGame());

        RequestDispatcher view = request.getRequestDispatcher("library.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = "gameToevoegen.jsp";

        String titel = request.getParameter("titel");
        String ontwikkelaar = request.getParameter("ontwikkelaar");
        String release = request.getParameter("release");
        String score = request.getParameter("score");
        String leeftijd = request.getParameter("leeftijd");
        String prijs = request.getParameter("prijs");

        if(titel != null && ontwikkelaar != null && release != null && score != null && leeftijd != null && prijs != null){
            if(!titel.isEmpty() && !ontwikkelaar.isEmpty() && !release.isEmpty() && !score.isEmpty() && !leeftijd.isEmpty() && !prijs.isEmpty()){
                Game game = new Game(titel, ontwikkelaar, LocalDate.parse(release), Double.parseDouble(score), Integer.parseInt(leeftijd), Integer.parseInt(prijs));
                games.voegGameToe(game);
                request.setAttribute("alleGames", games.getGames());
                request.setAttribute("berekenWaarde", games.berekenBesteGame());
                destination = "library.jsp";
            }
        }

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }
}
