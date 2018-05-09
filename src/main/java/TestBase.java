import UrlBuilder.Url;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testLogger.ConsoleLogger;
import testLogger.Logger;

public class TestBase {
    protected Logger logger;
    protected ChromeDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {

        System.out.println("Before Part starts");
        logger = new ConsoleLogger();
        log("Creating webdriver instance");
        driver = new ChromeDriver();
        log("Setting window size");
        this.driver.manage().window().maximize();
        String urlString = new Url.UrlBuilder("rabota.ua")
                .withHttps(true)
                .withResource("")
                .build()
                .getUrl();

        log("Navigate to URL - rabota.ua");
        driver.get(urlString);
        log("Wait for title to be Работа в Украине. Трудоустройство и поиск работы на rabota.ua");
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("Работа в Украине. Трудоустройство и поиск работы на rabota.ua"));
    }


    @After
    public void tearDown() {

        log("Terminating Webdriver");
        driver.quit();
    }

    protected void log(String text) {
        logger.log(text);
    }

}



