package pages;

import constants.IConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage implements IConstants {
    WebDriver driver;

    /**
     * Method to init driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Methods tot open page using url
     */
    public void openPage(String url) {
        driver.get(url);
    }
}
