package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderArea {
    public WebDriver driver;
    public HeaderArea(WebDriver driver){
        this.driver = driver;
    }
    private By profileIcon = By.xpath("(//img[@class='profile-image ng-star-inserted'])[1]");
    private By logoutLink = By.xpath("//li[@class='layout-topbar-action-item ng-tns-c33-3']");

    public void clickProfileIcon(){
        driver.findElement(profileIcon).click();
    }
    public void clickLogout(){
        driver.findElement(logoutLink).click();
    }
}
