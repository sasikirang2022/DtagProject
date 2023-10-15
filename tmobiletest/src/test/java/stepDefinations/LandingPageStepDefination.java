package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefination {
    TestContextSetup testContextSetup;
    private LandingPage landingPage;
    public LandingPageStepDefination(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

    }
    @Given("user is on landing page")
    public void user_is_on_landing_page() {
        Assert.assertTrue(landingPage.getTitleLandingPage().contains("Sign in to onecx"));
    }
    @When("user login into application with username {string} and password {string}")
    public void user_login_into_application_with_username_and_password(String actualUsername, String actualPassword) throws InterruptedException {
        landingPage.enterUsername(actualUsername);
        landingPage.enterPassword(actualPassword);
    }
    @Then("user clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        landingPage.clickLoginButton();
        Thread.sleep(3000);
    }
}
