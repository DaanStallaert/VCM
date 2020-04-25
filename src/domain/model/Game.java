package domain.model;

import domain.DomainException;

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
            throw new DomainException("Titel mag niet leeg zijn.");
        }
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setOntwikkelaar(String ontwikkelaar) {
        if(ontwikkelaar == null || ontwikkelaar.trim().isEmpty()){
            throw new DomainException("Ontwikkelaar mag niet leeg zijn.");
        }
        this.ontwikkelaar = ontwikkelaar;
    }

    public String getOntwikkelaar() {
        return ontwikkelaar;
    }

    public void setScore(double score) {
        if(score > 5 || score < 0){
            throw new DomainException("Score moet tussen 0 en 5 liggen.");
        }
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setLeeftijd(int leeftijd) {
        if(leeftijd < 1){
            throw new DomainException("Leeftijd moet positief zijn");
        }
        this.leeftijd = leeftijd;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setPrijs(int prijs) {
        if(prijs < 0){
            throw new DomainException("Prijs moet positief zijn.");
        }
        this.prijs = prijs;
    }

    public int getPrijs() {
        return prijs;
    }

    public void setRelease(LocalDate release) {
        if(release.isAfter(LocalDate.now())){
            throw new DomainException("Release kan niet in de toekomst zijn.");
        }
        this.release = release;
    }

    public LocalDate getRelease() {
        return release;
    }
}
