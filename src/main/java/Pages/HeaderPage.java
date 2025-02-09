package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderPage extends BasePage {

    public static final By CART_BUTTON = By.xpath("//*[@data-test='shopping-cart-link']");
    public static final By CART_BADGE = By.xpath("//*[@data-test='shopping-cart-badge']");

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    public String getCountItemInCart() {
        return driver.findElement(CART_BADGE).getText();
    }

    public Boolean isBadgeVisible() {
        List<WebElement> badge = driver.findElements(CART_BADGE);
        return badge.isEmpty();
    }
}
