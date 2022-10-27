package utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

public class WebUtil extends ExtentReportUtil {
	private  WebDriver driver;
	private long implicitWait = 30;
	private static WebUtil util;
	
	
	private WebUtil() {
		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public static WebUtil getWebUtilObj() {
		if(util==null) {
			util=new WebUtil();
		}
		return util;
	}
	 
	/**
	 * @param wait
	 */
	public void setImplicitWait(long wait) {
		implicitWait = wait;
	}
	
	/**
	 * @implNote : for launching browser
	 */
	public void launchChromeBrowser(String browserName) {
		
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Chrome browser is launched successfully...");
		}
		if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//info(browserName+" is launched successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		//info(" Implicitly wait is set for 30 sec ");
		driver.manage().window().maximize();
		//info("Window is maximized");
		
	}
	
	

	/**
	 * @implNote : Hit url on the browser.
	 * @param : url is used for getting url.
	 */
	public void openUrl(String url) {
		driver.get(url);
		System.out.println(url + " is opened successfully");
		//info(url+" is opened successfuly");
	}

	 /**
	 * @param imgName
	 * @return 
	 */
	public String getScreenShot(String imgName) {
		File fileScr =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File fileTrg=new File("screenshots//"+imgName+".png");
		try {
			Files.copy(fileScr, fileTrg);
			info("ScreenShot "+imgName+" is taken successfully");
		} catch (IOException e) {
			warning(e.getMessage());
		}
		return fileTrg.getAbsolutePath();
	}
	/**
	 * @implNote : it is used to click on element(button,link,checkbooks,radio
	 *           button, etc).
	 * @param we          :
	 * @param elementName :
	 */
	public WebElement getFreshWebElement(WebElement we) {
		String weString = we.toString();
		String[] weText = weString.split(":");
		weString = weText[weText.length - 1];
		weString = weString.substring(0, weString.length() - 1);
		weString = weString.trim();
		we = driver.findElement(By.xpath(weString));
		return we;
	}

	/**
	 * @implNote it is used to click on element(button,link,checkbooks,radio button,
	 *           etc).
	 * @param we          : webElement of the element.
	 * @param elementName : Name of the element.
	 */
	public void click(WebElement we, String elementName) {
		try {
			we.click();
			System.out.println(elementName + " is clicked successfully");
			
			info(elementName + " is clicked successfully");
		} catch (ElementClickInterceptedException e) {
			new Actions(driver).click(we).build().perform();
			info(elementName + " is clicked successfully by Actions");
			System.out.println(elementName + " is clicked successfully by Actions");
		} catch (ElementNotInteractableException e) {
			jsClick(we, elementName);
		} catch (StaleElementReferenceException e) {
			we = getFreshWebElement(we);
			we.click();
			System.out.println(elementName + " is clicked successfully by after refresh");
		}

	}

	/**
	 * @implNote it is used to input the value in input box.
	 * @param we          : webElement is required
	 * @param inputData   : Input value which have to send into input box.
	 * @param elementName : Name of the element.
	 */
	public void clearEditBox(WebElement we, String elementNmae) {
		we.clear();
		info(elementNmae+" is cleared");
	}
	public void sendkeys(WebElement we, String inputData, String elementName) {
		try {
			we.sendKeys(inputData);
			info(inputData + " is entered successfully in " + elementName);
			System.out.println(inputData + " is entered successfully in " + elementName);
		} catch (ElementClickInterceptedException e) {
			new Actions(driver).sendKeys(inputData).build().perform();
			System.out.println(inputData  + " is entered successfully in " + elementName + " through Action class");
			info(inputData  + " is entered successfully in " + elementName + " through Action class");
		} catch (ElementNotInteractableException e) {
			jsSendkeys(we, inputData, elementName);
		} catch (StaleElementReferenceException e) {
			we = getFreshWebElement(we);
			we.sendKeys(inputData);
			System.out.println(inputData + " is entered successfully in " + elementName + " after refresh");
		}
	}

	/**
	 * @implNote : it is used to select the drop down on the basis of index.
	 * @param we          :
	 * @param index       :
	 * @param elementName :
	 */
	public void selectDropDown(WebElement we, int index, String elementName) {
		Select select = new Select(we);
		select.selectByIndex(index);
		System.out.println(elementName + " is selected successfully");
		info(elementName + " is selected successfully");
	}

