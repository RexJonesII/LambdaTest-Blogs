package Blogs.Blog_1_StaleElementReferenceException;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExampleStaleElementReferenceException extends BaseTest {

  @Test
  public void createStaleElementReferenceException() {
    WebElement pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    WebElement filterByField = driver.findElement(By.id("task-table-filter"));

    filterByField.sendKeys("in progress");
    driver.navigate().back();
    pageLink.click();
    filterByField.sendKeys("completed");
  }
}
