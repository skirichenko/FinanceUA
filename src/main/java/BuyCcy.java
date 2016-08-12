import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BuyCcy {

    @Test

    public void testName() throws Exception {

        String expectedResult  = "49 700,82";

        WebDriver driver = new FirefoxDriver();
        driver.get("http://finance.i.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("html/body/div[1]/div[5]/div[2]/div/div/div[2]/div[1]/div[3]/form/table/tbody/tr[1]/th[2]/ul/li[2]/i/span")).click();
        driver.findElement(By.id("fn_s1")).clear();
        driver.findElement(By.id("fn_s1")).sendKeys("2000");

        WebElement ccy = driver.findElement(By.id("fn_c1"));
        new Select(ccy).selectByVisibleText("USD");
        WebElement rateSource = driver.findElement(By.id("fn_bank"));
        new Select(rateSource).selectByVisibleText("НБУ");

        WebElement result  = driver.findElement(By.id("fn_o1_1"));
        String actualResult = result.getAttribute("value").replace("\u00a0", " ");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

}
