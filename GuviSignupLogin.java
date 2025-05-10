package webcomponent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class GuviSignupLogin {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // 1. Launch the website
            driver.get("https://www.guvi.in/");
            driver.manage().window().maximize();

            // 2. Click on the "Sign up" button on the top right
            WebElement signupBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign up']")));
            signupBtn.click();

            // 3. Fill signup form
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("Test Userd");
            driver.findElement(By.id("email")).sendKeys("testuser121302@example.com"); // use a unique email
            driver.findElement(By.id("password")).sendKeys("TestPassword123");
            driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");

            // 4. Click on Signup button inside the modal
            driver.findElement(By.id("signup-btn")).click();
            
            Thread.sleep(2000);
            Select profile = new Select(driver.findElement(By.id("profileDrpDwn")));
            profile.selectByVisibleText("Student");
            
            
            Select degree = new Select(driver.findElement(By.id("degreeDrpDwn")));
            degree.selectByVisibleText("B.E. / B.Tech. Computer Science");
            		
        
            		
            driver.findElement(By.id("year")).sendKeys("2025");
            driver.findElement(By.id("details-btn")).click();
            // 5. Wait for successful registration (adjust this check based on the actual response page)
            wait.until(ExpectedConditions.titleContains("GUVI"));
            
            driver.navigate().to("https://www.guvi.in/");
            // 6. Click on the "Login" button
            WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-btn")));
            loginBtn.click();

            // 7. Fill login form with same credentials
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("testuser121302@example.com");
            driver.findElement(By.id("password")).sendKeys("TestPassword123");

            // 8. Click Login inside the modal
            driver.findElement(By.id("login-btn")).click();

            // 9. Wait for login to complete (again adjust the condition)
            wait.until(ExpectedConditions.titleContains("GUVI"));

            System.out.println("Signup and Login automated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
	}

}
