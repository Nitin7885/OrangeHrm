package orangePageBean;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class orangePageFactory { 
	WebDriver driver;
	
	// locating elements 
	@FindBy(id = "txtUsername" )
	@CacheLookup
	WebElement pfuname;
	
	@FindBy(how = How.ID, using = "txtPassword")
	@CacheLookup
	WebElement pfpwd;
	
	@FindBy(xpath = "//input[@id='btnLogin']" )
	@CacheLookup
	WebElement pflogin; 
	
	//initialization 
	public orangePageFactory (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
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
	
	//getters
	public WebElement getPfuname() {
		return pfuname;
	}
	
	public WebElement getPfpwd() {
		return pfpwd;
	}

}
