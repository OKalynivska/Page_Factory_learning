package own.proj;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends AbstractTest {
	private Pages pages;
	private LoginPage loginPage;

	@BeforeMethod
	public void login() {
		pages=new Pages(driver);
		loginPage = pages.loginPage();
		loginPage.login("standard_user", "secret_sauce");
	}

	@Test
	public void checkCartSizeNotNull() {
		int itemNumbers = pages.productPage()
				.clickAddToCartButton()
				.yourCartPage()
				.checkNumberOfItems();

		assertThat(itemNumbers).isGreaterThan(0);
	}
}