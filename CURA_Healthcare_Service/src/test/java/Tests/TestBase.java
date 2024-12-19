package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestBase {

    public WebDriver driver;

    @BeforeTest
    @Parameters({"browser","URL"})
    public void setUp(@Optional("Chrome") String browser, @Optional("https://www.google.com") String URL) throws InterruptedException {
        if (browser.equals("Edge")) {
            this.driver = new EdgeDriver();
        } else if (browser.equals("Chrome"))
        {
            this.driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        this.driver.get(URL);

    }


    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
