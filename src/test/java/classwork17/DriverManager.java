package classwork17;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    public static WebDriver getDriver(Config config) {
        switch (config) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw null;
        }
    }

    private static WebDriver getEdgeDriver() {
        //TODO
        return null;
    }

    private static WebDriver getFirefoxDriver() {
        return null;
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }
}
