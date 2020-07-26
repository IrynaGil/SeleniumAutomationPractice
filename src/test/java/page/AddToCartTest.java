package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTest extends BaseTest {
    private AddToCart page;

    @Test
    public void AddToCartAndCheckTheNumberOfElementsAdded() {
        page = new AddToCart(getDriver());
        page.openURL("http://automationpractice.com");

        assertTrue(findTShirtsMenuItemAndClickIt(), "T-Shirt menu item is not found");

        assertTrue(checkCategoryNameIsTShirts(), "Wrong category name is displayed");


        //Find product list under the "T-shirts" category and check that product quantity is >0
        WebElement ulProductList = getDriver().findElement(By.className("product_list"));

        List<WebElement> productList = ulProductList.findElements(By.tagName("li"));
        assertTrue(productList.size() > 0, "No T-Shirts found");

        //Identify the first product in the list and hover the mouse over it
        WebElement liTShirt = productList.get(0);

        Actions action = new Actions(getDriver());
        action.moveToElement(liTShirt).build().perform();

        //Identify the "Add To Cart" button and click on it
        WebElement addToCartButton = ulProductList.findElement(By.className("ajax_add_to_cart_button"));
        assertTrue(page.isElementVisible(addToCartButton), "Add to cart button is not found");
        page.clickOnElement(addToCartButton);

        //Identify the "Continue" button on the "Add to cart" popup and click on it
        WebElement continueButton = getDriver().findElement(By.className("continue"));
        assertTrue(page.isElementVisible(continueButton), "Continue button is not found");
        page.clickOnElement(continueButton);

        //Find the "Dresses" menu item by xpath and hover the mouse over it
        WebElement aMenuDresses = getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a"));
        assertTrue(page.isElementVisible(aMenuDresses), "Dresses menu item is not found");
        action.moveToElement(aMenuDresses).build().perform();

        //Find the "Dresses" submenu list
        WebElement ulMenuDresses = getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul"));

        List<WebElement> dressKindsList = ulMenuDresses.findElements(By.tagName("li"));
        assertTrue(dressKindsList.size() > 0, "No dresses kinds found");
        assertTrue(dressKindsList.size() > 1, "Too few dresses kinds found");

        //Find the "Evening Dresses" submenu item and click on it
        WebElement eveningDressesMenu = dressKindsList.get(1);
        assertTrue(page.isElementVisible(eveningDressesMenu), "Evening Dresses menu item is not found");
        assertEquals(eveningDressesMenu.getText(), "EVENING DRESSES", "Evening dresses not found");

        page.clickOnElement(eveningDressesMenu);

        //Check if correct page is opened: "Evening Dresses"
        WebElement subCategoryName = getDriver().findElement(By.className("category-name"));
        assertTrue(page.isElementVisible(subCategoryName), "Subcategory page is not found");
        assertEquals("Evening Dresses", subCategoryName.getText());

        //Find product list under the "Evening Dresses" subcategory and check that product quantity is >0
        WebElement ulDressesList = getDriver().findElement(By.className("product_list"));

        List<WebElement> dressesList = ulDressesList.findElements(By.tagName("li"));
        assertTrue(dressesList.size() > 0, "No Dresses found");

        //Identify the first product in the "Evening Dresses" list and hover the mouse over it
        WebElement liEveningDress = dressesList.get(0);

        Actions hoverAction = new Actions(getDriver());
        hoverAction.moveToElement(liEveningDress).build().perform();

        //Identify the "Add To Cart" button and click on it
        WebElement addDressToCartButton = ulDressesList.findElement(By.className("ajax_add_to_cart_button"));
        assertTrue(page.isElementVisible(addDressToCartButton), "Add to cart button is not found");

        page.clickOnElement(addDressToCartButton);

        //Identify the "Proceed to Checkout" button and click on it
        WebElement checkoutButton = getDriver().findElement(By.className("button-medium"));
        assertTrue(page.isElementVisible(checkoutButton), "Checkout button is not found");

        page.clickOnElement(checkoutButton);

        //Identify the product quantity counter and check the number of products in the cart
        WebElement productQuantity = getDriver().findElement(By.id("summary_products_quantity"));
        assertTrue(page.isElementVisible(productQuantity), "Product quantity counter is not found");
        assertEquals(productQuantity.getText(), "2 Products", "Wrong product quantity");

    }

    //Find "T-Shirts" menu item by xpath and click on it
    private boolean findTShirtsMenuItemAndClickIt() {
        WebElement menuTShirts = getDriver().findElement(By.xpath("/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a"));

        boolean res = page.isElementVisible(menuTShirts);
        if (res) {
            page.clickOnElement(menuTShirts);
        }

        return res;
    }

    //Check if correct page is opened: "T-Shirts"
    private boolean checkCategoryNameIsTShirts() {
        WebElement categoryName = getDriver().findElement(By.className("category-name"));

        boolean res = page.isElementVisible(categoryName);
        if (res) {
            res = categoryName.getText().equals("T-shirts");
        }

        return res;
    }

}

