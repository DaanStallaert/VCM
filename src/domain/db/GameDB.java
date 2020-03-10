package domain.db;

import domain.model.Game;

import java.time.LocalDate;
import java.util.ArrayList;

public class GameDB {
    ArrayList<Game> games;

    public Game cod = new Game("Modern Warfare", "Activision", LocalDate.of(2019, 9,2), 4.5, 18, 60);
    public Game fallout = new Game("Fallout 4", "Bethesda", LocalDate.of(2017, 5, 19), 3.5, 18, 40);
    public Game fifa = new Game("Fifa 20", "EA Sports", LocalDate.of(2019, 10, 10), 4, 3, 50);

    public GameDB() {
        games = new ArrayList<>();
        games.add(cod);
        games.add(fallout);
        games.add(fifa);
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public String berekenBesteGame(){
        String result = "";
        double max = 0;
        for(Game g:games){
            if(g.getBeoordeling() > max){
                max = g.getBeoordeling();
                result = g.getTitel();
            }
        }
        return result;
    }

    public void voegGameToe(Game g){
        games.add(g);
    }
}
