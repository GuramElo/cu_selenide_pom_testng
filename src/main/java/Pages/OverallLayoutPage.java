package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class OverallLayoutPage {
    private final WebDriver driver;


    private final By homeButtonSelector = By.cssSelector(".nav-link[href=\"index.html\"]");
    private final By catalogItemsWrapperSelector = By.cssSelector("#tbodyid");
    private final By catalogItemCardSelector = By.cssSelector(".card");
    private final By anchorElementWithHrefSelector = By.cssSelector("a[href]");

    private final By catalogItemContentSelector = By.cssSelector(".product-content");

    private final By addItemToCartButtonSelector = By.cssSelector("a.btn[href=\"#\"]");

    private final By headerCartHyperLinkSelector = By.xpath("//*[@class='nav-link' and contains(text(), 'Cart')]");

    public OverallLayoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public SignInPage signIn(String user, String pass) throws InterruptedException {
        SignInPage signInPage = new SignInPage(driver);
        Thread.sleep(800);
        signInPage.enterUsername(user);
        Thread.sleep(800);
        signInPage.enterPassword(pass);
        Thread.sleep(800);
        signInPage.clickOnLogin();
        Thread.sleep(800);
        signInPage.assertSuccess();
        Thread.sleep(800);
        return signInPage;
    }
    public void clickHome() {
        WebElement element = driver.findElement(homeButtonSelector);
        element.click();
    }
    public By getCategoryButtonSelectorByText(String text) {
        return By.xpath(String.format("//*[@id='itemc' and contains(text(), '%s')]", text));
    }
    public void filterCatalogByMonitors() {
        WebElement monitorsCategoryButton = driver.findElement(this.getCategoryButtonSelectorByText("Monitors"));
        monitorsCategoryButton.click();
    }
    public void openNthItemInCatalog(int n) {
        List<WebElement> elements = driver.findElement(catalogItemsWrapperSelector).findElements(catalogItemCardSelector);
        WebElement nthElement = elements.get(n - 1);
        nthElement.findElement(anchorElementWithHrefSelector).click();
    }
    public void addCurrentCatalogItemToCart() {
        WebElement button = driver.findElement(catalogItemContentSelector).findElement(addItemToCartButtonSelector);
        button.click();
    }
    public void assertCartAddingActionSuccess() {
        Assert.assertTrue(this.isCartItemAddedSuccessfully());
    }
    public Boolean isCartItemAddedSuccessfully() {
        String alertText, successText = "Product added.";
        try {
            alertText = this.driver.switchTo().alert().getText();
            this.driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            alertText = "nope";
        }
        return alertText.contains(successText);
    }
    public void openCart() {
        driver.findElement(headerCartHyperLinkSelector).click();
    }

}
