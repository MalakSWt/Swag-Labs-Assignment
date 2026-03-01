package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;
    By facebookIcon = By.xpath("//a[@data-test=\"social-facebook\"]");
    By twitterIcon = By.xpath("//a[@data-test=\"social-twitter\"]");
    By linkdInIcon = By.xpath("//a[@data-test=\"social-linkedin\"]");
    By cartItems = By.className("cart_item");
    By continueShopping = By.id("continue-shopping");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void openFacebook(){
        driver.findElement(facebookIcon).click();
    }
    public void openTwitter(){
        driver.findElement(twitterIcon).click();
    }
    public void openLinkedIn(){
        driver.findElement(linkdInIcon).click();
    }
    public int getCartItemsCount(){
        return driver.findElements(cartItems).size();
    }
    public void removeProductFromCart(String productName) {

        By removeButton = By.xpath(
                String.format(
                        "//div[text()='%s']/ancestor::div[@class='cart_item']//button",
                        productName));

        driver.findElement(removeButton).click();
    }
    public void backToInventoryPage(){
        driver.findElement(continueShopping).click();
    }
    public void switchToNewTab() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }
    public List<String> getAllProductNamesInCart() {
        List<WebElement> products = driver.findElements(
                By.className("inventory_item_name"));

        List<String> productNames = new ArrayList<>();

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }

}
