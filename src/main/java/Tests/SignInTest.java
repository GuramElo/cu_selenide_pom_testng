package Tests;

import Commons.BaseTest;
import Pages.SignInPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(SignInTest.class);

    @Test
    public void positiveLogin() throws InterruptedException {
        logger.info("Running Test 1");
        driver.get("https://www.demoblaze.com");
        SignInPage signInPage = new SignInPage(driver);
        Thread.sleep(800);
        signInPage.enterUsername("admin");
        Thread.sleep(800);
        signInPage.enterPassword("admin");
        Thread.sleep(800);
        signInPage.clickOnLogin();
        Thread.sleep(800);
        signInPage.assertSuccess();
        Thread.sleep(800);
    }

    @Test
    public void NegativeLogin() throws InterruptedException {
        logger.warn("WARNING WARNING");
        driver.get("https://www.demoblaze.com");
        Thread.sleep(800);
        SignInPage signInPage = new SignInPage(driver);
        Thread.sleep(800);
        signInPage.enterUsername("asjdhjashdjajdjasdsdas");
        Thread.sleep(800);
        signInPage.enterPassword("asdasdasdasdadasd");
        Thread.sleep(800);
        signInPage.clickOnLogin();
        Thread.sleep(800);
        signInPage.assertSuccess();
        Thread.sleep(800);
    }
}
