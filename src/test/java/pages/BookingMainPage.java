/*
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookingMainPage extends BookingBasePage {

    private static final String SEARCH_FIELD_ID = "ss";
    private static final String SEARCH_BUTTON = "//button[@class='sb-searchbox__button ']";
    private static final String CITY_FROM_LIST = "//ul[@role='listbox']//li[1]";
    private static final String SIGH_UP_BUTTON = "//nav[@class='bui-header__bar']//div[@class='bui-group__item'][5]";


    public void searchCity(String cityName) {

        WebElement city = driver.findElement(By.id(SEARCH_FIELD_ID));
        city.clear();
        city.sendKeys(cityName);

        driver.findElement(By.xpath(CITY_FROM_LIST)).click();
        driver.findElement(By.xpath(SEARCH_BUTTON)).click();

    }

    public void goSignUp() {
        driver.findElement(By.xpath(SIGH_UP_BUTTON)).click();
    }

}
*/
