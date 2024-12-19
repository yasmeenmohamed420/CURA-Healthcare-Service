package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page4_LogOutPage extends PageBase{
    public Page4_LogOutPage(WebDriver driver) {
        super(driver);
    }

    By setting = By.className("fa-bars");
    By logOut = By.cssSelector("a[href=\"authenticate.php?logout\"]");
    By checkLogOut = By.id("btn-make-appointment");


    public void settingClicked()
    {
        clickElement(setting);
    }
    public void logOut()
    {
        clickElement(logOut);
    }
    public String checkLogOut()
    {
        return getText(checkLogOut);
    }
}