	/**
	 * @implNote : it is used to select the drop down on the basis of inner text or
	 *           value attribute .
	 * @param we                 :
	 * @param visibleTextOrValue :
	 * @param elementName        :
	 */
	public void selectDropDown(WebElement we, String visibleTextOrValue, String elementName) {
		Select select = new Select(we);
		setImplicitWait(0);
		try {
			select.selectByVisibleText(visibleTextOrValue);
		} catch (NoSuchElementException e) {
			select.selectByValue(visibleTextOrValue);
		}
		setImplicitWait(30);
		info(elementName + " is selected successfully");
		System.out.println(elementName + " is selected successfully");
	}

	

	/**
	 * @implNote : it is used to fetch the inner text of element.
	 * @param we          :
	 * @param elementName :
	 * @return : Return the inner text for further use.
	 */
	public String getText(WebElement we, String elementName) {
		String actualText = we.getText();
		info("Inner text of " + elementName + " is successfully fetched");
		System.out.println("Inner text of " + elementName + " is successfully fetched");
		return actualText;
	}

	/**
	 * @implNote : it is used to fetch the title of current page.
	 * @param pageName :
	 * @return :
	 */
	public String getTitle(String pageName) {
		String actualTitle = driver.getTitle();
		info("Title of " + pageName + " is:" + actualTitle);
		System.out.println("Title of " + pageName + " is:" + actualTitle);
		return actualTitle;
	}

	/*
	 * Purpose:it is used to fetch the attribute value of element.
	 * 
	 */
	/**
	 * @implNote :
	 * @param we           :
	 * @param AtributeName :
	 * @return :
	 */
	public String getAtribute(WebElement we, String AtributeName) {
		String actualAtrValue = we.getAttribute(AtributeName);
		info("Attribute value of " + AtributeName + " is successfully fetched");
		System.out.println("Attribute value of " + AtributeName + " is successfully fetched");
		return actualAtrValue;
	}

	

	public void actMouseOver(WebElement we, String elementName) {
		Actions act = new Actions(driver);
		act.moveToElement(we).build().perform();
		info("Mouse is moved to " + elementName + " successfully");
		System.out.println("Mouse is moved to " + elementName + " successfully");
	}

	/**
	 * @implNote :
	 * @param we          :
	 * @param elementName :
	 */
	public void actClick(WebElement we, String elementName) {
		Actions act = new Actions(driver);
		act.click(we).build().perform();
		info(elementName + " is clicked successfully");
		System.out.println(elementName + " is clicked successfully");
	}

	/**
	 * @implNote :
	 * @param we          :
	 * @param inputValue  :
	 * @param elementName :
	 */
	public void actSendkeys(WebElement we, String inputValue, String elementName) {
		Actions act = new Actions(driver);
		act.sendKeys(we, inputValue).build().perform();
		info(inputValue + " is entered successfully in " + elementName);
		System.out.println(inputValue + " is entered successfully in " + elementName);
	}

	/**
	 * @implNote :
	 * @param weDrag      :
	 * @param weDrop      :
	 * @param elementName :
	 */
	public void dragAndDrop(WebElement weDrag, WebElement weDrop, String elementName) {
		Actions act = new Actions(driver);
		act.dragAndDrop(weDrag, weDrop).build().perform();
		System.out.println(elementName + " is dpropped successfuly");
		info(elementName + " is dpropped successfuly");
	}

	/**
	 * @implNote :
	 * @param we          :
	 * @param elementName :
	 */
	public void rightClick(WebElement we, String elementName) {
		Actions act = new Actions(driver);
		act.contextClick(we).build().perform();
		System.out.println("Right click is done successfully on " + elementName);
		info("Right click is done successfully on " + elementName);
	}

	/**
	 * @implNote :
	 * @param we          :
	 * @param elementName :
	 */
	public void doubleClick(WebElement we, String elementName) {
		Actions act = new Actions(driver);
		act.doubleClick(we).build().perform();
		System.out.println("double click is done successfully on " + elementName);
		info("double click is done successfully on " + elementName);
	}
	

