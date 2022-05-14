package tasks.homework_week11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class Precondition {

    private static final String EMAIL_NAME_XPATH = "//input[@id='fe-mob-name']";
    private static final String EMAIL_DOMEN_XPATH = "//select[@id='fe-mob-domain']//option[@selected='selected']";
    private static final String REAL_EMAIL_XPATH = "//input[@id='fe-mob-forward']";
    private static final String REAL_EMAIL_VALUE = "renapeta@protonmail.com";
    private static final String NUMBER_OF_FORWARDS_XPATH = "//select[@id='fe-mob-fwd-nb']";
    private static final String LIFE_SPAN_XPATH = "//select[@id='fe-mob-life-span']";
    private static final String CREATE_EMAIL_XPATH = "//button[@id='fe-mob-submit']";


    private static final String LOGIN_EMAIL_FIELD_XPATH = "//input[@id='username']";
    private static final String LOGIN_PASSWORD_FIELD_XPATH = "//input[@id='password']";
    private static final String PASSWORD_VALUE = "Renapeta!2022";
    private static final String SUBMIT_LOGIN_XPATH = "//button[@type='submit']";
    private static final String BOOKING_EMAIL_XPATH = "//span[text()='Booking.com'][1]";
    private static final String BOOKING_LOGO_XPATH =
            "//span[@data-testid='message-header-expanded:From']//span[text()='Booking.com']";



    public static void main(String[] args) {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        //First precondition
//        driver.get("https://trashmail.com");
//
//        String emailName = driver.findElement(By.xpath(EMAIL_NAME_XPATH)).getAttribute("value");
//
//        String domenName = driver.findElement(By.xpath(EMAIL_DOMEN_XPATH)).getText();
//
//        String tempEmail = emailName + domenName;
//
//        driver.findElement(By.xpath(REAL_EMAIL_XPATH)).sendKeys(REAL_EMAIL_VALUE);
//
//        Select selectNumberOfForwards = new Select(driver.findElement(By.xpath(NUMBER_OF_FORWARDS_XPATH)));
//        selectNumberOfForwards.selectByValue("1");
//
//        Select selectLifeSpanButton = new Select(driver.findElement(By.xpath(LIFE_SPAN_XPATH)));
//        selectLifeSpanButton.selectByVisibleText("1 day");
//
//        driver.findElement(By.xpath(CREATE_EMAIL_XPATH)).click();
//
//        String createdEmail = driver.findElement(By.xpath("//h4")).getText();
//
//        Assert.assertTrue("Created email address is different from the generated temporary email!",
//                createdEmail.contains(tempEmail));


        //Second precondition

        driver.get("https://mail.protonmail.com");

/*        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//circle")));*/

        driver.findElement(By.xpath(LOGIN_EMAIL_FIELD_XPATH)).sendKeys(REAL_EMAIL_VALUE);
        driver.findElement(By.xpath(LOGIN_PASSWORD_FIELD_XPATH)).sendKeys(PASSWORD_VALUE);
        driver.findElement(By.xpath(SUBMIT_LOGIN_XPATH)).click();
        driver.findElement(By.xpath(BOOKING_EMAIL_XPATH)).click();
        WebElement logoBooking = driver.findElement(By.xpath(BOOKING_LOGO_XPATH));
        Assert.assertTrue("Mail from Booking is not opened!", logoBooking.isDisplayed());

        //span[text()='Booking.com'][1]
        //"td.button-inner"


    }
}
