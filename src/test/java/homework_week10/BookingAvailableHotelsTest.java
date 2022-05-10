package homework_week10;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.concurrent.TimeUnit;

public class BookingAvailableHotelsTest {

    private static WebDriver driver;

    @Before
    public void driverInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkAvailableHotels() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click(); //accepting cookie
        driver.findElement(By.id("ss")).sendKeys("London");
        driver.findElement(By.xpath("//span[text()='London']")).click();

        LocalDate dateFrom = LocalDate.now(ZoneId.systemDefault()).plusDays(10);
        LocalDate dateTo = dateFrom.plusDays(2);
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateFrom))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateTo))).click();

        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        String headText = driver.findElement(By.xpath("//h1")).getText().replaceAll("\\D", "");
        int numberHotels = Integer.parseInt(headText);
        System.out.println("Number of available hotels is " + numberHotels);

        Assert.assertTrue("No available hotels for selected dates", numberHotels > 0);
    }

    @After
    public void driverFinish() {
        driver.close();
    }
}
