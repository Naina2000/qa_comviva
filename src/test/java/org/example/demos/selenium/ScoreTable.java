package org.example.demos.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ScoreTable {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver for Firefox
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the cricket scorecard page
        driver.get("https://www.espncricinfo.com/series/india-in-south-africa-2023-24-1387592/south-africa-vs-india-2nd-test-1387604/full-scorecard");

        // Locate the second innings scorecard table
        List<WebElement> scorecardTables = driver.findElements(By.className("ci-scorecard-table"));
        WebElement secondInningsTable = scorecardTables.get(1);

        // Extract and display table headers
        WebElement tableHeader = secondInningsTable.findElement(By.tagName("thead"));
        WebElement headerRow = tableHeader.findElement(By.tagName("tr"));
        List<WebElement> headerColumns = headerRow.findElements(By.tagName("th"));

        for (WebElement header : headerColumns) {
            System.out.print(header.getText() + "\t\t\t");
        }
        System.out.println();

        // Extract and display table rows and columns
        List<WebElement> rows = secondInningsTable.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            for (WebElement column : columns) {
                System.out.print(column.getText() + "\t\t");
            }
            System.out.println();
        }

        // Close the WebDriver
        driver.quit();
    }
}

