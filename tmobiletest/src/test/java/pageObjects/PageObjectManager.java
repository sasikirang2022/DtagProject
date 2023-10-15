package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private LandingPage landingPage;
    private WebDriver driver;
    private HeaderArea headerArea;
    private DepartmentAreaPage departmentAreaPage;
    private CompanyAreaPage companyAreaPage;
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public LandingPage getLandingPage(){
        landingPage = new LandingPage(driver);
        return landingPage;
    }
    public HeaderArea getHeaderArea(){
        headerArea = new HeaderArea(driver);
        return headerArea;
    }
    public DepartmentAreaPage getDepartmentAreaPage(){
        departmentAreaPage = new DepartmentAreaPage(driver);
        return departmentAreaPage;
    }
    public CompanyAreaPage getCompanyAreaPage(){
        companyAreaPage = new CompanyAreaPage(driver);
        return companyAreaPage;
    }
}
