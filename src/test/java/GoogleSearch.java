import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearch extends DriverSetup{
    ExcelFileHandle exlFile;
//    public static void main(String[] args) throws InterruptedException {
//        String url = "https://www.google.com";
//        driver.get(url);
//        By searchLocator = By.name("q");
//        driver.findElement(searchLocator).sendKeys("Hello");
//        Thread.sleep(3000);
//    }
    @Test
    public void Google() throws InterruptedException{

        List<String> searchValues = new ArrayList<>(); // store search data from excel file

        searchValues.add("Dhaka");
        searchValues.add("BPL");
        searchValues.add("University");

//        values = exlFile.readExcelFile();
//        System.out.println(values);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By searchLocator = By.name("q");
        By bengaliToEnglish = By.xpath("//a[normalize-space()='English']");

        String url = "https://www.google.com";
        driver.get(url);

        //change to english
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(bengaliToEnglish));
            driver.findElement(bengaliToEnglish).click();
        }
        catch (Exception e){
            System.out.println("element not found in time");
        }
        System.out.println(driver.getTitle());

        for(String searchKey: searchValues){
            driver.findElement(searchLocator).sendKeys(searchKey);
            Thread.sleep(3000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[role='listbox'] li")));

            List<WebElement> suggestions = driver.findElements(By.cssSelector("ul[role='listbox'] li"));

            System.out.println("---- " + searchKey +" -----" );
            for (WebElement suggestion : suggestions) {
                System.out.println(suggestion.getText());
            }
            driver.findElement(searchLocator).clear();
            suggestions.clear();
        }

    }

}
