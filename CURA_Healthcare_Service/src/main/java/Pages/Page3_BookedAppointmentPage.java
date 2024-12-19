package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page3_BookedAppointmentPage extends PageBase{
    public Page3_BookedAppointmentPage(WebDriver driver) {
        super(driver);
    }
    By checkLogin = By.xpath("//div[@class=\"col-sm-12 text-center\"]/h2");
    By clickChoice = By.className("input-group-addon");
    //By day = By.xpath("//div[@class=\"datepicker-days\"]/table[@class=\"table-condensed\"]/tbody/tr[6]/td[2]0");
    By day = By.xpath("//*[text()='31']");
    By bookedTime = By.id("btn-book-appointment");
    By bookedChecked= By.cssSelector("div[class=\"col-xs-12 text-center\"] h2");

    public String checkLogin()
    {
        return getText(checkLogin);
    }
    public void clickChoice()
    {
        clickElement(clickChoice);
    }

    public void day()
    {
        clickElement(day);
    }
    public void bookTime()
    {
        clickElement(bookedTime);
    }
    public String bookedChecked()
    {
        return getText(bookedChecked);
    }
}
