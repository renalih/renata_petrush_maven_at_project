package tasks.homework_week10;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoqaSelectTest {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/select-menu");

        WebElement selectOption = driver.findElement(By.xpath("//div[text()='Select Option']"));
        Actions make = new Actions(driver);
        make.click(selectOption).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        WebElement selectTitle = driver.findElement(By.xpath("//div[text()='Select Title']"));
        make.click(selectTitle).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));
        selectColor.selectByVisibleText("White");

        WebElement selectDots = driver.findElement(By.xpath("//div[text()='Select...']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", selectDots);
        make.click(selectDots).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

        Select selectCar = new Select(driver.findElement(By.id("cars")));
        selectCar.selectByVisibleText("Audi");

        driver.close();
    }
}