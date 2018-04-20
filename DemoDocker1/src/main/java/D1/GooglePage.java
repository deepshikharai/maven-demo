package D1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
 
    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "input.lsb")
    private WebElement searchButton;

    @FindBy(className = "rc")
    private List<WebElement> searchResults;

    @FindBy(id = "foot")
    private WebElement footer;

    public GooglePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 60);
    }

    public void goTo() {
    	//Website to be tested
        this.driver.get("https://www.google.com");
    }

    public void searchFor(String text) throws InterruptedException {
    	System.out.println("in parentclass");
    	System.out.println("Page Title: "+driver.getTitle());
    	Thread.sleep(10000);
        this.searchBox.sendKeys(text);
        System.out.println("Text entered");
        wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
        this.searchButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("rc")));
        System.out.println("out of parent class");
    }

   public List<WebElement> getResults() {
        return this.searchResults;
    }

}