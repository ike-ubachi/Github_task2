import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {

    //Import chromedriver
    private WebDriver driver;

    @BeforeTest
    public void setup() throws InterruptedException {

        //we locate the chromedriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //we open the chromedriver
        driver = new ChromeDriver();

        //Visit the Url Konga
        //we input the URL of konga page
        driver.get("https://www.konga.com/");

        //we verify that the url is correct and user is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com/"))
            //pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong webpage");

        Thread.sleep(5000);

        //We maximize the browser
        driver.manage().window().maximize();

        Thread.sleep(5000);
    }

    @Test(priority = 0)
    public void SignIn() throws InterruptedException {

        //Sign into Konga successfully
        //5. Click on Sign in button to open the Sign in page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

        Thread.sleep(5000);

        //we enter our email address
        driver.findElement(By.id("username")).sendKeys("ikeubachi@gmail.com");

        //we enter our password
        driver.findElement(By.id("password")).sendKeys("Konga8@");

        Thread.sleep(2000);

        //we click the login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();

        Thread.sleep(5000);

        System.out.println("Successfully signed in to konga");

    }


    @Test(priority = 1)

    public void AddToCart() throws InterruptedException {

        //Trying to locate macbook and add it to the cart

        //we click on Computers and accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();

        Thread.sleep(5000);

        //We then click on Laptops subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();

        Thread.sleep(5000);

        //Then we click Apple macbooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();

        Thread.sleep(5000);

        System.out.println("Located categories for Laptops");

        //We add item to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[3]/form/div[4]/button")).click();

        Thread.sleep(5000);

        System.out.println("Added a mac laptop to cart");
    }

    @Test(priority = 2)
    public void Checkout() throws InterruptedException {
        //We move to checkout
        //13. Click on the cart icon
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();

        Thread.sleep(5000);

        //we click on checkout
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();

        Thread.sleep(5000);

        System.out.println("Checked out");

    }

    @Test(priority = 3)

    public void selectAddress() throws InterruptedException {

        //Select Address
        //we click on change
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();

        Thread.sleep(5000);

        //we click on add delivery address

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();

        Thread.sleep(5000);

        //we click on the address

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();

        Thread.sleep(5000);

        //we click on Use this Address

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();

        Thread.sleep(5000);

        System.out.println("Selected Payment Address");
    }

    @Test(priority = 4)

    public void makePayment() throws InterruptedException {

        //Continue to make payment
        //we click on pay now

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();

        Thread.sleep(5000);

        //We click on continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();

        Thread.sleep(7000);

        System.out.println("Make Payment");
    }

    @Test(priority = 5)

    public void SelectCard() throws InterruptedException {

        //We need to select Card as payment method on the iFrame
        WebElement iframe = driver.findElement(By.tagName("iframe"));

        //We switch to iframe
        driver.switchTo().frame("kpg-frame-component");

        //We locate the card button
        WebElement Cardbutton = driver.findElement(By.className("Card"));
        Cardbutton.click();

        Thread.sleep(5000);

        System.out.println("Opened card payment modal");

        //Enter card details
        //we locate the card number field and enter our invalid card number

        WebElement CardNumberField = driver.findElement(By.id("card-number"));
        CardNumberField.sendKeys("5199 5098 4994 668");

        Thread.sleep(3000);

        //We locate the date field and enter an invalid date
        WebElement DateField = driver.findElement(By.id("expiry"));
        DateField.sendKeys("0424");

        Thread.sleep(3000);

        //We locate the CVV field and enter an invalid CVV
        WebElement CVVField = driver.findElement(By.id("cvv"));
        CVVField.sendKeys("075");

        Thread.sleep(3000);

        System.out.println("Enter invalid card details");

        //Print Out the error message: Invalid Card Number
        //we locate the error message
        WebElement ErrorMessage = driver.findElement(By.id("card-number_unhappy"));

        Thread.sleep(5000);

        System.out.println("Print the error message");

        //We print out the error message
        System.out.println(ErrorMessage.getText());

        Thread.sleep(5000);

        //we close the iFrame that displays the input card Modal
        WebElement CloseiFrame = driver.findElement(By.className("data-card__close"));
        CloseiFrame.click();

        System.out.println("Switch out of iframe");
        //We switch out of iFrame
        driver.switchTo().defaultContent();

        Thread.sleep(5000);
    }

        @AfterTest
        public void closeBrowser () {
            //31. Close the browser
            System.out.println("Close the browser");
            driver.quit();


        }


    }







