package StepDef;
import testRunner.TestRunner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;

import Pages.AddEmpPageFactory;
import cucumber.api.java.en.*;
import excelData.ExcelRead;

public class StepDefAddEmployee extends TestRunner {
	
	
	ExcelRead er1 = new ExcelRead("./OrangeHrmLogin.xlsx",1);
	
	@Given("^Admin is on Add Employee page$")
	public void admin_is_on_Add_Employee_page() throws InterruptedException {
		
		add_emp = new AddEmpPageFactory(driver);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

	@When("^Admin enter firstname and lastname$")
	public void admin_enter_firstname_and_lastname() {
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    add_emp.setFirstname(er1.getData(0, 0));
	    add_emp.setLastname(er1.getData(0,1));
	}

	@And("^click on save button$")
	public void click_on_save_button() throws InterruptedException{
		add_emp.setBtnsave();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}

	@Then("^Admin should be added and navigate to personal details page$")
	public void admin_should_be_added_and_navigate_to_personal_details_page() {
		driver.getPageSource().contains("Personal Details");
		//driver.close();
	}

	@When("^Admin does not enter firstname and lastname$")
	public void admin_does_not_enter_firstname_and_lastname() {
		add_emp.setFirstname("");
		add_emp.setLastname("");
		
	}

	@Then("^display appropriate message$")
	public void display_appropriate_message() {
		String msg = driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[1]/div[2]/form[1]/fieldset[1]/ol[1]/li[1]/ol[1]/li[1]/span[1]")).getText();
		Assert.assertEquals(msg,"Required");
		//driver.close();
	}
	@And("^all required fileds are filled$")
	public void all_required_fileds_are_filled() {
		add_emp.setFirstname(er1.getData(1,0));
		add_emp.setLastname(er1.getData(1,1));
	}

	@When("^Admin click on choose_file button$")
	public void admin_click_on_choose_file_button() {
		add_emp.setImg_button();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@And("^Admin add the selected file$")
	public void admin_add_the_selected_file() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:/Users/NITIN SARGARA/Desktop/AutoitFile/Imageupload.exe");
		Thread.sleep(10000);
	}

	@And("^Admin click on save button$")
	public void admin_click_on_save_button() throws InterruptedException {
		add_emp.setBtnsave();
		Thread.sleep(3000);
	}

	@Then("^Employee should be added and navigate to personal details page$")
	public void employee_should_be_added_and_navigate_to_personal_details_page() {
		driver.getPageSource().contains("Personal Details");
		//driver.close();
	}

	@When("^Admin add the selected file with incorrect format or size$")
	public void admin_add_the_selected_file_with_incorrect_format_or_size() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:/Users/NITIN SARGARA/Desktop/AutoitFile/Imgupload.exe");
		Thread.sleep(10000);
	}

	@Then("^Error Message should be displayed\\.$")
	public void error_Message_should_be_displayed() {
		 driver.getPageSource().contains("Add Employee");
		//Assert.assertEquals(txt,"Photograph");
		//driver.close();
	}

	@And("^check box is checked$")
	public void check_box_is_checked() throws InterruptedException {
		add_emp.setChklogin();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("^Admin enter a \"([^\"]*)\"$")
	public void admin_enter_a(String uname) {
		add_emp.setUsername(uname);
	}

	@And("^move to the next textbox$")
	public void move_to_the_next_textbox() {
		add_emp.setPassword("as");
	}

	@Then("^username textbox doesnot display any error message\\.$")
	public void username_textbox_doesnot_display_any_error_message() {
		String col = add_emp.getUsername().getCssValue("border-color");
		/*String msg = driver.findElement(By.xpath("//span[contains(text(),'Should have at least 5 characters')]")).getText();*/
		Assert.assertEquals(col,"rgb(210, 209, 209)");
		//driver.close();
	}

	@When("^Admin enter a \"([^\"]*)\" of less than five character$")
	public void admin_enter_a_of_less_than_five_character(String uname) {
	    add_emp.setUsername(uname);
	}

	@Then("^username textbox should display error message\\.$")
	public void username_textbox_should_display_error_message() {
		String col = add_emp.getUsername().getCssValue("border-color");
		/*String msg = driver.findElement(By.xpath("//span[contains(text(),'Should have at least 5 characters')]")).getText();*/
		Assert.assertEquals(col,"rgb(170, 73, 53)");
		//driver.close();
	}

	@When("^Admin enter a \"([^\"]*)\" with correct format$")
	public void admin_enter_a_with_correct_format(String pass)  {
		add_emp.setPassword(pass);
	  
	}

	@Then("^password textbox doesnot display any error message$")
	public void password_textbox_doesnot_display_any_error_message() {
		String col = add_emp.getPassword().getCssValue("border-color");
		/*String msg = driver.findElement(By.xpath("//span[contains(text(),'Should have at least 8 characters')]")).getText();*/
		Assert.assertEquals(col,"rgb(210, 209, 209)");
		//driver.close();
	    
	}

	@When("^Admin enter a \"([^\"]*)\" with incorrect format$")
	public void admin_enter_a_with_incorrect_format(String pass) throws InterruptedException {
		add_emp.setPassword(pass);
		Thread.sleep(3000);
	}

	@Then("^password textbox does display any error message$")
	public void password_textbox_does_display_any_error_message() {
		String col = add_emp.getPassword().getCssValue("border-color");
		/*String msg = driver.findElement(By.xpath("//span[contains(text(),'Should have at least 8 characters')]")).getText();*/
		Assert.assertEquals(col,"rgb(170, 73, 53)");
		//driver.close();
	}
	
}
