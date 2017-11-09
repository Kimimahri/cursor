import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SubmitPage;
import pages.MainPage;

import java.util.concurrent.TimeUnit;


public class TestTask {
    private WebDriver driver;

    @BeforeTest
    @Parameters({"url", "timeout", "driverPath"})
    public void setUp(String url, int timeout, String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"url"})
    @Test
    private void cursorTest(String url) {
        SubmitPage submitPage = new SubmitPage(driver);
        MainPage mainPage = new MainPage(driver);

        submitPage.submit();
        driver.get(url);
        mainPage.placeCursorOnSubmenu();
        Assert.assertTrue(mainPage.subMenuIsVisible());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}