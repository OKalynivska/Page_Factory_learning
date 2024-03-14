package own.proj;

import org.openqa.selenium.WebDriver;

public class Pages extends AbstractPage{
	public Pages(WebDriver driver) {
		super(driver);
	}

//	public LoginPage loginP(){
//		//openPage("loginUrl", LoginPage.class);
//		//driver.get("https://www.saucedemo.com/");
//		return new LoginPage(driver).openPage("loginUrl", LoginPage.class);}
//
//
//	public ProductsPage prod(){
//		driver.get("https://www.saucedemo.com/inventory.html");
//		return new ProductsPage(driver);}
}
