package own.proj;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {
	private Pages pages;
	private LoginPage loginPage;

	@BeforeMethod
	public void goToLoginPage() {
		pages=new Pages(driver);
		loginPage = pages.loginPage();
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
				{ "11", "11", "Epic sadface: Username and password do not match any user in this service" },
				{ "", "", "Epic sadface: Username is required" },
				{ "standard_user", "fffff", "Epic sadface: Username and password do not match any user in this service" },
				{ "user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service" }
		};
	}

	@Test(dataProvider = "loginData")
	public void loginFailed(String username, String password, String expectedErrorMessage) {
		loginPage.login(username, password);
		assertEquals(loginPage.checkErrorMessage(), expectedErrorMessage, "Values are different");
	}

	@Test
	public void loginSuccessful() {
		loginPage.login("standard_user", "secret_sauce");
		String expectedName = pages.productsPage().getProductsPageName();

		assertEquals(expectedName, "Products", "Values are different");
	}
}
