package homework_week10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        Select selectColor = new Select(driver.findElement(By.id("oldSelectMenu")));
        selectColor.selectByVisibleText("White");

        Select selectCar = new Select(driver.findElement(By.id("cars")));
        selectCar.selectByVisibleText("Audi");

        driver.close();
    }
}