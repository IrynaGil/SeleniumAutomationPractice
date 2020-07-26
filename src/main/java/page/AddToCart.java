package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends BasePage {

    public AddToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}
