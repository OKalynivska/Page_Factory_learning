package own.proj;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

//	public WebDriver create(String browserType, String hubUrl) throws MalformedURLException {
//		switch (browserType){
//			case "chrome":
//				return  getChromeDriver("https://www.saucedemo.com/");
//			case "firefox":
//				return getFirefoxDriver(hubUrl);
//			default:
//				throw new IllegalArgumentException("Provided browser doesn't exist");
//		}
//	}
//
//	private WebDriver getChromeDriver(String hubUrl) throws MalformedURLException {
//		ChromeOptions options = new ChromeOptions();
//		options.setPageLoadStrategy(PageLoadStrategy.NONE);
//		return new RemoteWebDriver(new URL(hubUrl), options);
//	}
//
//	private WebDriver getFirefoxDriver(String hubUrl) throws MalformedURLException {
//		FirefoxOptions options = new FirefoxOptions();
//		return new RemoteWebDriver(new URL(hubUrl), options);
//	}
}
