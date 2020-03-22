package domain.db;

import domain.model.Game;

import java.nio.channels.FileLockInterruptionException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GameDB {
    private ArrayList<Game> games = new ArrayList<>();

    public GameDB() {
        this.voegGameToe(new Game("Modern Warfare", "Activision", LocalDate.of(2019, 9,2), 4.5, 18, 60));
        this.voegGameToe(new Game("Fifa 20", "EA Sports", LocalDate.of(2019, 10, 10), 4, 3, 50));
        this.voegGameToe(new Game("Fallout 4", "Bethesda", LocalDate.of(2017, 5, 19), 3.5, 18, 40));
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public String berekenBesteGame(){
        String result = "";
        double max = 0;
        if(games.size() == 0){
            return null;
        }
        for(Game g:games){
            if(g.getBeoordeling() > max){
                max = g.getBeoordeling();
                result = g.getTitel();
            }
        }
        return result;
    }

    public void voegGameToe(Game g){
        if(g == null){
            throw new IllegalArgumentException("Game mag niet leeg zijn");
        }
        for(Game game:games){
            if(game.getTitel().equals(g.getTitel())){
                throw new IllegalArgumentException("Deze game is al toegevoegd.");
            }
        }
        games.add(g);
    }
}
