package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataDriven;

public class LoginTest extends BaseTest {
    @Test
    public void validLogin(){
    String[] data = DataDriven.jsonReader("validUser");
    loginPage.login(data[0],data[1]);
    Assert.assertTrue(inventoryPage.getUrl().contains("inventory.html"),"You are not in the Inventory Page");
    }
    @Test
    public void invalidLogin(){
        String[] data = DataDriven.jsonReader("invalidUser");
        loginPage.login(data[0],data[1]);
        Assert.assertTrue(loginPage.geterrorMsg().contains("Username and password do not match"),"This is a wrong error message");
    }
    @Test
    public void loginWithoutPassword(){
        String[] data = DataDriven.jsonReader("emptyPassword");
        loginPage.login(data[0],data[1]);
        Assert.assertTrue(loginPage.geterrorMsg().contains("Password is required"),"This is a wrong error message");
    }
}
