package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    private static final WebDriver webDriver;
    private static final MainPage mainPage;

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\olga-\\untitled1\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        mainPage = new MainPage(webDriver);
    }

    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        mainPage.go();
    }

    @When("website is open confirm city")
    public void website_is_open_confirm_city() {
        mainPage.confirmCity();
    }

    @Then("assert chosen city is {string}")
    public void assert_chosen_city_is(String city) {
        mainPage.assertCity(city);
    }

    @Then("search for {string}")
    public void search_for(String dish) {
        mainPage.unexistingDish(dish);
    }

    @Then("make sure user is notified {string}")
    public void make_sure_user_is_notified(String message) {
        mainPage.notificationOfUser(message);
    }
}