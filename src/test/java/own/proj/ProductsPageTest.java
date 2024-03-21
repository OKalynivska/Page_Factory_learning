package own.proj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends AbstractTest {
	private Pages pages;
	private LoginPage loginPage;
	private ProductsPage productsPage;
	private ProductPage productPage;

	@BeforeMethod
	public void goToProductsPage() {
		pages = new Pages(driver);
		loginPage = pages.loginPage();
		loginPage.login("standard_user", "secret_sauce");
		productsPage = pages.productsPage();
	}

	@Test
	public void checkItemList() {
		List<String> expectedList = Arrays.asList("All Items", "About", "Logout", "Reset App State");
		List<String> actualList = productsPage.getItemByName();

		assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedList);
	}

	@Test
	public void addProductToCart_CartNotEmpty() {
		productsPage.getInventoryItemByName("Sauce Labs Backpack");
		productPage = pages.productPage();

		assertEquals(productPage.getBackToProductsName(), "Back to products", "Values are different");

		productPage.clickAddToCartButton();

		assertTrue(productPage.isRemoveFromCartButtonPresent());
		assertTrue(productPage.isCartBadgePresent());
	}
}
