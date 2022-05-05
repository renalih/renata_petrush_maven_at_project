import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3schoolsTest {

    private static WebDriver driver;

    @Before
    public void driverInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkTutorial() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

        //search and copy
        WebElement tutorialWord = driver.findElement(By.xpath("//h1/span[contains(text(), 'Tutorial')]"));
        Actions make = new Actions(driver);
        make
                .doubleClick(tutorialWord)
                .keyDown(Keys.COMMAND)
                .sendKeys("c")
                .keyUp(Keys.COMMAND)
                .build()
                .perform();

        //put in google search
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        make
                .click(searchField)
                .keyDown(Keys.COMMAND)
                .sendKeys("v")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        //checking search results
        List<WebElement> listTutorials = driver.findElements(By.xpath
                ("//div[contains(@class, 'g') and contains(., 'tutorial')]"));
        int resultsAmount = listTutorials.size();
        System.out.println("Number of tutorial results is " + resultsAmount);

        Assert.assertEquals("Amount of tutorials on page is incorrect!",8, resultsAmount);
    }

    @After
    public void driverFinish() {
        driver.close();
    }
}
