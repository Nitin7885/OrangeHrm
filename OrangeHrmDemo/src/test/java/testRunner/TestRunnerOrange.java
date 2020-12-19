package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import org.junit.runner.RunWith;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 

import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import Pages.orangePageFactory;
import cucumber.api.testng.*; 

 

@CucumberOptions(
		tags = {"@Login"},
		features = "./src/test/resources/Features/",
		glue = {"StepDef"},
		plugin = {"pretty", "html:./target/cucumber-html-report","json:./target/cucumbertestreport.json"}
)
public class TestRunnerOrange {
private TestNGCucumberRunner testNGCucumberRunner;
protected static WebDriver driver;
protected orangePageFactory obj;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {   
    	 System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
    	    driver = new ChromeDriver();
    	    //driver.get("https://opensource-demo.orangehrmlive.com/");
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")    
    public void feature(PickleEventWrapper eventwrapper,CucumberFeatureWrapper cucumberFeature) throws Throwable {
    	//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    	testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }
    
    @DataProvider//(parallel=true)
    public Object[][] features() {
       // return testNGCucumberRunner.provideFeatures();    	
    	 return testNGCucumberRunner.provideScenarios();
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception { 
    	driver.quit();
        testNGCucumberRunner.finish();        
    }

}
