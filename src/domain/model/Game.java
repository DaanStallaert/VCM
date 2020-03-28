package domain.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Game {
    String titel, ontwikkelaar;
    int leeftijd, prijs;
    double score;
    LocalDate release;


    public Game(String titel, String ontwikkelaar, LocalDate release, double score, int leeftijd, int prijs) {
        setTitel(titel);
        setOntwikkelaar(ontwikkelaar);
        setRelease(release);
        setScore(score);
        setLeeftijd(leeftijd);
        setPrijs(prijs);
    }

    public Game(){

    }

    public void setTitel(String titel) {
        if(titel == null || titel.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setOntwikkelaar(String ontwikkelaar) {
        if(ontwikkelaar == null || ontwikkelaar.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
        this.ontwikkelaar = ontwikkelaar;
    }

    public String getOntwikkelaar() {
        return ontwikkelaar;
    }

    public void setScore(double score) {
        if(score > 5 || score < 0){
            throw new IllegalArgumentException();
        }
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setLeeftijd(int leeftijd) {
        if(leeftijd < 1){
            throw new IllegalArgumentException();
        }
        this.leeftijd = leeftijd;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setPrijs(int prijs) {
        if(prijs < 0){
            throw new IllegalArgumentException();
        }
        this.prijs = prijs;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setRelease(LocalDate release) {
        if(release.isAfter(LocalDate.now())){
            throw new IllegalArgumentException();
        }
        this.release = release;
    }

    public LocalDate getRelease() {
        return release;
    }
}
