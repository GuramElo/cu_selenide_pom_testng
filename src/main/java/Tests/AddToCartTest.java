package Tests;

import Commons.BaseTest;
import Pages.OverallLayoutPage;
import Pages.SignInPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SignInTest.class);

    @Test
    public void addRandomMonitorToCart() throws InterruptedException {
        logger.info("Running Test 1");
        driver.get("https://www.demoblaze.com");
        OverallLayoutPage overallLayoutPage = new OverallLayoutPage(driver);
        Thread.sleep(800);
        SignInPage signInPage = overallLayoutPage.signIn("admin", "admin");
        Thread.sleep(800);
        overallLayoutPage.clickHome();
        Thread.sleep(800);
        overallLayoutPage.filterCatalogByMonitors();
        Thread.sleep(800);
        overallLayoutPage.openNthItemInCatalog(1);
        Thread.sleep(800);
        overallLayoutPage.addCurrentCatalogItemToCart();
        Thread.sleep(800);
        overallLayoutPage.assertCartAddingActionSuccess();
        Thread.sleep(800);
        overallLayoutPage.openCart();
        Thread.sleep(2000);
    }
}
