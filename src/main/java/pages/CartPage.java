package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends HeaderPage {
    public static final By CART_ITEM = By.xpath("//*[@data-test='inventory-item']");
    private By removeButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isCartEmpty() {
        return driver.findElements(CART_ITEM).isEmpty();
    }

    public void deleteItemFromCart(String productName) {
        String xpath = "//div[contains(text(),'%s')]/ancestor::div//button[contains(text(), 'Remove')]";
        removeButton = By.xpath(String.format(xpath, productName));
        driver.findElement(removeButton).click();
    }
}
