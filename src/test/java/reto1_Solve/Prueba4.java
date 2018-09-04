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
import org.openqa.selenium.firefox.FirefoxDriver;

public class Prueba4 {
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
  public void testPrueba4() throws Exception {
    driver.get("http://sahitest.com/demo/training/login.htm");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("user")).sendKeys("test");
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.name("password")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("password")).sendKeys("secret");
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("q")).click();
    driver.findElement(By.name("q")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("q")).sendKeys("2");
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 200'])[1]/following::input[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 200'])[1]/following::input[1]")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 200'])[1]/following::input[1]")).sendKeys("5");
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 350'])[1]/following::input[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 350'])[1]/following::input[1]")).clear();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 350'])[1]/following::input[1]")).sendKeys("2");
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 350'])[1]/following::input[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("total")).click();
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.id("total")).click();
    Evidencias.TomarEvidencia(";Evidencia");
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rs. 350'])[1]/following::input[4]")).click();
    Thread.sleep(3000);    
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

