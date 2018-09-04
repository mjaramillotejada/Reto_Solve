package reto1_Solve;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prueba1 {
	   private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mjaramillo\\Downloads\\Driver_Ejercicio\\chromedriver.exe");
		  driver = new ChromeDriver();
		  baseUrl = "https://www.katalon.com/";
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testReto1() throws Exception {
	    driver.get("http://sahitest.com/demo/jsPopup.htm");
	    driver.findElement(By.linkText("Back")).click();
	    Evidencias.TomarEvidencia(";Evidencia");
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("IFrames Test")).click();
	    Evidencias.TomarEvidencia(";Evidencia");
	    Thread.sleep(3000);
	    driver.switchTo (). frame (1);
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("Window Open Test")).click();
	    Evidencias.TomarEvidencia(";Evidencia");
		Thread.sleep(5000);
	    
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

