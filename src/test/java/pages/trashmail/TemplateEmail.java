/*
package pages.trashmail;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.BookingBasePage;

public class TemplateEmail extends BookingBasePage {


    public static String newTempEmail;
    private static final String EMAIL_NAME_XPATH = "//input[@id='fe-mob-name']";
    private static final String EMAIL_DOMEN_XPATH = "//select[@id='fe-mob-domain']//option[@selected='selected']";
    private static final String REAL_EMAIL_XPATH = "//input[@id='fe-mob-forward']";
    private static final String NUMBER_OF_FORWARDS_XPATH = "//select[@id='fe-mob-fwd-nb']";
    private static final String LIFE_SPAN_XPATH = "//select[@id='fe-mob-life-span']";
    private static final String CREATE_EMAIL_XPATH = "//button[@id='fe-mob-submit']";

    public void getTempEmail () {
        String emailName = driver.findElement(By.xpath(EMAIL_NAME_XPATH)).getAttribute("value");
        String domenName = driver.findElement(By.xpath(EMAIL_DOMEN_XPATH)).getText();
        newTempEmail = emailName + domenName;
    }

    public void fillInRealEmailField (String realEmail) {
        driver.findElement(By.xpath(REAL_EMAIL_XPATH)).sendKeys(realEmail);
    }

    public void setNumberOfForwards () {
        Select selectNumberOfForwards = new Select(driver.findElement(By.xpath(NUMBER_OF_FORWARDS_XPATH)));
        selectNumberOfForwards.selectByValue("1");
    }

    public void setLifeSpanField () {
        Select selectLifeSpanButton = new Select(driver.findElement(By.xpath(LIFE_SPAN_XPATH)));
        selectLifeSpanButton.selectByVisibleText("1 day");
    }

    public void submitEmailCreation () {
        driver.findElement(By.xpath(CREATE_EMAIL_XPATH)).click();
        String createdEmail = driver.findElement(By.xpath("//h4")).getText();
        Assert.assertTrue("Created email address is different from the generated temporary email!",
                createdEmail.contains(newTempEmail));
        System.out.println("New template email address is " + newTempEmail);
    }

}
*/
