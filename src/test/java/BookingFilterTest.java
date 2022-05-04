
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingFilterTest {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.id("ss")).sendKeys("Париж");
        driver.findElement(By.xpath("//span[text()='Париж']")).click();

        LocalDate dateFrom = LocalDate.now(ZoneId.systemDefault()).plusDays(3);
        LocalDate dateTo = dateFrom.plusDays(7);

        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateFrom))).click();
        driver.findElement(By.xpath(String.format("//td[@data-date='%s']", dateTo))).click();


        driver.findElement(By.xpath("//label[@id='xp__guests__toggle']")).click();
        WebElement addAdultButton = driver.findElement(By.xpath
                ("//span[@id='group_adults_desc']//preceding-sibling::button[1]"));
        addAdultButton.click();
        addAdultButton.click();

        WebElement addRoomButton = driver.findElement(By.xpath
                ("//span[@id='no_rooms_desc']//preceding-sibling::button[1]"));
        addRoomButton.click();

        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//div[@data-testid='overlay-spinner']")));

        WebElement filterMaxPrice = driver.findElement(By.xpath
                ("//div[@id='searchboxInc']//div[@data-filters-group='pri']//div[contains(text(), '+')]"));
        int expectedMaxPrice = Integer.parseInt(filterMaxPrice.getText().replaceAll("\\D+", ""));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", filterMaxPrice);
        filterMaxPrice.click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//div[@data-testid='overlay-spinner']")));

        driver.findElement(By.xpath("//li[@data-id='price']")).click();

        WebElement actualHotelPrice = driver.findElement(By.xpath
                ("//div[@data-testid='property-card'][1]//div[@data-testid='price-and-discounted-price']/span[1]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", actualHotelPrice);
        int actualPeriodPrice = Integer.parseInt(actualHotelPrice.getText().replaceAll("\\D+", ""));
        int actualMaxPrice = actualPeriodPrice / 7;

        System.out.println("Expected hotel price per night is " + expectedMaxPrice);
        System.out.println("Actual hotel price per night is " + actualMaxPrice);

        Assert.assertTrue("Actual price per night is lower than expected!",
                actualMaxPrice >= expectedMaxPrice);

        driver.close();
    }
}
