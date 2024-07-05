package Pages;

import org.openqa.selenium.*;
import org.testng.Assert;

public class SignInPage {

    private final WebDriver driver;

    // WebElements Locators
    private final By loginModalTriggetLocator = By.id("login2");
    private final By usernameLocator = By.id("loginusername");
    private final By passwordLocator = By.id("loginpassword");
    private final By loginButtonLocator = By.xpath("/html/body/div[3]/div/div/div[3]/button[2]");

    private final By cancelButtonLocato = By.xpath("/html/body/div[3]/div/div/div[3]/button[1]");

    // Constructor
    public SignInPage(WebDriver driver) {

        this.driver = driver;

        this.openLoginModal();

    }
    public void assertSuccess() {
        Assert.assertTrue(this.isLoginSuccessful());
    }
    public void openLoginModal() {
        this.driver.findElement(this.loginModalTriggetLocator).click();
    }

    public Boolean isLoginSuccessful(){
        boolean alertPresent;
        try {
            this.driver.switchTo().alert();
            alertPresent = true;
        } catch (NoAlertPresentException e) {
            alertPresent = false;
        }

        return !alertPresent;

    }
    public void enterUsername(String username) {
        WebElement usernameElement = driver.findElement(usernameLocator);
        usernameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys(password);
    }

    public void clickOnLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickOnCancel() {
        driver.findElement(cancelButtonLocato).click();
    }
}
