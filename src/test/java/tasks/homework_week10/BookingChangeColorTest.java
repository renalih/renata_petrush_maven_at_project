package tasks.homework_week10;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class BookingChangeColorTest {

    private static WebDriver driver;

    @Before
    public void driverInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        driver = new ChromeDriver(options);
    }

    @Test
    public void changeTextColor() {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("ss")).sendKeys("London");
        driver.findElement(By.xpath("//ul[@role='listbox']//li[1]")).click();

        LocalDate dateFrom = LocalDate.now(ZoneId.systemDefault()).plusDays(7);
        LocalDate dateTo = dateFrom.plusDays(5);
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateFrom))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateTo))).click();

        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        WebElement backgroundOfTenHotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", backgroundOfTenHotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'",
                backgroundOfTenHotel);

        WebElement textColor = driver.findElement
                (By.xpath("//div[@data-testid='property-card'][10]//*[@data-testid='title']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", textColor);

        String resultTextColor = textColor.getCssValue("color");

        Assert.assertEquals("Text color of 10th hotel from the list is not red!",
                "rgba(255, 0, 0, 1)", resultTextColor);
    }

    @After
    public void driverFinish() {
        driver.close();
    }
}
