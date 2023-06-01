import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomationProject1_SignUp_Login {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        RandomEmailGenerator random = new RandomEmailGenerator();

        String usrName = random.generateRandomUsername();
        String firstN = random.generateRandomFirstName();
        String lastN = random.generateRandomLastName();
        String email = random.generateRandomEmail();
        String password = random.generateRandomPassword(10);
        String firstAndLast = firstN+" "+lastN;

        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");

        String expectedTitle = "Welcome to Duotify!";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);


        driver.findElement(By.xpath("//*[@id=\"hideLogin\"]")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"http://duotify.us-east-2.elasticbeanstalk.com/register.php");



        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usrName);

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(firstN);

        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys(lastN);

        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(email);
        driver.findElement(By.xpath("//*[@id=\"email2\"]")).sendKeys(email);

        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"password2\"]")).sendKeys(password);

        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"registerForm\"]/button")).click();


        String expectedUrl = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php?";
        String actualUrl = driver.getCurrentUrl();
        Thread.sleep(1000);

        Assert.assertEquals(actualUrl, expectedUrl);
        Thread.sleep(1000);
        System.out.println("Successfully registered and logged in");
        System.out.println();

        String webNameFirstAndLast = driver.findElement(By.id("nameFirstAndLast")).getText();

        Thread.sleep(1000);
       Assert.assertEquals(webNameFirstAndLast, firstAndLast);

        System.out.println("Actual name: "+webNameFirstAndLast+ "\nExpected name: "+ firstAndLast);
        System.out.println();


        driver.findElement(By.xpath("//*[@id=\"nameFirstAndLast\"]")).click();
        Thread.sleep(1000);



        String webName2 = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(webName2, firstAndLast);
        System.out.println("Actual name on the main window: "+webName2+ "\nExpected name: "+ firstAndLast);
        System.out.println();

        driver.findElement(By.xpath("//*[@id=\"rafael\"]")).click();
        System.out.println("Logged out");
        System.out.println();

        String expectedUrl2 = "http://duotify.us-east-2.elasticbeanstalk.com/register.php";
        String actualUrl2 = driver.getCurrentUrl();
        Thread.sleep(1000);

        Assert.assertEquals(actualUrl, expectedUrl);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"loginUsername\"]")).sendKeys(usrName);
        driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/button")).click();
        System.out.println("Logged in with the same credentials");
        System.out.println();

        Thread.sleep(1000);

        String actualText = driver.findElement(By.tagName("h1")).getText();
        String expectedText = "You Might Also Like";

        Assert.assertEquals(actualText, expectedText);
        System.out.println("Successful login verified");



        driver.findElement(By.xpath("//*[@id=\"nameFirstAndLast\"]")).click();
        Thread.sleep(1000);
        System.out.println();


        driver.findElement(By.xpath("//*[@id=\"rafael\"]")).click();
        System.out.println("Logged out");


    }
}
