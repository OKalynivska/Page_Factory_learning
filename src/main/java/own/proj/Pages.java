package own.proj;

import org.openqa.selenium.WebDriver;

public class Pages extends AbstractPage{
	private static Pages instance;
	public Pages(WebDriver driver) {
		super(driver);
	}

   public LoginPage loginPage() { return initPage("loginUrl", LoginPage.class);}
   public ProductPage productPage() { return initPage("productUrl", ProductPage.class);}
   public ProductsPage productsPage() { return initPage("productsUrl", ProductsPage.class);}
   public YourCartPage yourCartPage() { return initPage("cartUrl", YourCartPage.class);}

	public static synchronized Pages getInstance(WebDriver driver) {
		if (instance == null) {
			instance = new Pages(driver);
		}
		return instance;
	}
}
