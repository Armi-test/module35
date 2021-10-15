package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class MainPage {
    private final static String URL = "https://dostaevsky.ru";
    private final static String ACTUAL_CITY_XPATH = "/html/body/div[1]/div[4]/aside/nav/div/div/div[1]/div[2]/div/a[2]";
    private final static String CONFIRM_CITY_XPATH = "/html/body/div[1]/div[4]/aside/nav/div/div/div[1]/div[1]/div/div[2]/button[1]";
    private final static String SEARCH_FIELD_XPATH = "/html/body/div[1]/header/div[3]/div[3]/div[1]/input";
    private final static String REAL_MESSAGE_XPATH = "/html/body/div[1]/div[4]/div/main/div[1]/div/div[1]";
    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void go() {
        webDriver.get(URL);
    }

    public void confirmCity() {
        webDriver.findElement(By.xpath(CONFIRM_CITY_XPATH)).click();
    }

    public void assertCity(String expectedCity) {
        final var actualCity = webDriver.findElement(By.xpath(ACTUAL_CITY_XPATH)).getText();
        assertEquals(expectedCity, actualCity);
    }

    public void unexistingDish(String dish) {
        webDriver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(dish);
    }

    public void notificationOfUser (String message) {
        WebElement dynamicElement = (new WebDriverWait(webDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[4]/div/main/div[1]/div/div[1]")));
        final var realMessage = webDriver.findElement(By.xpath(REAL_MESSAGE_XPATH)).getText();
        assertEquals(realMessage, message);
    }
}
