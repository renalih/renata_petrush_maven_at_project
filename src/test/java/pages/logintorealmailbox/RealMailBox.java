/*
package pages.logintorealmailbox;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BookingBasePage;

public class RealMailBox extends BookingBasePage {

    private static final String LOGIN_EMAIL_FIELD_XPATH = "//input[@id='username']";
    private static final String LOGIN_PASSWORD_FIELD_XPATH = "//input[@id='password']";
    private static final String SUBMIT_LOGIN_XPATH = "//button[@type='submit']";
    private static final String BOOKING_EMAIL_XPATH = "//span[text()='Booking.com'][1]";
    private static final String BOOKING_LOGO_XPATH =
            "//span[@data-testid='message-header-expanded:From']//span[text()='Booking.com']";

    public void logIn(String username, String password) {
        driver.findElement(By.xpath(LOGIN_EMAIL_FIELD_XPATH)).sendKeys(username);
        driver.findElement(By.xpath(LOGIN_PASSWORD_FIELD_XPATH)).sendKeys(password);
        driver.findElement(By.xpath(SUBMIT_LOGIN_XPATH)).click();
    }

    public void openBookingEmail() {
        driver.findElement(By.xpath(BOOKING_EMAIL_XPATH)).click();
        WebElement logoBooking = driver.findElement(By.xpath(BOOKING_LOGO_XPATH));
        Assert.assertTrue("Mail from Booking is not opened!", logoBooking.isDisplayed());
    }
}
*/
