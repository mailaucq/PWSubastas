package com.subastas.web;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddProductoTest extends TestCase{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddProduct() throws Exception {
    driver.get(baseUrl + "/PWsubastas/login.htm");
    driver.findElement(By.id("usuarioNombre")).clear();
    driver.findElement(By.id("usuarioNombre")).sendKeys("Eli");
    driver.findElement(By.id("usuarioPassword")).clear();
    driver.findElement(By.id("usuarioPassword")).sendKeys("eli");
    driver.findElement(By.name("submit")).click();
    driver.get(baseUrl + "/PWsubastas/secured/producto.htm");
    driver.findElement(By.id("productoNombre")).clear();
    driver.findElement(By.id("productoNombre")).sendKeys("Manga BowBoy bebop");
    driver.findElement(By.id("s_productoTiempoInicial")).clear();
    driver.findElement(By.id("s_productoTiempoInicial")).sendKeys("2014-07-30 09:00:00");
    driver.findElement(By.id("s_productoTiempoFinal")).clear();
    driver.findElement(By.id("s_productoTiempoFinal")).sendKeys("2014-07-31 20:00:00");
    driver.findElement(By.id("s_productoTiempoInicial")).clear();
    driver.findElement(By.id("s_productoTiempoInicial")).sendKeys("2014-07-31 09:00:00");
    driver.findElement(By.id("productoPrecioReal")).clear();
    driver.findElement(By.id("productoPrecioReal")).sendKeys("23.0");
    driver.findElement(By.id("productoDescripcion")).clear();
    driver.findElement(By.id("productoDescripcion")).sendKeys("Manga CowBoyBebop");
    driver.findElement(By.name("submit")).click();
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
