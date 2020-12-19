package StepDef;


import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.orangePageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testRunner.TestRunnerOrange;


public class StepDefOrange extends TestRunnerOrange {
	
	//private WebDriver driver;
	private orangePageFactory obj;

@Given("^user is on login page$")
public void user_is_on_login_page() {
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    obj = new orangePageFactory(driver);
    driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
}

@When("user enters valid {string} and {string}")
public void user_enters_valid_and(String string, String string2) {
    obj.setUname(string);
    obj.setPwd(string2);
    obj.setLogin();
}


@Then("^navigate to the orangeHRM dashboard$")
public void navigate_to_the_orangeHRM_dashboard() {
    driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	
@When("user enters invalid {string} or {string}")
public void user_enters_invalid_or(String string, String string2) {
    obj.setUname(string);
    obj.setPwd(string2);
    obj.setLogin();
}

@Then("^display login failed message$")
public void display_login_failed_message() {
    String strmsg = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
    assertEquals(strmsg, "Invalid credentials");
}


@When("^user does not enter username or password$")
public void user_does_not_enter_username_or_password() throws Throwable {
    obj.setUname("");
    obj.setPwd("");
}

@When("^clicks the login button$")
public void clicks_the_login_button() throws Throwable {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    obj.setLogin();
}

@Then("^display appropiate error message$")
public void display_appropiate_error_message() throws Throwable {
    String str = driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
    assertEquals(str, "Username cannot be empty");
}

}
