import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;

public class SampleTest {

    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(SampleTest.class);

    @Test
    public void Log(){
        logger.info("Info");
    }

    @Before
    public void setUp(){

        ChromeOptions options = new ChromeOptions();

        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

        System.setProperty("webdriver.chrome.silentOutput", "true");

        options.addArguments("--headless", "--silent");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        logger.info("Драйвер поднят");
    }

    @Test
    public void openPage(){
        driver.get("https://otus.ru");
        logger.info("Открыта страница otus.ru");


    }


    @After
    public void setDown() {
        if (driver != null) {
            driver.quit();

            logger.info("Драйвер остановлен");
        }
    }

}
