package extensions;

import configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import services.Services;

public class Driver {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebDriverWait> threadWait = new ThreadLocal<WebDriverWait>();

    private static WebDriverWait getWait() {
        return threadWait.get();
    }

    private static void setWait(WebDriverWait wait) {
        Driver.threadWait.set(wait);
    }

    private static WebDriver getDriver() {
        return threadDriver.get();
    }

    private static void setDriver(WebDriver value) {
        threadDriver.set(value);
    }

    public static void init() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().get(Services.urls.main);

        setWait(new WebDriverWait(getDriver(), Config.waitTimeout));
    }

    public static void quit() {
        getDriver().quit();
    }

    private static WebElement waitForVisible(PageElement element) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(element.by));
    }

    private static WebElement waitForActive(PageElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element.by));
    }

    public static void sendKeys(PageElement element, String text) {
        waitForActive(element).sendKeys(text);
    }

    public static void selectText(PageElement element, String domain) {
        Select selectElement = new Select(waitForVisible(element));
        selectElement.selectByVisibleText(domain);
    }

    public static void click(PageElement element) {
        waitForActive(element).click();
    }

    public static Boolean isDisplayed(PageElement element) {
        return waitForVisible(element).isDisplayed();
    }

    public static Boolean containsText(PageElement element, String text) {
        return waitForVisible(element).getText().contains(text);
    }
}