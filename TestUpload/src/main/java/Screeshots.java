import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screeshots {
    WebDriver driver;
    public static void main(String[] args)
    {

        WebDriverManager.chromedriver().setup();
        // Setting webDriver to chrome
        System.setProperty("webdriver.chrome.driver",
                "driver path");
        driver = new ChromeDriver();
        driver.get("https://www.google.co.in");

        WebElement Element = driver.findElement(
                By.xpath("//input[@name='q']"));

        // Assignments to webDriver
        MakeBorder(Element);
        try {
        Thread.sleep(2000);

            TakeScreenshot("GooglePage");
        }catch(Exception e) {}
        driver.quit();
    }

    // Function to Take screenshot
    public static void TakeScreenshot(String FileName)
            throws IOException
    {
        // Creating instance of File
        File File = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(File,
                new File("image location"
                        + FileName + ".jpeg"));
    }

    // Function to Make border
    public static void MakeBorder(WebElement Element)
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.border = '3px solid red'",
                Element);
    }
}

