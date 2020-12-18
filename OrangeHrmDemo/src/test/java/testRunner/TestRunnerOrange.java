package orangeLogin;

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
import orangePageBean.orangePageFactory;
import cucumber.api.testng.*; 

 

@CucumberOptions(
		features = "./src/test/resources/orangeHRM",
		glue = {"orangeLogin"},
		plugin = {"pretty"}
)
public class TestRunnerOrange {
private TestNGCucumberRunner testNGCucumberRunner;
protected static WebDriver driver;
protected orangePageFactory obj;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {   
    	 System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\seleniumdrivers\\\\\\\\chromedriver.exe");
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
