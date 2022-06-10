import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

   //import the selenium webdriver
    private WebDriver driver;

    @BeforeTest
    public void start () throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        // 1. Open chromedriver
        driver = new ChromeDriver();

        //2. input selenium demo page url
        driver.get("https://selenium-blog.herokuapp.com/");
        // Test 1 verify correct url
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
        // 3. maximize window
        driver.manage().window().maximize();
        //4. click on signup button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 0)
    public void positiveSignup () throws InterruptedException {
        // Test 3: Verify user can signup successfully with valid details
        // 5. input username
            driver.findElement(By.id("user_username")).sendKeys("Bimbola48");
        // 6. input email
            driver.findElement(By.id("user_email")).sendKeys("bimbola48@mailinator.com");
        // 7. input password
            driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. click on signup button
            driver.findElement(By.id("submit")).click();
            Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void clickUser1Item () throws InterruptedException {
        //9 click on user1 item on the List page
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct User1page");
        else
            //fail
            System.out.println("Wrong User1page");
        Thread.sleep(5000);

        //Test 2 verify user is directed to sign up page when click on  the signup button
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

        @Test (priority = 2)
        public void verifyItem() throws InterruptedException {
            //10 search for an item (learn Xpath) and confirm presence
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            String expectedPageUrl = "https://selenium-blog.herokuapp.com/articles/59";
            String actualPageUrl = driver.getTitle();
            if (actualPageUrl.contains(expectedPageUrl))
                //pass
                System.out.println("Correct LearnXpathPage");
            else
                //fail
                System.out.println("Wrong LearnXpathPage");
            Thread.sleep(5000);
        }

        @Test (priority = 3)
        public void logoutSuccessfully () throws InterruptedException {
           //11 click on logout
                driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
                // Test: Verify when user logs out they are re-directed to the homepage
            String expectedTitle = "AplhaBlog";
            String actualTitle = driver.getTitle();
            if (actualTitle.contains(expectedTitle))
                //pass
                System.out.println("Correct Title");
            else
                //fail
                System.out.println("Wrong Title");
            Thread.sleep(5000);
            }

    @Test (priority = 4)
    public void negativeSignupInvalidUsername () throws InterruptedException {
        //4. click on signup button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //5. input username
        //Test 3 username less than 3 characters
        driver.findElement(By.id("user_username")).sendKeys("Bi");
        // 6. input email
        driver.findElement(By.id("user_email")).sendKeys("bimbola60@mailinator.com");
        //7. input password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }



    @Test (priority = 5)
    public void negativeSignupinvalidPassword () throws InterruptedException {
        //4. click on signup button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. input username
        driver.findElement(By.id("user_username")).sendKeys("Bimbola83");
        // 6. input email
        driver.findElement(By.id("user_email")).sendKeys("bimbola83@mailinator.com");
        //7. input password
        // Test invalid password of two characters
        driver.findElement(By.id("user_password")).sendKeys(" /");
        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void negativeSignupemptyFields() throws InterruptedException {
        //4. click on signup button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. input username
        driver.findElement(By.id("user_username")).sendKeys(" ");
        // 6. input email
        driver.findElement(By.id("user_email")).sendKeys(" ");
        //7. input password
        // Test invalid password of two characters
        driver.findElement(By.id("user_password")).sendKeys(" ");
        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 7)
    public void negativeSignupinvalidEmail () throws InterruptedException {
        //4. click on signup button
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //5. input username
        driver.findElement(By.id("user_username")).sendKeys("Bimbola90");
        // 6. input email
        //Test 3 invalid email
        driver.findElement(By.id("user_email")).sendKeys("bimbola51@mailinator");
        //7. input password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        // 8. click on signup button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        //12. Quit the browser
            driver.quit();
    }





}


//Test
//verify user uses the right url









