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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingRatingTest {

    private static WebDriver driver;

    @Before
    public void driverInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkMaxRatingHotel() {
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

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.findElement(By.xpath("//div[@data-filters-item='review_score:review_score=90']")).click();

        WebElement firstHotel = driver.findElement(By.xpath
                ("//div[@data-testid='property-card'][1]//div[@data-testid='title']"));
        firstHotel.click();

        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);

/*        Actions make = new Actions(driver);
        make.moveToElement(firstHotel).doubleClick().build().perform();*/

        WebElement hotelRating = driver.findElement(By.xpath
                ("//div[@id='js--hp-gallery-scorecard']//div[contains(@aria-label, '9')]"));
        double actualHotelRating = Double.parseDouble(hotelRating.getText().replaceAll("\\D", ""));
        System.out.println("Actual rating of selected hotel is " + actualHotelRating);

    }

/*    @After
    public void driverFinish() {
        driver.close();
    }*/
}

