package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class LandingPage {

    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }
//    private By username = By.xpath("//input[@id='username']");
    private SelenideElement username = $(By.id("username"));
//    private By password = By.xpath("//input[@id='password']");
    private SelenideElement password = $(By.id("password"));
//    private By loginButton = By.xpath("//input[@id='kc-login']");
    private SelenideElement loginButton = $(By.id("kc-login"));

    public void enterUsername(String actualUserName){
        driver.findElement(username).sendKeys(actualUserName);
    }

    public void enterPassword(String actualPassword){
        driver.findElement(password).sendKeys(actualPassword);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }
}
