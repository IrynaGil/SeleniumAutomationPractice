package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {
    private final short defaultTimeout = 3;

    public WebDriver driver;

    public BasePage() {
        driver = BaseTest.getDriver();
    }

    public void openURL(String URL) {
        driver.get(URL);
    }

    public void waitForVisibilityOfElement(WebElement element, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForPresenceOfElement(By locator, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean isElementVisible(WebElement element) {
        try {
            waitForVisibilityOfElement(element, defaultTimeout);
            element.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isImageBroken(WebElement image) {
        return image.getAttribute("naturalWidth").equals("0");
    }

    public Boolean isElementPresent(By locator) {
        try {
            waitForPresenceOfElement(locator, defaultTimeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isElementSelected(WebElement element) {
        return element.isSelected();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterInputValue(WebElement element, String string) {
        element.sendKeys(string);
    }

    public void submitForm(WebElement element) {
        element.submit();
    }

    public void DragnDrop(WebElement from, WebElement to) {
        Actions act = new Actions(driver);

        act.dragAndDrop(from, to).build().perform();
    }

    // clear()


}
