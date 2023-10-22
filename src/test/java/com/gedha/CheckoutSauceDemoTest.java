package com.gedha;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.gedha.drivers.DriverSingelton;
import org.gedha.pages.Checkout;
import org.gedha.pages.LoginSouceDemo;
import org.gedha.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutSauceDemoTest {

    private static WebDriver driver;
    private static LoginSouceDemo loginSouceDemo;
    private static Checkout checkout;


    @BeforeAll
    public static void setUp(){
        DriverSingelton .getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        loginSouceDemo = new LoginSouceDemo();
        checkout = new Checkout();
    }

    @AfterAll
    public static void  finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    @Given("user on page check out step one")
    public void go_to_website(){
        driver.get(Constants.URLSAUCEDEMO);
        loginSouceDemo.quickLogin("standard_user","secret_sauce");
        checkout.quickAddtoCart();
    }

    @And("user input valid firstname")
    public void handleFistName(){
        checkout.setInputFirstname("Zahra");
    }
    @And("user input valid lastname")
    public void handleLastName(){
        checkout.setInputLastname("Ramadhan");
    }
    @And("user input valid postal code")
    public void handlePostal(){
        checkout.setInputPostal("10670");
    }

    @And("user click continue")
    public void handleBtnContinue(){
        checkout.handleBtnContiune();
    }

    @And("user redirect to checkout step two")
    public void redirect_to_step2(){
        String step2 = checkout.getTextStep2();
        Assert.assertEquals(step2,"Checkout: Overview");
    }

    @And("user click finish")
    public void user_click_finish(){
        checkout.handleBtnFinish();
    }

    @Then("checkout complete")
    public void redirect_to_complete_page(){
        String finish = checkout.getTextFinish();
        Assert.assertEquals(finish, "Thank you for your order!");
    }

    @Then("show error lastname required")
    public void err_lastname_req(){
        String reqLastname = checkout.getErrLastName();
        Assert.assertEquals(reqLastname, "Error: Last Name is required");
    }


}
