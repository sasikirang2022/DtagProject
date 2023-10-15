package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DepartmentAreaPage;
import utils.TestContextSetup;

public class DepartmentAreaStepDefination {

    TestContextSetup testContextSetup;
    private DepartmentAreaPage departmentAreaPage;
    public DepartmentAreaStepDefination(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.departmentAreaPage = testContextSetup.pageObjectManager.getDepartmentAreaPage();
    }

    @Then("user clicks on the menu item Department Search to open the dialogue")
    public void user_clicks_on_the_menu_item_department_search_to_open_the_dialogue() throws InterruptedException {
        departmentAreaPage.openDepartmentArea();
        Thread.sleep(5000);
    }
    @When("The dialogue is initialized and by default the dialogue is opened with Basic search fields")
    public void theDialogueIsInitializedAndByDefaultTheDialogueIsOpenedWithBasicSearchFields() throws InterruptedException {
        departmentAreaPage.clickOnSearchButton();
        Thread.sleep(3000);
    }

    @Then("Action  + New Department icon is enabled on the Search Dialogue")
    public void actionNewDepartmentIconIsEnabledOnTheSearchDialogue() throws InterruptedException {
        departmentAreaPage.verifyCreateNewDepartmentButtonEnable();
        Thread.sleep(4000);
    }
    @When("user clicks on Create New Department button")
    public void user_clicks_on_create_new_department_button() throws InterruptedException {
        departmentAreaPage.clickOnCreateDepartmentButton();
        Thread.sleep(5000);
    }

    @Then("User clicks on action  + New Department, system navigates to Department details - Popup Dialogue")
    public void userClicksOnActionNewDepartmentSystemNavigatesToDepartmentDetailsPopupDialogue() throws InterruptedException {
        departmentAreaPage.createNewDepartment();
    }

    @Then("user clicks on department search button")
    public void userClicksOnDepartmentSearchButton() throws InterruptedException {
        departmentAreaPage.clickOnSearchButton();
        Thread.sleep(5000);
    }

}
