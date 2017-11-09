package pages;

import helpers.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SubmitPage {
    private By inputName = By.name("name");
    private By inputPhone = By.name("phone");
    private By inputEmail = By.name("email");
    private By inputCity = By.name("city");
    private By inputUsername = By.xpath("//form[@class='ajaxsubmit']//input[@name='username']");
    private By inputPassword = By.xpath("//form[@class='ajaxsubmit']//input[@name='password']");
    private By buttonSubmit = By.xpath("//form[@class='ajaxsubmit']//input[@type='submit']");
    private WebDriver driver;

    public SubmitPage(WebDriver driver) {
        this.driver = driver;
    }

    public void submit() {

        driver.findElement(inputName).sendKeys(Helper.getRandomString(10));
        driver.findElement(inputPhone).sendKeys(Helper.getRandomString(10));
        driver.findElement(inputEmail).sendKeys(Helper.getRandomString(10) + "@gmail.com");
        driver.findElement(inputCity).sendKeys(Helper.getRandomString(10));
        driver.findElement(inputUsername).sendKeys(Helper.getRandomString(10));
        driver.findElement(inputPassword).sendKeys(Helper.getRandomString(10));
        driver.findElement(buttonSubmit).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(buttonSubmit));
    }
}