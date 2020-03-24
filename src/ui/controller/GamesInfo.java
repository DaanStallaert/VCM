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
import java.util.ArrayList;

@WebServlet("/GamesInfo")
public class GamesInfo extends HttpServlet {

    private GameDB games = new GameDB();

    public GamesInfo(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = "index";

        if(request.getParameter("command") != null){
            command = request.getParameter("command");
        }
        switch(command) {
            case "index" :
                destination = index(request);
                break;
            case "library" :
                destination = library(request);
                break;
            case "zoek" :
                destination = zoek(request);
                break;
            case "opnieuwZoeken" :
                destination = opnieuwZoeken(request);
                break;
            case "voegToe" :
                destination = voegToe(request);
                break;
            case "verwijder" :
                destination = verwijder(request);
                break;
            case "bevestigVerwijder":
                destination = bevestigVerwijder(request);
                break;
            default :
                destination = index(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String index(HttpServletRequest request){
        request.setAttribute("besteScore", games.berekenBesteGame());
        return "index.jsp";
    }

    private String library(HttpServletRequest request){
        request.setAttribute("alleGames", games.getGames());
        return "library.jsp";
    }

    private String zoek(HttpServletRequest request){
        String titel = request.getParameter("titel");

        if(titel == null){
            return "nietGevonden.jsp";
        }
        else{
            Game gevondenGame = games.vindGame(titel);
            if(gevondenGame == null){
                return "nietGevonden.jsp";
            }
            else{
                request.setAttribute("gevondenGame", games.vindGame(titel));
                return "gevonden.jsp";
            }
        }
    }

    private String opnieuwZoeken(HttpServletRequest request){
        return "zoek.jsp";
    }

    private String voegToe(HttpServletRequest request){

        String titel = request.getParameter("titel");
        String ontwikkelaar = request.getParameter("ontwikkelaar");
        String release = request.getParameter("release");
        String score = request.getParameter("score");
        String leeftijd = request.getParameter("leeftijd");
        String prijs = request.getParameter("prijs");

        if(!titel.isEmpty() && !ontwikkelaar.isEmpty() && !release.isEmpty() && !score.isEmpty() && !leeftijd.isEmpty() && !prijs.isEmpty()){
            Game game = new Game(titel, ontwikkelaar, LocalDate.parse(release), Double.parseDouble(score), Integer.parseInt(leeftijd), Integer.parseInt(prijs));
            games.voegGameToe(game);
            return library(request);
        }
        else{
            return "gameToevoegen.jsp";
        }
    }

    private String verwijder(HttpServletRequest request){
        return "verwijder.jsp";
    }

    private String bevestigVerwijder(HttpServletRequest request){

        if(request.getParameter("submit").equals("Ja")){
            String game = request.getParameter("titel");
            Game g = games.vindGame(game);
            games.verwijderGame(g);
        }
        return library(request);
    }
}
