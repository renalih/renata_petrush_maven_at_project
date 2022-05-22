package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public static WebDriver getDriver(Config config) throws MalformedURLException {
        switch (config) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            case REMOTE:
                return getRemoteDriver();
            default:
                throw null;
        }
    }

    private static WebDriver getEdgeDriver() {
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

    private static WebDriver getRemoteDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
        RemoteWebDriver webDriver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), options);
        return webDriver;
    }
}

