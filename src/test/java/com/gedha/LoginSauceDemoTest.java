package com.gedha;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.gedha.drivers.DriverSingelton;
import org.gedha.pages.LoginSouceDemo;
import org.gedha.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSauceDemoTest {

    private static WebDriver driver;
    private static LoginSouceDemo loginSouceDemo;


    @BeforeAll
    public static void setUp(){
        DriverSingelton .getInstance(Constants.Chrome);
        driver = DriverSingelton.getDriver();
        loginSouceDemo = new LoginSouceDemo();
    }

    @AfterAll
    public static void  finish(){
        DriverSingelton.delay(3);
        DriverSingelton.closeObjectInstance();
    }

    //TC-SD-001
    @Given("user on login page")
    public void go_to_website(){
        driver.get(Constants.URLSAUCEDEMO);
    }
    @When("User input valid username")
    public void input_username(){
        loginSouceDemo.inputUsername("standard_user");
    }
    //TC-SD-001
    @And("User input valid password")
    public void user_input_valid_password(){
        loginSouceDemo.inputPassword("secret_sauce");
    }
    //TC-SD-001
    @And("User click button login")
    public void user_click_btn_login(){
        loginSouceDemo.clickBtnLogin();
    }
    //TC-SD-001
    @Then("user redirect to inventory")
    public void user_get_title_dashboard(){
        Assert.assertEquals(loginSouceDemo.getTextInventory(),"Products");
    }

    //TC-SD-002
//    @Given("user on login page")
//    public void user_on_login_page(){
//        loginSouceDemo.quickLogout();
//    }

    //TC-SD-002
    @When("User input locked username")
    public void user_input_locked_username(){
        loginSouceDemo.inputUsername("locked_out_user");
    }
    @When("User input locked password")
    public void user_input_locked_password(){
        loginSouceDemo.inputPassword("secret_sauce");
    }
    //TC-SD-002
    // Sorry, this user has been locked out.
    @Then("show error account locked")
    public void error_locked(){
        String err = loginSouceDemo.getErrorLocked();
        Assert.assertEquals(err,"Epic sadface: Sorry, this user has been locked out.");
    }



}
