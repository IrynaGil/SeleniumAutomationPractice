package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddToCart extends BasePage {

    public AddToCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")
//    private WebElement menuTShirts;

//    @FindBy(xpath = "/html/body/div[1]/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")
//    private WebElement menuDresses;

//    @FindBy(className = "sf-menu")
//    private WebElement ulCategoryMenu;

//    @FindBy(className = "category-name")
//    private WebElement categoryName;

//    @FindBy(className = "product_list")
//    private WebElement ulProductList;

//    public WebElement getMenuTShirts() {
//        return menuTShirts;
//    }

//    public WebElement getMenuDresses() {
//        return menuDresses;
//    }

//    public WebElement getCategoryName() {
//        return categoryName;
//    }

//    public WebElement getUlProductList() {
//        return ulProductList;
//    }

//    public WebElement getUlCategoryMenu() {
//        return ulCategoryMenu;
//    }

}
