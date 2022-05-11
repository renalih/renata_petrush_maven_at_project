package classwork18;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingMain {

    public static void main(String[] args) {

        WebDriver driver = Driver.getWebDriver();

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        WebElement city = driver.findElement(By.id("ss"));
        city.clear();
        city.sendKeys("Париж");
        driver.findElement(By.xpath("//span[text()='Париж']")).click();
        driver.findElement(By.xpath("//button[@class='sb-searchbox__button ']")).click();

        List<WebElement> listHotels = driver.findElements(By.xpath("//div[@data-testid='property-card']"));
        int numberHotels = listHotels.size();
        System.out.println("Number of hotels on page is " + numberHotels);

    }
}
