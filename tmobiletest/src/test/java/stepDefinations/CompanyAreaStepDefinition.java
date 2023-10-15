package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CompanyAreaPage;
import utils.TestContextSetup;

public class CompanyAreaStepDefinition {

    TestContextSetup testContextSetup;
    private CompanyAreaPage companyAreaPage;
    public CompanyAreaStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.companyAreaPage = testContextSetup.pageObjectManager.getCompanyAreaPage();
    }

    @When("The dialogue is initialized and by default the dialogue is opened with Basic search fields for company")
    public void the_dialogue_is_initialized_and_by_default_the_dialogue_is_opened_with_basic_search_fields_for_company(){
        companyAreaPage.clickOnSearchButton();
    }


    @Then("Action Create New Company icon is enabled on the Search Dialogue")
    public void actionCreateNewCompanyIconIsEnabledOnTheSearchDialogue(){
        companyAreaPage.verifyCreateNewCompanyButtonEnable();

    }

    @Then("User clicks on action Create New Company, system navigates to Company details wizard")
    public void userClicksOnActionCreateNewCompanySystemNavigatesToCompanyDetailsWizard(){
        companyAreaPage.createNewCompany();
    }

    @When("User clicks on Edit button Save button is visible or enabled")
    public void userClicksOnEditButtonSaveButtonIsVisibleOrEnabled(){
        companyAreaPage.verifySaveButtonEnable();
        
    }

    @Then("User enters or update any details in the Fields and clicks on Save, system validates the message")
    public void userEntersOrUpdateAnyDetailsInTheFieldsAndClicksOnSaveSystemValidatesTheMessage() {
        companyAreaPage.enterCompanyDescription();

    }

    @Then("After clicking on Save the Edit button and Download Comp button is visible or enabled and the Edit Company Details becomes read-only")
    public void afterClickingOnSaveTheEditButtonAndDownloadCompButtonIsVisibleOrEnabledAndTheEditCompanyDetailsBecomesReadOnly() {
        companyAreaPage.verifyEditAndDownloadCompanyButtonEnable();
    }

    @Then("user clicks on Search button")
    public void userClicksOnSearchButton(){
        companyAreaPage.clickOnSearchButton();
    }

    @When("by default the result is displayed in List view")
    public void byDefaultTheResultIsDisplayedInListView() {
        companyAreaPage.verifyDepartmentNamesInListView();
    }

}
