package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage {
    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By CART_BADGE = By.xpath("//*[@data-test='shopping-cart-badge']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getProductsCountInCart() {
        return driver.findElement(CART_BADGE).getText();
    }

    public Boolean isBadgeVisible() {
        return driver.findElements(CART_BADGE).isEmpty();
    }
}
