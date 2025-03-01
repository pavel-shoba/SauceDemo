package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
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
        log.info("Cart was opened");
        return new CartPage(driver);
    }

    /**
     * Method to get product count in cart
     */
    public String getProductsCountInCart() {
        log.info("Count of product on cart is: {}", driver.findElement(CART_BADGE).getText());
        return driver.findElement(CART_BADGE).getText();
    }

    /**
     * Method to check badge is visible
     */
    public Boolean isBadgeVisible() {
        return driver.findElements(CART_BADGE).isEmpty();
    }
}
