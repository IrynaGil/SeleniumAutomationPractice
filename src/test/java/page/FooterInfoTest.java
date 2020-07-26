package page;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FooterInfoTest extends BaseTest {
    private FooterInfo page;

    @Test
    public void CheckStoreInformation() {
        page = new FooterInfo(getDriver());

        //Open the web-site
        page.openURL("http://automationpractice.com");

        //Find the "Store Information" footer section list and check that number of lines >0
        WebElement ulStoreInfoList = getDriver().findElement(By.xpath("/html/body/div[1]/div[3]/footer/div/section[6]/div"));
        assertTrue(page.isElementVisible(ulStoreInfoList), "Store info is not found");

        List<WebElement> storeInfoList = ulStoreInfoList.findElements(By.tagName("li"));
        assertTrue(storeInfoList.size() > 0, "Store info is not found");

        //Identify the Address line and check if info is correct
        WebElement liAddress = storeInfoList.get(0);
        assertTrue(page.isElementVisible(liAddress), "Store address is not found");
        assertEquals(liAddress.getText(), "Selenium Framework, Research Triangle Park, North Carolina, USA", "Wrong store address is displayed");

        //Identify the Telephone line and check if info is correct
        WebElement liTelephone = storeInfoList.get(1);
        assertTrue(page.isElementVisible(liTelephone), "Telephone number is not found");
        assertEquals(liTelephone.getText(), "Call us now: (347) 466-7432", "Wrong telephone information is displayed");

        //Identify the Email line and check if info is correct
        WebElement liEmail = storeInfoList.get(2);
        assertTrue(page.isElementVisible(liEmail), "Email is not found");
        assertEquals(liEmail.getText(), "Email: support@seleniumframework.com", "Wrong email is displayed");
    }
}
