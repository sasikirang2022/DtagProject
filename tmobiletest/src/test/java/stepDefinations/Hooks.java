package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    @After
    public void afterScenario() throws IOException, InterruptedException {
        testContextSetup.pageObjectManager.getHeaderArea().clickProfileIcon();
        Thread.sleep(4000);
        testContextSetup.pageObjectManager.getHeaderArea().clickLogout();
        Thread.sleep(4000);
        testContextSetup.testBase.webDriverManager().quit();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)testContextSetup.testBase.webDriverManager()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
