import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class cypressTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://todomvc-app-for-testing.surge.sh/");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addTodo(){
        //WebElement addTodo = driver.findElement(By.cssSelector("#root > div > header > input"));
        //addTodo.sendKeys("Clean Room");
        WebElement addTodo2 = driver.findElement(By.tagName("input"));
        addTodo2.sendKeys("Clean kitchen");
        WebElement toggle = driver.findElement(By.cssSelector("#root > div > header > input"));

        assert (toggle.isEnabled());
       /** WebElement credential = driver.findElement(RelativeLocator.with(
                By.tagName("span")
        ).above(loginPanel));
        System.out.println(credential.getText());
        */
    }
/*
    @Test
    public void testListOfElement(){
        List<WebElement> allSocialMedia = driver.findElements(with(
                By.tagName("img"))
                .near(By.id("footer")));

        for (WebElement socialMedia : allSocialMedia){
            System.out.println(socialMedia.getAttribute("alt"));
        }
    }
    */

}
