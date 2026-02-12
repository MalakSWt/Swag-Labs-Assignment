package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private final By username = By.id("user-name");
    private  final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.xpath("//h3[@data-test=\"error\"]");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void enterusername(String name){
        driver.findElement(username).sendKeys(name);
    }
    public void enterpassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }
    public void clicklogin(){
        driver.findElement(loginBtn).click();
    }
    public String geterrorMsg(){
        WebElement error = driver.findElement(errorMsg);
        return error.getText();
    }
    public void login(String name,String pass){
        enterusername(name);
        enterpassword(pass);
        clicklogin();
    }

}
