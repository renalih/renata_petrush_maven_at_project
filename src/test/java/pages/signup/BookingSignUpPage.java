package pages.signup;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BookingSignUpPage {

    private static final String EMAIL_FIELD_XPATH = "//input[@type='email']";
    private static final String SUBMIT_EMAIL_XPATH = "//button[@type='submit']";
    private static final String PASSWORD_FIELD_XPATH ="//input[@name='new_password']";
    private static final String CONFIRM_PASSWORD_FIELD_XPATH ="//input[@name='confirmed_password']";
    private static final String CREATE_ACCOUNT_BUTTON_XPATH = "//button[@type='submit']";

    public static void main(String[] args) {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//nav[@class='bui-header__bar']//div[@class='bui-group__item'][5]")).click();
        driver.findElement(By.xpath(EMAIL_FIELD_XPATH)).sendKeys("rolfson.carlotta@trashmail.fr");
        driver.findElement(By.xpath(SUBMIT_EMAIL_XPATH)).click();
        driver.findElement(By.xpath(PASSWORD_FIELD_XPATH)).sendKeys("QAZwsxEDC123");
        WebElement repeatPassword = driver.findElement(By.xpath(CONFIRM_PASSWORD_FIELD_XPATH));
        repeatPassword.click();
        repeatPassword.sendKeys("QAZwsxEDC123");
        driver.findElement(By.xpath(CREATE_ACCOUNT_BUTTON_XPATH)).click();

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated
                        (By.xpath("//div[@id='px-captcha']")));


        WebElement keepHold = driver.findElement(By.xpath("//div[@role='button']//div[@aria-label]"));
        Actions make = new Actions(driver);
        make.moveToElement(keepHold);
        make.clickAndHold(keepHold).build().perform();
    }


}
