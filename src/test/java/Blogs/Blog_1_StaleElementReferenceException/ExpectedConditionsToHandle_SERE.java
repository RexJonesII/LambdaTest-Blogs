package Blogs.Blog_1_StaleElementReferenceException;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static utility.Helper.*;

public class ExpectedConditionsToHandle_SERE extends BaseTest {

  @Test
  public void test4_chainExpectedConditionsToHandle_SERE() {
    WebElement pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    By filterByField = By.id("task-table-filter");

    chainMultipleExpectedConditions(filterByField, "in progress");
    driver.navigate().back();
    pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    chainMultipleExpectedConditions(filterByField, "completed");
  }
}
