package testRunner;
import Pages.AddEmpPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.*;

@CucumberOptions (
		features = "./src/test/resources/Features/",
		glue = {"StepDef"},
        plugin = {"pretty","html:./target/cucumber-html-report","json:./target/cucumbertestreport.json"})
public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;
    protected static WebDriver driver;
    protected AddEmpPageFactory add_emp;
    
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
    	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		add_emp = new AddEmpPageFactory(driver);
		add_emp.setTxtuname("Admin");
		add_emp.setTxtpwd("admin123");
		add_emp.setBtnlogin();
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
