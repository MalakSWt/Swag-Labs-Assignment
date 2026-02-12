package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataDriven;

public class InventoryTest extends BaseTest {
    @Test
    public void inventoryTest1(){
        String[] data = DataDriven.jsonReader("validUser");
        loginPage.login(data[0],data[1]);
        Assert.assertEquals(inventoryPage.getpagetitle(),"Swag Labs","Your are in the wrong page");
        Assert.assertTrue(inventoryPage.isCartIconDisplayed(),"The cart icon is not displayed");
        Assert.assertEquals(inventoryPage.getItemsCount(),6,"The displayed products not equal 6");
    }
}
