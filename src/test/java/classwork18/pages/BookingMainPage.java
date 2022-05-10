package classwork18.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingMainPage extends BookingBasePage {

    private static final String SEARCH_FIELD_ID = "ss";
    private static final String SEARCH_BUTTON = "//button[@class='sb-searchbox__button ']";
    private static final String CITY_FROM_LIST = "//span[text()='Париж']";


    public void searchCity(String cityName) {

        WebElement city = driver.findElement(By.id(SEARCH_FIELD_ID));
        city.clear();
        city.sendKeys(cityName);

        driver.findElement(By.xpath(CITY_FROM_LIST)).click();
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();

    }
}
