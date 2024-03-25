package own.proj;

import static org.openqa.selenium.By.cssSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends Pages {
	@FindBy(how = How.ID, using = "back-to-products")
	private WebElement backToProductsName;
	@FindBy(how = How.ID, using = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCartButton;
	@FindBy(how = How.ID, using = "remove-sauce-labs-backpack")
	private WebElement removeFromCartButton;
	@FindBy(className = "shopping_cart_link")
	private WebElement cartIcon;

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public String getBackToProductsName() {
		return getText(backToProductsName);
	}

	public ProductPage clickAddToCartButton() {
		click(addToCartButton);
		return this;
	}

	public void removeFromCartButton() {
		click(removeFromCartButton);
	}

	public boolean isRemoveFromCartButtonPresent() {
		return removeFromCartButton.isDisplayed();
	}

	public boolean isCartBadgePresent() {
		return cartIcon.findElement(cssSelector(".shopping_cart_badge")).isEnabled();
	}
}
