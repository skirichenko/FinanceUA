import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BuyCurrency {

    @Test

    public void testName() throws Exception {

        String expectedResult  = "50 230,28";

        WebDriver driver = new FirefoxDriver();
        driver.get("http://finance.i.ua/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//table[@class='converter']//span[text()='купить']")).click();
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
