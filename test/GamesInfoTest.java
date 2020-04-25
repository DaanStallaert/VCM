import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

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
}
