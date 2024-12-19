package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page2_LoginPage extends PageBase{
    public Page2_LoginPage(WebDriver driver) {
        super(driver);
    }

    By getUserLocator = By.xpath("//div[@class=\"input-group\"]/input[@placeholder=\"Username\"]");
    By userNameLocator = By.xpath("//div[@class=\"col-sm-8\"]/input[@placeholder=\"Username\"]");
    By passLocator = By.xpath("//div[@class=\"col-sm-8\"]/input[@id=\"txt-password\"]");
    By login = By.className("btn-default");
    By loginField = By.className("text-danger");

    public String getUserLocator()
    {
        return getText(getUserLocator);
    }
    public void setUserName(String text)
    {
        setText(userNameLocator,text);
    }

    public void passLocator(String text)
    {
        setText(passLocator,text);
    }
    public void loginButton()
    {
        clickElement(login);
    }
    public String loginFieldMsg()
    {
        return getText(loginField);
    }
}
