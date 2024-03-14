package own.proj;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends AbstractPage{

	@FindBy(how = How.ID, using = "user-name")
	public WebElement username;

	@FindBy(how = How.ID, using = "password")
	public WebElement password;

	@FindBy(how = How.ID, using = "login-button")
	private WebElement loginButton;

	@FindBy(how = How.CSS, using = "[data-test='error']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void login(String name, String pass) {
		writeText(username, name);
		writeText(password, pass);
		click(loginButton);
	}

	public String checkErrorMessage(){
		return getText(errorMessage);
	}

	public ProductsPage productsPage(){
		return new ProductsPage(driver);
	}
}
