package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GenericUtils;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DepartmentAreaPage {

    public WebDriver driver;
    private String keyToCount = "SL No.";
    Path excelFilePath = Paths.get(System.getProperty("user.dir"), "DepartmentName.xlsx");
    private By organizationDropDownLink = By.xpath("//a[@class='p-element p-ripple ng-tns-c35-10 ng-star-inserted']");
    private By departmentAreaLink = By.xpath("//span[contains(text(), 'Department Search')]");
    private By createNewDepartmentButton = By.xpath("//button[@class='p-element p-button p-component']//span[contains(text(), 'Create New Department')]");
    private By departmentNameText = By.xpath("//input[@id='depName']");
    private By createButtonPath = By.xpath("//button[@class='p-ripple p-element p-button p-component']//span[contains(text(), 'Create')]");
    private By closeButtonPath = By.xpath("//button[@class='p-element action-button p-button p-component ng-star-inserted']//span[contains(text(), 'Close')]");
    private By searchButtonPath = By.xpath("//button[@class='p-element search-button p-button p-component']//span[contains(text(), 'Search')]");

    public DepartmentAreaPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnDepartmentAreaLink(){
        driver.findElement(departmentAreaLink).click();
    }
    public void openDepartmentArea() throws InterruptedException {
        driver.findElement(organizationDropDownLink).click();
        Thread.sleep(4000);
        clickOnDepartmentAreaLink();
    }

    public void clickOnCreateDepartmentButton() throws InterruptedException {
        driver.findElement(createNewDepartmentButton).click();
        Thread.sleep(2000);
    }

    public void enterDepartmentName(String departmentName){
        driver.findElement(departmentNameText).sendKeys(departmentName);
    }

    public void clickCreateButton(){
        driver.findElement(createButtonPath).click();
    }

    public void clickCloseButton(){
        driver.findElement(closeButtonPath).click();
    }

    public void clickOnSearchButton(){
        driver.findElement(searchButtonPath).click();
    }

    public void verifyCreateNewDepartmentButtonEnable(){
        WebElement button = driver.findElement(createNewDepartmentButton);
        // Assert that the button is enabled
        if (!button.isEnabled()) {
            throw new AssertionError("The button is not enabled");
        }
    }

    public void createNewDepartment() throws InterruptedException {
        List<String> columnNames = List.of("SL No.", "DepartmentName");
        Map<String, List<Object>> data = GenericUtils.readExcel(excelFilePath, columnNames);
        int count = data.getOrDefault(keyToCount, new ArrayList<>()).size();
        for (int i = 0; i < count; i++){
            String departmentName = (String) data.get("DepartmentName").get(i);
            clickOnCreateDepartmentButton();
            Thread.sleep(2000);
            enterDepartmentName(departmentName);
            Thread.sleep(4000);
            clickCreateButton();
            Thread.sleep(4000);
            clickCloseButton();
            Thread.sleep(4000);
            clickOnDepartmentAreaLink();
            Thread.sleep(4000);
            clickOnSearchButton();
            Thread.sleep(4000);
        }
    }

}
