package tasks.homework_week11;

import driver.Driver;
import objects.TemplateEmail;
import pages.BookingBasePage;

public class TestDemo extends BookingBasePage {
    public static void main(String[] args) {
        TemplateEmail templateEmail = new TemplateEmail();
        Driver.getWebDriver().get("https://trashmail.com");
        templateEmail.getTempEmail();
        templateEmail.fillInRealEmailField("renapeta@protonmail.com");
        templateEmail.setNumberOfForwards();
        templateEmail.setLifeSpanField();
        templateEmail.submitEmailCreation();
    }
}
