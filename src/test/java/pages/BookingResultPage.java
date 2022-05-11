package pages;

import org.openqa.selenium.By;

public class BookingResultPage extends BookingBasePage{

    private static final String PROPERTY_CARD_XPATH = "//div[@data-testid='property-card']";

    public int getResults() {
        return driver.findElements(By.xpath(PROPERTY_CARD_XPATH)).size();
    }
}
