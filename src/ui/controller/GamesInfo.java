package ui.controller;

import domain.DomainException;
import domain.db.GameDB;
import domain.model.Game;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.DateTimeException;
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
            case "gameToevoegen" :
            destination = gameToevoegen(request);
                break;
            case "zoekPagina" :
            destination = zoekPagina(request);
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

    private String gameToevoegen(HttpServletRequest request){
        return "gameToevoegen.jsp";
    }

    private String zoekPagina(HttpServletRequest request){
        return "zoek.jsp";
    }

    private String zoek(HttpServletRequest request){
        String titel = request.getParameter("titel");

        if(titel == null){
            return "nietGevonden.jsp";
        }
        else{
            Game gevondenGame = games.vindGame(titel);
            if(gevondenGame == null){
                request.setAttribute("titel", titel);
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
        ArrayList<String> errors = new ArrayList<>();
        
        Game game = new Game();
        setTitel(game, request, errors);
        setOnwikkelaar(game, request, errors);
        setRelease(game, request, errors);
        setScore(game, request, errors);
        setLeeftijd(game, request, errors);
        setPrijs(game, request, errors);

        if(errors.size()==0){
            if(games.vindGame(game.getTitel()) != null){
                errors.add("Deze game is al toegevoegd.");
            }
            else{
                try {
                    games.voegGameToe(game);
                    return library(request);
                } catch(IllegalArgumentException e) {
                    errors.add(e.getMessage());
                }
            }
        }
        request.setAttribute("errors", errors);
        return "gameToevoegen.jsp";
    }

    private void setTitel(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String titel = request.getParameter("titel");

        try{
            game.setTitel(titel);
            request.setAttribute("vorigeTitel", titel);
        } catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setOnwikkelaar(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String ontwikkelaar = request.getParameter("ontwikkelaar");

        try{
            game.setOntwikkelaar(ontwikkelaar);
            request.setAttribute("vorigeOntwikkelaar", ontwikkelaar);
        } catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setRelease(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String release = request.getParameter("release");

        try{
            game.setRelease(LocalDate.parse(release));
            request.setAttribute("vorigeRelease", release);
        }catch(DateTimeException e){
            errors.add("Release mag niet leeg zijn.");
        }
        catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setScore(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String score = request.getParameter("score");

        try{
            game.setScore(Integer.parseInt(score));
            request.setAttribute("vorigeScore", score);
        }
        catch(NumberFormatException e){
        }
        catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setLeeftijd(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String leeftijd = request.getParameter("leeftijd");

        try{
            game.setLeeftijd(Integer.parseInt(leeftijd));
            request.setAttribute("vorigeLeeftijd", leeftijd);
        } catch(NumberFormatException e){
            errors.add("Leeftijd mag niet leeg zijn.");
        }
        catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private void setPrijs(Game game, HttpServletRequest request, ArrayList<String> errors) {
        String prijs = request.getParameter("prijs");

        try{
            game.setPrijs(Integer.parseInt(prijs));
            request.setAttribute("vorigePrijs", prijs);
        } catch(NumberFormatException e){
            errors.add("Prijs mag niet leeg zijn.");
        }
        catch(DomainException e){
            errors.add(e.getMessage());
        }
    }

    private String verwijder(HttpServletRequest request){
        String titel = request.getParameter("titel");
        request.setAttribute("titel", titel);
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
