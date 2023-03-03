import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropDown {

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
    public void dropDownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        WebElement dropdownlist = driver.findElement(By.id("dropdown"));

        List<WebElement> options = dropdownlist.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++){
            if (options.get(i).getText().equals("Option 1")){
                options.get(i).click();
            }
        }
        String selectedOption = "";
        for(int i = 0; i < options.size(); i++){
            if (options.get(i).isSelected()){
                selectedOption = options.get(i).getText();
            }
        }
        assertThat(selectedOption, is("Option 1"));
    }

}
