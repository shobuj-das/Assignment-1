import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
    public static WebDriver driver;

    @BeforeSuite
    public void loadBrowser(){
        driver = new ChromeDriver();
    }
    @AfterSuite
    public void closeBrower(){
        driver.quit();
    }
}
