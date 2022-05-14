package tasks.homework_week10;

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

import java.util.concurrent.TimeUnit;

public class BookingCurrencyTest {

    private static WebDriver driver;

    @Before
    public void driverInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("started-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void checkCurrencyHint() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        WebElement currencyButton = driver.findElement(By.xpath
                ("//button[@data-modal-header-async-type='currencyDesktop']//span[@class='bui-button__text']/span[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(currencyButton).build().perform();
        WebElement currencyTooltip = driver.findElement(By.xpath
                ("//button[@data-modal-header-async-type='currencyDesktop']//span[@class='bui-u-sr-only']"));
        String actualTooltipText = currencyTooltip.getText();
        System.out.println("Actual text of currency hint is " + actualTooltipText);
        Assert.assertEquals("Actual text of currency tooltip isn't corresponded expected!",
                "Выберите валюту. Текущая валюта — Польский злотый", actualTooltipText);

        WebElement languageTooltip = driver.findElement(By.xpath
                ("//button[@data-bui-component='Modal,Tooltip']//span[@class='bui-u-sr-only']"));
        actions.moveToElement(languageTooltip).build().perform();
        String languageTooltipText = languageTooltip.getText();
        Assert.assertEquals("Actual text of clanguage tooltip isn't corresponded expected!",
                "Выберите язык. Текущий язык — На русском", languageTooltipText);
    }

    @After
    public void driverFinish() {
        driver.close();
    }
}