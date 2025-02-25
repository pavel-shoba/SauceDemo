package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By CART_BADGE = By.xpath("//*[@data-test='shopping-cart-badge']");

    /**
     * Method to initialize driver for Header page
     */
    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method to click cart button
     */
    public CartPage clickCartButton() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }

    /**
     * Method to get product count in cart
     */
    public String getProductsCountInCart() {
        return driver.findElement(CART_BADGE).getText();
    }

    /**
     * Method to check badge is visible
     */
    public Boolean isBadgeVisible() {
        return driver.findElements(CART_BADGE).isEmpty();
    }
}