	/**
	 * @implNote :
	 * @param we          :
	 * @param elementName :
	 */
	public void jsClick(WebElement we, String elementName) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", we);
		info(elementName + " is clicked successfully");
		System.out.println(elementName + " is clicked successfully");

	}

	/**
	 * @implNote :
	 * @param we          :
	 * @param inputData   :
	 * @param elementName :
	 */
	public void jsSendkeys(WebElement we, String inputData, String elementName) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='" + inputData + "'", we);
		System.out.println(inputData + " is entered successfully in " + elementName+" by JavaScript");
		info(inputData + " is entered successfully in " + elementName+" by JavaScript");

	}

	public void jsScroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,5000)");
	}

	

	/**
	 * Description : pause the program for required time. it is wait
	 * 
	 * @param time : take time in seconds
	 */
	public void holdOn(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void closeWindow() throws SocketException {
		driver.close();
		System.out.println("window is closed successfully");
		info("window is closed successfully");
	}

	/**
	 * 
	 */
	public void closeAllWindow() {
		driver.quit();
		System.out.println("All window is closed successfully");
		info("All window is closed successfully");
	}

	/**
	 * @param we
	 * @param timeInSecond
	 */
	public boolean waitUntilElementIsVisible(WebElement we, int timeInSecond) {
		setImplicitWait(2);
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		boolean flag = false;
		try {
		expWait.until(ExpectedConditions.visibilityOf(we));
		flag=true;
		}
		catch (TimeoutException e) {
			info(we.toString()+" could not be visible");
		}
		setImplicitWait(implicitWait);
		return flag;
	}

	/**
	 * @param xpath
	 * @param timeInSecond
	 */
	public void waitUntilElementIsVisible(String xpath, int timeInSecond) {
		By by = By.xpath(xpath);
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	/**
	 * @param we
	 * @param timeInSecond
	 */
	public void waitUntilElementInVisible(WebElement we, int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.invisibilityOf(we));
	}

	/**
	 * @param by
	 * @param timeInSecond
	 */
	public void waitUntilElementInVisible(By by, int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	/**
	 * @param we
	 * @param timeInSecond
	 */
	public void waitUntilElementEnable(WebElement we, int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.elementToBeClickable(we));
	}

	/**
	 * @param we
	 * @param timeInSecond
	 */
	public void waitUntilElementDisable(WebElement we, int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(we)));
	}

	/**
	 * @param timeInSecond
	 */
	public void waitForAlert(int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * @param by
	 * @param expText
	 * @param timeInSecond
	 */
	public void waitElementText(By by, String expText, int timeInSecond) {
		WebDriverWait expWait = new WebDriverWait(driver, Duration.ofSeconds(timeInSecond));
		expWait.until(ExpectedConditions.textToBePresentInElementLocated(by, expText));
	}

	/**
	 * @return
	 */
	public String getAlertMessage() {
		String alertMessage = "";
		try {
			waitForAlert(5);
			alertMessage = driver.switchTo().alert().getText();
			System.out.println("alert message is fetched succesfully");
			info("alert message is fetched succesfully");
		} catch (TimeoutException e) {
			System.out.println("no alert is present");
			warning("no alert is present");
		}
		return alertMessage;
	}

	/**
	 * @param expAlertMessage
	 */
	public void verifyAlertMessage(String expAlertMessage) {
		try {
			waitForAlert(5);
			String alertMessage = driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase(expAlertMessage)) {
				System.out.println("Actual alert message : " + alertMessage
						+ " is matched  with expected alert message: " + expAlertMessage);
				pass("Actual alert message : " + alertMessage
						+ " is matched  with expected alert message: " + expAlertMessage);
			} else {
				System.out.println("Actual alert message : " + alertMessage
						+ " is mismatched  with expected alert message: " + expAlertMessage);
				fail("Actual alert message : " + alertMessage
						+ " is mismatched  with expected alert message: " + expAlertMessage);
			}
		} catch (TimeoutException e) {
			warning("no alert is present");
			System.out.println("no alert is present");
		}
	}

	/**
	 * 
	 */
	public void cancleAlert() {
		try {
			waitForAlert(5);
			driver.switchTo().alert().dismiss();
			info("alert is cancled successfully");
			System.out.println("alert is cancled successfully");
		} catch (TimeoutException e) {
			warning("No alert pop up is found ");
			System.out.println("No alert pop up is found ");
		}
	}

	/**
	 * 
	 */
	public void acceptleAlert() {
		try {
			waitForAlert(5);
			driver.switchTo().alert().accept();
			info("alert is clicked on ok button successfully");
			System.out.println("alert is clicked on ok button successfully");
		} catch (TimeoutException e) {
			warning("No alert pop up is found ");
			System.out.println("No alert pop up is found ");
		}
	}

	/**
	 * @param inputData
	 */
	public void alertSendkeys(String inputData) {
		try {
			waitForAlert(5);
			driver.switchTo().alert().sendKeys(inputData);
			System.out.println(inputData + " is inputed into alert inpu box");
			info(inputData + " is inputed into alert inpu box");
		} catch (TimeoutException e) {
			System.out.println("no alert is present");
			warning("no alert is present");
		}
	}
	
	
	
}

