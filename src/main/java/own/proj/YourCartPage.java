package own.proj;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class YourCartPage extends AbstractPage{
	@FindBy(className =  "cart_item")
	private List<WebElement> listCartItems;
	public YourCartPage(WebDriver driver) {
		super(driver);
	}

	public int checkNumberOfItems() {
		return listCartItems.size();
	}
}
