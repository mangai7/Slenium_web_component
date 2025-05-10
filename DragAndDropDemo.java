package webcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		
		
        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to the jQueryUI droppable URL
        driver.get("https://jqueryui.com/droppable/");

        try {
            // Switch to the iframe that contains the draggable and droppable elements
            WebElement iframe = driver.findElement(By.cssSelector(".demo-frame"));
            driver.switchTo().frame(iframe);

            // Identify the source (draggable) and target (droppable) elements
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            // Perform drag and drop
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();

            // Verify drop success by checking the changed text
            String droppedText = target.getText();
            if (droppedText.equals("Dropped!")) {
                System.out.println("Drag and Drop operation successful!");
            } else {
                System.out.println("Drag and Drop operation failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
