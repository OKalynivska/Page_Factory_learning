package own.proj;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends AbstractTest {
	private Pages pages;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private ProductPage productPage;
	private YourCartPage yourCartPage;

	@BeforeMethod
	public void goToProductPage() {
		pages = new Pages(driver);
		loginPage = pages.loginPage();
		loginPage.login("standard_user", "secret_sauce");
		productsPage = pages.productsPage();
		productPage = pages.productPage();
	}

	@Test
	public void checkCartSizeNotNull() {
		productPage.clickAddToCartButton();
		yourCartPage = pages.yourCartPage();
		assertThat(yourCartPage.checkNumberOfItems()).isGreaterThan(0);
	}
}