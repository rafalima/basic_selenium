package codigoFeitoNoQaNight;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
	
	public WebDriver driver;
	public static int DEFAULT_WAIT_TIME = 5;
	public String adminUrl = "http://localhost:3000/admin";

	@Before
	public void setUp() throws Exception {		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	
}
