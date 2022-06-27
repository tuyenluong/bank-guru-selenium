package Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
import static Actions.GlobalConstants.LONG_TIMEOUT;

public abstract class AbstactTest {

    protected enum Browser{
        CHROME, FIREFOX, HEADLESSCHROME, HEADLESSFRIREFOX;
    }

    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    protected WebDriver getBrowsersDriver(String browserName){
        Browser browser = Browser.valueOf(browserName.toUpperCase());

        switch (browser){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                threadLocal.set(new ChromeDriver());
                break;
            case HEADLESSCHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsCh = new ChromeOptions();
                optionsCh.setHeadless(true);
                threadLocal.set(new ChromeDriver(optionsCh));
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                threadLocal.set(new FirefoxDriver());
                break;
            case HEADLESSFRIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions optionsFr = new FirefoxOptions();
                optionsFr.setHeadless(true);
                threadLocal.set(new FirefoxDriver(optionsFr));
                break;
            default:
                throw new RuntimeException("Please choose browser name!");
        }
        threadLocal.get().get(GlobalConstants.BANK_URL);
        threadLocal.get().manage().timeouts().implicitlyWait(waitDuration(LONG_TIMEOUT));
        return threadLocal.get();
    }

    protected Duration waitDuration(long seconds){
        return Duration.ofSeconds(seconds);
    }

    protected void removeBrowserDriver(){
        threadLocal.get().quit();
        threadLocal.remove();
    }
}
