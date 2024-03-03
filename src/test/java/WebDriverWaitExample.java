import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testWaitForElementVisible() {
        driver.get("https://play1.automationcamp.ir/expected_conditions.html");

        WebElement button = driver.findElement(By.id("visibility_trigger"));
        button.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement button2 = driver.findElement(By.cssSelector(".btn.btn-danger"));
        button2.click();


        String successMessage = driver.findElement(By.cssSelector("div.popover-body")).getText();
        assert successMessage.contains("I just removed my invisibility cloak!!");
    }
}

