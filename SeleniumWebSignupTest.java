import io.qameta.allure.testng.TestInstanceParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumWebSignupTest {
    private WebDriver driver;

@Test

    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chrome-win64");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("saint");
        driver.findElement(By.id("user_email")).sendKeys("saintwudi.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();


        driver.quit();


    }
}
