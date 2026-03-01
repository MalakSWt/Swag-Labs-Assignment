package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {
    @Test
    public void verifysocialLinks(){
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.openCartPage();
        String originalWindow = driver.getWindowHandle();
        cartPage.openLinkedIn();
        cartPage.switchToNewTab();
        String linkediUrl = driver.getCurrentUrl();
        Assert.assertTrue(linkediUrl.contains("linkedin"),"Your are not on linkedIn Page");
        driver.close();
        driver.switchTo().window(originalWindow);
        cartPage.openFacebook();
        cartPage.switchToNewTab();
        String facebookUrl = driver.getCurrentUrl();
        Assert.assertTrue(facebookUrl.contains("facebook"),"Your are not on facebook Page");
        driver.close();
        driver.switchTo().window(originalWindow);
        cartPage.openTwitter();
        cartPage.switchToNewTab();
        String twitterUlr = driver.getCurrentUrl();
        Assert.assertTrue(twitterUlr.contains("x.com"),"Your are not on facebook Page");
        driver.close();
        driver.switchTo().window(originalWindow);

    }
    @Test
    public void verifyCartIsEmpty(){
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.openCartPage();
        assertEquals(cartPage.getCartItemsCount(),0,"Cart is not Empty");
    }
    @Test
    public void verifyAddingspecificprducts(){
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        inventoryPage.addProductToCart("Sauce Labs Onesie");
        inventoryPage.openCartPage();
        List<String> actualProducts = cartPage.getAllProductNamesInCart();
        List<String> expectedProducts = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Onesie"
        );

        Assert.assertEquals(actualProducts, expectedProducts,
                "Cart products do not match expected products");

    }
    @Test
    public void removeproductfromcart(){
        verifyAddingspecificprducts();
        cartPage.removeProductFromCart("Sauce Labs Bolt T-Shirt");
        cartPage.backToInventoryPage();
        assertEquals(inventoryPage.getProductButtonText("Sauce Labs Bolt T-Shirt"),"Add to cart");
        assertEquals(inventoryPage.getProductButtonText("Sauce Labs Backpack"),"Remove");
        assertEquals(inventoryPage.getProductButtonText("Sauce Labs Backpack"),"Remove");
    }
}
