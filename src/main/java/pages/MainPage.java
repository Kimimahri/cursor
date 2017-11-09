package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    private WebDriver driver;
    private By menuWithSubMenu = By.xpath("//a[contains(text(), 'Menu With Sub Menu')]");
    private By iframe = By.xpath("//iframe[@src='menu/defult2.html']");
    private By subMenuButton = By.id("ui-id-2");
    private By subMenu = By.xpath("//*[@id='ui-id-2']/ul");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void placeCursorOnSubmenu() {
        driver.findElement(menuWithSubMenu).click();
        driver.switchTo().frame(driver.findElement(iframe));
        driver.findElement(subMenuButton).click();
    }

    public boolean subMenuIsVisible() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(subMenu));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
