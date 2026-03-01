package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class InventoryPage {
    private WebDriver driver;
    public InventoryPage(WebDriver driver){
        this.driver=driver;
    }

    private final By pagetilte = By.xpath("//div[@class=\"app_logo\"]");
    private final By carticon = By.xpath("//a[@data-test='shopping-cart-link']");
    private final By inventoryitem = By.xpath("//div[@data-test=\"inventory-item\"]");

    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public String getpagetitle(){
        return driver.findElement(pagetilte).getText();
    }
    public boolean isCartIconDisplayed(){
        return driver.findElement(carticon).isDisplayed();
    }
    public int getItemsCount(){
        List<WebElement> items = driver.findElements(inventoryitem);
        return items.size();
    }
    public void openCartPage(){
        driver.findElement(carticon).click();
    }
    public void addProductToCart(String productName) {

        String dynamicXpath =
                "//div[text()='" + productName + "']" +
                        "/ancestor::div[@class='inventory_item']" +
                        "//button";

        driver.findElement(By.xpath(dynamicXpath)).click();
    }
    public String getProductButtonText(String productName) {

        By button = By.xpath(
                String.format(
                        "//div[text()='%s']/ancestor::div[@class='inventory_item']//button",
                        productName));

        return driver.findElement(button).getText();
    }
}
