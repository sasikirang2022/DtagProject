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

public class CompanyAreaPage {

    private static final String KEY_TO_COUNT = "SL No.";
    private static final String EXCEL_FILE_NAME = "CompanyName.xlsx";
    private static final long WAIT_TIME = 4; // in seconds

    private WebDriver driver;
    private Path excelFilePath = Paths.get(System.getProperty("user.dir"), EXCEL_FILE_NAME);
    private Map<String, List<Object>> data;

    private By searchButtonPath = By.xpath("//button[@class='p-element search-button p-button p-component']//span[contains(text(), 'Search')]");
    private By createNewCompanyButton = By.xpath("//button[@class='p-element p-button p-component']//span[contains(text(), 'Create New Company')]");
    private By companyNameText = By.xpath("//input[@id='companyName']");
    private By createButtonPath = By.xpath("//button[@class='p-ripple p-element p-button p-component']//span[contains(text(), 'Create')]");
    private By closeButtonPath = By.xpath("//button[@class='p-element action-button p-button p-component ng-star-inserted']//span[contains(text(), 'Close')]");
    private By companySearchBoxPath = By.xpath("//input[@formcontrolname='name']");
    private By editButtonPath = By.xpath("//button[@class='p-element action-button p-button p-component ng-star-inserted']//span[contains(text(), 'Edit')]");
    private By saveButtonPath = By.xpath("//button[@class='p-element action-button p-button p-component ng-star-inserted']//span[contains(text(), 'Save')]");
    private By companyDescriptionPath = By.xpath("//textarea[@id='Description']");
    private By downloadCompanyPath = By.xpath("//button[@class='p-element action-button p-button p-component ng-star-inserted']//span[contains(text(), 'Download Company')]");
    private By testSectionPath = By.xpath("//button[@class='p-element p-button-rounded p-button-text text-orange-800 p-button p-component p-button-icon-only']");
    public CompanyAreaPage(WebDriver driver) {
        this.driver = driver;
        this.data = readExcel();
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButtonPath).click();
    }

    public void verifyCreateNewCompanyButtonEnable() {
        verifyButtonEnabled(createNewCompanyButton);
    }

    public void clickOnCreateCompanyButton() {
        driver.findElement(createNewCompanyButton).click();
        waitForSeconds();
    }

    public void enterCompanyName(String companyName) {
        driver.findElement(companyNameText).sendKeys(companyName);
    }

    public void clickCreateButton() {
        driver.findElement(createButtonPath).click();
    }

    public void clickCloseButton() {
        driver.findElement(closeButtonPath).click();
    }
    public void enterCompanySearchBox(String companyName) {
        driver.findElement(companySearchBoxPath).sendKeys(companyName);
    }
    public void clickOnEditIcon(String companyName) {
        WebElement rowElement = driver.findElement(By.xpath("//*[contains(text(),'" + companyName + "')]/ancestor::tr[1]"));
        WebElement editIcon = rowElement.findElement(By.xpath(".//button[@title='Edit']"));
        editIcon.click();
    }
    public void clickOnEditButton() {
        driver.findElement(editButtonPath).click();
    }
    public void clickOnSaveButton() {
        driver.findElement(saveButtonPath).click();
    }
    public void enterCompanyDescriptionText(String companyDescription) {
        WebElement textArea = driver.findElement(companyDescriptionPath);
        textArea.clear();
        textArea.sendKeys(companyDescription);
    }
    public void removeTestAfterLogin(){
        driver.findElement(testSectionPath).click();
        waitForSeconds();
    }


    private Map<String, List<Object>> readExcel() {
        List<String> columnNames = List.of("SL No.", "CompanyName", "CompanyDescription");
        return GenericUtils.readExcel(excelFilePath, columnNames);
    }

    public void createNewCompany() {
        int count = data.getOrDefault(KEY_TO_COUNT, new ArrayList<>()).size();
        for (int i = 0; i < count; i++) {
            String companyName = (String) data.get("CompanyName").get(i);
            clickOnCreateCompanyButton();
            waitForSeconds();
            enterCompanyName(companyName);
            waitForSeconds();
            clickCreateButton();
            waitForSeconds();
            clickCloseButton();
            waitForSeconds();
            clickOnSearchButton();
            waitForSeconds();
        }
    }

    public void verifySaveButtonEnable() {
        int count = data.getOrDefault(KEY_TO_COUNT, new ArrayList<>()).size();
        for (int i = 0; i < count; i++) {
            String companyName = (String) data.get("CompanyName").get(i);
            enterCompanySearchBox(companyName);
            waitForSeconds();
            clickOnSearchButton();
            waitForSeconds();
            clickOnEditIcon(companyName);
            waitForSeconds();
            clickOnEditButton();
            waitForSeconds();
            verifyButtonEnabled(saveButtonPath);
            waitForSeconds();
            clickCloseButton();
            waitForSeconds();
            clickOnSearchButton();
        }

    }
    public void enterCompanyDescription() {
        int count = data.getOrDefault(KEY_TO_COUNT, new ArrayList<>()).size();
        for (int i = 0; i < count; i++) {
            String companyName = (String) data.get("CompanyName").get(i);
            String companyDescription = (String) data.get("CompanyDescription").get(i);
            enterCompanySearchBox(companyName);
            waitForSeconds();
            clickOnSearchButton();
            waitForSeconds();
            clickOnEditIcon(companyName);
            waitForSeconds();
            clickOnEditButton();
            waitForSeconds();
            enterCompanyDescriptionText(companyDescription);
            waitForSeconds();
            clickOnSaveButton();
            waitForSeconds();
            clickCloseButton();
            waitForSeconds();
            clickOnSearchButton();
        }
    }

    public void verifyEditAndDownloadCompanyButtonEnable() {
        int count = data.getOrDefault(KEY_TO_COUNT, new ArrayList<>()).size();
        for (int i = 0; i < count; i++) {
            String companyName = (String) data.get("CompanyName").get(i);
            String companyDescription = (String) data.get("CompanyDescription").get(i);
            enterCompanySearchBox(companyName);
            waitForSeconds();
            clickOnSearchButton();
            waitForSeconds();
            clickOnEditIcon(companyName);
            waitForSeconds();
            clickOnEditButton();
            waitForSeconds();
            enterCompanyDescriptionText(companyDescription);
            waitForSeconds();
            clickOnSaveButton();
            waitForSeconds();
            verifyButtonEnabled(editButtonPath);
            waitForSeconds();
            verifyButtonEnabled(downloadCompanyPath);
            waitForSeconds();
            clickCloseButton();
            waitForSeconds();
            clickOnSearchButton();
        }
    }

    public void verifyDepartmentNamesInListView(){
        int count = data.getOrDefault(KEY_TO_COUNT, new ArrayList<>()).size();
        for(int i = 0; i < count; i++) {
            String companyName = (String) data.get("CompanyName").get(i);
            enterCompanySearchBox(companyName);
        }
    }

    private void verifyButtonEnabled(By buttonPath) {
        WebElement button = driver.findElement(buttonPath);
        if (!button.isEnabled()) {
            throw new AssertionError("The button is not enabled");
        }
    }

    private void waitForSeconds() {
        try {
            Thread.sleep(CompanyAreaPage.WAIT_TIME * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
