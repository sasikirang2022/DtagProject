package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    private WebDriver driver;
    public WebDriver webDriverManager() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("QaUrl");
        String browser_properties = properties.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven : browser_properties;

        if(driver == null){
            if(browser.equalsIgnoreCase("chrome")){
                driver = new ChromeDriver();
            }
            if(browser.equalsIgnoreCase("firefox")){
                driver = new FirefoxDriver();
            }
            assert driver != null;
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
            driver.get(url);

        }
        return driver;
    }
}
