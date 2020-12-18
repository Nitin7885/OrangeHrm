package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetailsPageFactory {
WebDriver driver;

	//Login: username
	@FindBy(id = "txtUsername" )
	@CacheLookup
	WebElement pfuname;
	
	//Login: password
	@FindBy(how = How.ID, using = "txtPassword")
	@CacheLookup
	WebElement pfpwd;
	
	//Login: login button
	@FindBy(xpath = "//input[@id='btnLogin']" )
	@CacheLookup
	WebElement pflogin;
		
	//PIM module: PIM link
	@FindBy(id="menu_pim_viewPimModule")
	@CacheLookup
	WebElement pfPimLink;
	
	//Employee list: employee name 
	@FindBy(id="empsearch_employee_name_empName")
	@CacheLookup
	WebElement pfEmpName;
	
	//Employee list: employee ID
	@FindBy(id="empsearch_id")
	@CacheLookup
	WebElement pfEmpID;
	
	//Employee list: supervisor name
	@FindBy(id="empsearch_supervisor_name")
	@CacheLookup
	WebElement pfSupName;
	
	//Employee list: search button
	@FindBy(id = "searchBtn" )
	@CacheLookup
	WebElement pfSearch;
	
	//setters 
	public void setUname(String name) {
		pfuname.sendKeys(name);
	}
	
	public void setPwd(String pwd) {
		pfpwd.sendKeys(pwd);
	}
	
	public void setLogin() {
		pflogin.click();
	}
	
	public void setPimLink() {
		pfPimLink.click();
	}
	
	public void setEmpName(String empn) {
		pfEmpName.sendKeys(empn);
	}
	
	public void setEmpID(String empID) {
		pfEmpID.sendKeys(empID);
	}
	
	public void setSupName(String supn) {
		pfSupName.sendKeys(supn);
	}
	
	public void setSearchButton() {
		pfSearch.click();
	}
	
	//getters
	public WebElement getPfuname() {
		return pfuname;
	}
	
	public WebElement getPfpwd() {
		return pfpwd;
	}
	
	public WebElement getPfename() {
		return pfEmpName;
	}
	
	public WebElement getPfeid() {
		return pfEmpID;
	}
	public WebElement getPfsname() {
		return pfSupName;
	}
	
	//initialization 
	public PersonalDetailsPageFactory (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
