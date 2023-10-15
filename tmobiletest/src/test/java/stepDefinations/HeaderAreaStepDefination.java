package stepDefinations;

import pageObjects.HeaderArea;
import utils.TestContextSetup;

public class HeaderAreaStepDefination {
    TestContextSetup testContextSetup;
    private HeaderArea headerArea;
    public HeaderAreaStepDefination(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.headerArea = testContextSetup.pageObjectManager.getHeaderArea();

    }
    public void user_opens_the_profile_dropdown() throws InterruptedException {
        headerArea.clickProfileIcon();
        Thread.sleep(2000);
    }

    public void user_clicks_on_logout() throws InterruptedException {
        headerArea.clickLogout();
        Thread.sleep(2000);
    }
}
