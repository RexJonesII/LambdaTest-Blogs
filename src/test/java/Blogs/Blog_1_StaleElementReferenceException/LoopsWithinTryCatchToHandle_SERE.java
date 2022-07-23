package Blogs.Blog_1_StaleElementReferenceException;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static utility.Helper.*;

public class LoopsWithinTryCatchToHandle_SERE extends BaseTest {

  @Test
  public void test2_WhileLoopToHandle_SERE() {
    WebElement pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    By filterByField = By.id("task-table-filter");

    retryUsingWhileLoop_TryCatch(filterByField, "in progress");
    driver.navigate().back();
    pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    retryUsingWhileLoop_TryCatch(filterByField, "completed");
  }

  @Test
  public void test3_ForLoopToHandle_SERE() {
    WebElement pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    By filterByField = By.id("task-table-filter");

    retryUsingForLoop_TryCatch(filterByField, "in progress");
    driver.navigate().back();
    pageLink = driver.findElement(By.linkText("Table Data Search"));
    pageLink.click();
    retryUsingForLoop_TryCatch(filterByField, "completed");
  }
}
