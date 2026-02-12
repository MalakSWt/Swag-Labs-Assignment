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
}
