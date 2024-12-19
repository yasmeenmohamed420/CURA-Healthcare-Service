package Tests;

import Pages.Page1_HomePage;
import Pages.Page2_LoginPage;
import Pages.Page3_BookedAppointmentPage;
import Pages.Page4_LogOutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookedAppointmentTests extends TestBase
{
    @Test
    public void TC1_ValidLogin() throws InterruptedException
    {
        Page1_HomePage page1 = new Page1_HomePage(driver);
        Page2_LoginPage page2 = new  Page2_LoginPage(driver);
        Page3_BookedAppointmentPage page3 = new Page3_BookedAppointmentPage(driver);
        Page4_LogOutPage page4 = new Page4_LogOutPage(driver);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        page1.clickToLogin();

        page2.setUserName("John Doe");
        page2.passLocator("ThisIsNotAPassword");
        page2.loginButton();

        String Text1 = page3.checkLogin();
        System.out.println(Text1);
        Assert.assertEquals(Text1,"Make Appointment","Failed Login");
        Assert.assertTrue(driver.getCurrentUrl().contains("appointment"), "Login failed");

        page3.clickChoice();
        page3.day();
        page3.bookTime();
        String Text2 = page3.bookedChecked();
        System.out.println(Text2);
        Assert.assertEquals(Text2,"Appointment Confirmation","Failed");
        Assert.assertTrue(driver.getCurrentUrl().contains("summary"), "Appointment is not booked Successfully");

        page4.settingClicked();
        page4.logOut();
        String Text3 = page4.checkLogOut();
        System.out.println(Text3);
        Assert.assertEquals(Text3,"Make Appointment","Failed");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/","LoginOut failed");
    }

    @Test
    public void TC2_InvalidUsername() throws InterruptedException
    {
        Page1_HomePage page1 = new Page1_HomePage(driver);
        Page2_LoginPage page2 = new  Page2_LoginPage(driver);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        page1.clickToLogin();

        page2.setUserName("WrongUser");
        page2.passLocator("ThisIsNotAPassword");
        page2.loginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login failed with invalid username");
        Assert.assertEquals(page2.loginFieldMsg(),"Login failed! Please ensure the username and password are valid.","Login failed with invalid password");
    }

    @Test
    public void TC3_InvalidPassword() throws InterruptedException
    {
        Page1_HomePage page1 = new Page1_HomePage(driver);
        Page2_LoginPage page2 = new  Page2_LoginPage(driver);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        page1.clickToLogin();

        page2.setUserName("John Doe");
        page2.passLocator("WrongPassword");
        page2.loginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login failed with invalid password");
        Assert.assertEquals(page2.loginFieldMsg(),"Login failed! Please ensure the username and password are valid.","Login failed with invalid password");
    }

    @Test
    public void TC4_EmptyUsernameAndPassword() throws InterruptedException
    {
        Page1_HomePage page1 = new Page1_HomePage(driver);
        Page2_LoginPage page2 = new  Page2_LoginPage(driver);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        page1.clickToLogin();

        page2.setUserName("");
        page2.passLocator("");
        page2.loginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login should have failed with empty credentials");
        Assert.assertEquals(page2.loginFieldMsg(),"Login failed! Please ensure the username and password are valid.","Login failed with invalid password");
    }

    @Test
    public void TC5_InvalidUsernameAndPassword() throws InterruptedException
    {
        Page1_HomePage page1 = new Page1_HomePage(driver);
        Page2_LoginPage page2 = new  Page2_LoginPage(driver);

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");
        page1.clickToLogin();

        page2.setUserName("WrongUser");
        page2.passLocator("WrongPassword");
        page2.loginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login should have failed with empty credentials");
        Assert.assertEquals(page2.loginFieldMsg(),"Login failed! Please ensure the username and password are valid.","Login failed with invalid password");
    }
}
