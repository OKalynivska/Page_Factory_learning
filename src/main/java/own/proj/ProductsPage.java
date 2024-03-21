package own.proj;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductsPage extends Pages {
	@FindBy(how = How.CLASS_NAME, using = "title")
	private WebElement productPageTitle;

	@FindBy(how = How.CLASS_NAME, using = "menu-item")
	private List<WebElement> listItems;

	@FindBy(how = How.ID, using = "react-burger-menu-btn")
	private WebElement burgerMenu;

	@FindBy(how = How.CLASS_NAME, using = "inventory_item")
	private List<WebElement> listInventoryItems;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	public String getProductsPageName() {
		return getText(productPageTitle);
	}

	public List<String> getItemByName() {
		click(burgerMenu);

		List<String> actualTexts = new ArrayList<>();
		for (WebElement element : listItems) {
			isElementVisible(element);
			actualTexts.add(element.getText());
		}
		return actualTexts;
	}

	public void getInventoryItemByName(String productName) {
		if (listInventoryItems == null || listInventoryItems.isEmpty()) {
			throw new NoSuchElementException("List of products is empty");
		}

		for (WebElement element : listInventoryItems) {
			if (element.getText().equals(productName)) {
				click(element.findElement(By.cssSelector(".inventory_item_name")));
				break;
			}
		}
	}
}
