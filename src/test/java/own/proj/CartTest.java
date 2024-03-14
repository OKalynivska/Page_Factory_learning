package own.proj;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends AbstractTest{
	private LoginPage loginPage;
	private  ProductsPage productsPage;
	private ProductPage productPage;
	private YourCartPage yourCartPage;


	@BeforeMethod
	public void goToPage() {
		loginPage = openPage("loginUrl", LoginPage.class);
		loginPage.login("standard_user", "secret_sauce");
		productsPage = openPage("productsUrl", ProductsPage.class);
		productPage = openPage("productUrl", ProductPage.class);
	}

	@Test
	public void checkCartSizeNotNull(){
		productPage.clickAddToCartButton();
		yourCartPage = openPage("cartUrl", YourCartPage.class);
		assertThat(yourCartPage.checkNumberOfItems()).isGreaterThan(0);
	}
}
