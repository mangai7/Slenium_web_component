package webcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		try {
            // Switch to the iframe containing the datepicker
            WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
            driver.switchTo().frame(iframe);

            // Open the datepicker
            driver.findElement(By.id("datepicker")).click();

            // Click to go to the next month
            driver.findElement(By.cssSelector(".ui-datepicker-next")).click();

            // Select date 22
            driver.findElement(By.xpath("//a[text()='22']")).click();

            // Get the selected date
            String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
