import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
//import org.junit.Test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.time.Duration;


public class Upload {

    WebDriver driver;

    @Before
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void uploadFile() throws Exception {
        String filename = "some-test.txt";
        File file = new File(filename);
        String path = file.getAbsolutePath();
        driver.get("http://the-internet.herokuapp.com/upload");
        driver.findElement(By.id("file-upload")).sendKeys(path);
        driver.findElement(By.id("file-submit")).click();
        String text = driver.findElement(By.id("uploaded-files")).getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertThat(text, is(equalTo(filename)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


}
