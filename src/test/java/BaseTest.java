import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    BaseTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Education\\WebDriver\\chromedriver.exe");

        //TODO: remove this two strings, (remove options)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--blink-settings=imagesEnabled=false");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void driverExit(){
        driver.close();
        driver.quit();
    }
}
