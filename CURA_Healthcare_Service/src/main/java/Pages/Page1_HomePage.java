package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page1_HomePage extends PageBase{
    public Page1_HomePage(WebDriver driver) {
        super(driver);
    }

    By goToLogin = By.id("btn-make-appointment");
    public void clickToLogin()
    {
        clickElement(goToLogin);
    }
}
