import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class Screenshot {
    WebDriver driver;

    @Before
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }



    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description) {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile,
                        new File("failshot_"
                                + description.getClassName()
                                + "_" + description.getMethodName()
                                + ".png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };


    @Test
    public void OnError() {
        driver.get("http://the-internet.herokuapp.com");
        assertThat(false, is(true));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
