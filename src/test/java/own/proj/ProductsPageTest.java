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

	@BeforeMethod
	public void login() {
		pages=new Pages(driver);
		loginPage = pages.loginPage();
		loginPage.login("standard_user", "secret_sauce");
	}

	@Test
	public void checkItemList() {
		List<String> expectedList = Arrays.asList("All Items", "About", "Logout", "Reset App State");
		List<String> actualList = pages.productsPage().getItemByName();

		assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedList);
	}

	@Test
	public void addProductToCart_CartNotEmpty() {
		pages.productsPage().getInventoryItemByName("Sauce Labs Backpack");

		assertEquals(pages.productPage().getBackToProductsName(), "Back to products", "Values are different");

		boolean isCartButtonPresent = pages.productPage()
				.clickAddToCartButton()
				.isRemoveFromCartButtonPresent();
		assertTrue(isCartButtonPresent);

		assertTrue(pages.productPage().isCartBadgePresent());
	}
}
