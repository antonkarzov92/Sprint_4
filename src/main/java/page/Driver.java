package page;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver createDriver(String browser) {
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("chrome")) {
            // Создаем экземпляр ChromeDriver
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            // Создаем экземпляр FirefoxDriver
            driver = new FirefoxDriver();
        } else {
            System.out.println("Неподдерживаемый браузер: " + browser);
        }
        return driver;


    }

}
