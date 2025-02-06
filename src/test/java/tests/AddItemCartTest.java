package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddItemCartTest {

    @Test
    public void addItemToCartAndCheckData() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String userName = "standard_user";
        String password = "secret_sauce";
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.className("submit-button")).click();
        List<WebElement> products = driver.findElements(By.xpath("//*[@data-test=\"inventory-item-name\"]"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//*[@data-test=\"inventory-item-price\"]"));
        String productName = products.get(0).getText();
        String productPrice = productPrices.get(0).getText();
        String xpathAddProduct = "//div[contains(text(), '" + productName + "')]/ancestor::div/div/button";
        driver.findElement(By.xpath(xpathAddProduct)).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        List<WebElement> productsInCart = driver.findElements(By.xpath("//*[@data-test=\"inventory-item-name\"]"));
        List<WebElement> productPricesInCart = driver.findElements(By.xpath("//*[@data-test=\"inventory-item-price\"]"));
        String productNameInCart = productsInCart.get(0).getText();
        String productPriceInCart = productPricesInCart.get(0).getText();
        Assert.assertEquals(productNameInCart, productName);
        Assert.assertEquals(productPriceInCart, productPrice);
        driver.quit();
    }
}
