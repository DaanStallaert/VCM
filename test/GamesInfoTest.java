import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GamesInfoTest {
    ChromeDriver driver;
    String url = "http://localhost:8080/";

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\Documenten\\School\\Brol\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clear(){
        driver.quit();
    }

    public boolean containsWebelement(ArrayList<WebElement> elements, String tekst){
        for(WebElement element:elements){
            if(element.getText().equals(tekst)){
                return true;
            }
        }
        return false;
    }

    @Test
    public void test_GameToevoegen_alles_invullen_gaat_naar_library_en_toont_nieuwe_game_in_tabel(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("Warzone");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("IW");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("05041998");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("4");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("18");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("50");

        driver.findElement(By.id("toevoegen")).click();

        assertEquals("Library | Steam", driver.getTitle());
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelement(list, "Warzone"));
        assertTrue(containsWebelement(list, "IW"));
        assertTrue(containsWebelement(list, "1998-04-05"));
        assertTrue(containsWebelement(list, "4.0/5"));
        assertTrue(containsWebelement(list, "18+"));
        assertTrue(containsWebelement(list, "€50"));
    }

    @Test
    public void test_als_game_gezocht_die_niet_toegevoegd_is_geeft_nietGevonden(){
        driver.get(url + "zoek.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("blabla");

        driver.findElement(By.id("zoek")).click();

        assertEquals("Helaas, " + driver.findElement(By.tagName("strong")).getText() + " werd niet gevonden. Opnieuw zoeken.", driver.findElement(By.tagName("p")).getText());
    }

    @Test
    public void test_game_uit_constructor_wordt_gevonden(){
        driver.get(url + "zoek.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("modern warfare");

        driver.findElement(By.id("zoek")).click();

        assertEquals("Gevonden | Steam", driver.getTitle());
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelement(list, "Modern Warfare"));
        assertTrue(containsWebelement(list, "Activision"));
        assertTrue(containsWebelement(list, "2019-09-02"));
        assertTrue(containsWebelement(list, "4.5/5"));
        assertTrue(containsWebelement(list, "18+"));
        assertTrue(containsWebelement(list, "€60"));
    }


    @Test
    public void test_game_die_nieuw_toegevoegd_is_wordt_gevonden(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("Warzone");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("IW");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("05041998");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("4");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("18");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("50");

        driver.findElement(By.id("toevoegen")).click();

        driver.get(url + "zoek.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("warzone");

        driver.findElement(By.id("zoek")).click();

        assertEquals("Gevonden | Steam", driver.getTitle());
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelement(list, "Warzone"));
        assertTrue(containsWebelement(list, "IW"));
        assertTrue(containsWebelement(list, "1998-04-05"));
        assertTrue(containsWebelement(list, "4.0/5"));
        assertTrue(containsWebelement(list, "18+"));
        assertTrue(containsWebelement(list, "€50"));
    }

    @Test
    public void test_als_Lege_Game_Toegevoegd_Dan_Wordt_Formulier_Opnieuw_Getoond_met_alle_foutboodschappen(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("");

        driver.findElement(By.id("toevoegen")).click();

        assertEquals("Game Toevoegen | Steam", driver.getTitle());
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelement(list, "Titel mag niet leeg zijn."));
        assertTrue(containsWebelement(list, "Ontwikkelaar mag niet leeg zijn."));
        assertTrue(containsWebelement(list, "Release mag niet leeg zijn."));
        assertTrue(containsWebelement(list, "Leeftijd mag niet leeg zijn."));
        assertTrue(containsWebelement(list, "Prijs mag niet leeg zijn."));
    }

    @Test
    public void test_als_enkel_leeftijd_verkeerd_is_bevatten_overige_velden_vorige_waarde(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("Warzone");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("IW");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("05041998");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("4");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("50");

        driver.findElement(By.id("toevoegen")).click();


        assertEquals("Game Toevoegen | Steam", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelement(lis, "Leeftijd mag niet leeg zijn."));
        assertEquals("Warzone", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("IW", driver.findElement(By.id("ontwikkelaar")).getAttribute("value"));
        assertEquals("1998-04-05", driver.findElement(By.id("release")).getAttribute("value"));
        assertEquals("4", driver.findElement(By.id("score")).getAttribute("value"));
        assertEquals("50", driver.findElement(By.id("prijs")).getAttribute("value"));
    }

    @Test
    public void test_als_enkel_score_leeg_is_word_library_getoond_met_score_0(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("Fifa 19");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("IW");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("05041998");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("18");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("50");

        driver.findElement(By.id("toevoegen")).click();


        assertEquals("Library | Steam", driver.getTitle());
        ArrayList<WebElement> list = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelement(list, "Warzone"));
        assertTrue(containsWebelement(list, "IW"));
        assertTrue(containsWebelement(list, "1998-04-05"));
        assertTrue(containsWebelement(list, "0.0/5"));
        assertTrue(containsWebelement(list, "18+"));
        assertTrue(containsWebelement(list, "€50"));
    }

    @Test
    public void test_als_bestaande_game_wordt_toegevoegd_wordt_formulier_met_bijhorende_foutboodschap_getoond(){
        driver.get(url + "gameToevoegen.jsp");

        WebElement naam = driver.findElement(By.id("titel"));
        naam.clear();
        naam.sendKeys("Modern Warfare");

        WebElement voornaam = driver.findElement(By.id("ontwikkelaar"));
        voornaam.clear();
        voornaam.sendKeys("Activision");

        WebElement release = driver.findElement(By.id("release"));
        release.clear();
        release.sendKeys("09022019");

        WebElement studierichting = driver.findElement(By.id("score"));
        studierichting.clear();
        studierichting.sendKeys("4.5");

        WebElement leeftijd = driver.findElement(By.id("leeftijd"));
        leeftijd.clear();
        leeftijd.sendKeys("18");

        WebElement prijs = driver.findElement(By.id("prijs"));
        prijs.clear();
        prijs.sendKeys("60");

        driver.findElement(By.id("toevoegen")).click();

        assertEquals("Game Toevoegen | Steam", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelement(lis, "Deze game is al toegevoegd."));
    }
}
