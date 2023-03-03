package javaExercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {

    public static void main (String [] args){
        WebDriver driver = new ChromeDriver();
        //Implicit Wait
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Explicit Wait
        //WebDriverWait wait = new WebDriverWait(driver, 3);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        // WebElement element = wait.until(
        //         ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/login']")));

        // DesiredCapabilities caps = DesiredCapabilities.firefox();
        ChromeOptions options = new ChromeOptions();
    }
}
